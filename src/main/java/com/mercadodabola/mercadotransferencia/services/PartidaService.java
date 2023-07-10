package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoId;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.MandanteOuVisitante;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;
import com.mercadodabola.mercadotransferencia.domain.exception.CampeonatoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.ClubeNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.NegocioException;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;

	@Autowired
	private ClubeRepository clubeRepository;

	@Autowired
	private CampeonatoRepository campeonatoRepository;

	@Autowired
	private ClubeCampeonatoRepository clubeCampeonatoRepository;

	@Autowired
	private GolAssistPartidaRepository golAssistRepository;

	@Autowired
	private GolAssistPartidaService golAssistService;

	@Autowired
	private JogadorRepository jogadorRepository;

	private static final String MSG_CLUBE_JOGOU = "Um dos clubes ja jogou essa rodada";
	private static final String MSG_RODADA_INVALIDA = "Essa rodada está invalida, verifique a sequência das rodadas";
	private static final String MSG_CAMPEONATO_INVALIDO = "Não temos um cadastro deste campeonato";
	private static final String MSG_MANDANTE_INVALIDO =  "Não temos um cadastro deste mandante, verifique o cadastro de clubes neste campeonato";
	private static final String MSG_VISITANTE_INVALIDO = "Não temos um cadastro deste visitante, verifique o cadastro de clubes neste campeonato";
	
	public PartidaEntity salvar(PartidaEntity partidaEntity) {
		return partidaRepository.save(partidaEntity);
	}

	public List<PartidaEntity> listar() {
		return partidaRepository.findAll();
	}

	public PartidaEntity cadastroPartida(PartidaDto partidaDto) {
		ClubeEntity mandante = clubeRepository.findById(partidaDto.getMandanteId())
				.orElseThrow(() -> new ClubeNaoEncontradoException(MSG_MANDANTE_INVALIDO));
		CampeonatoEntity campeonato = campeonatoRepository.findById(partidaDto.getCampeonatoId())
				.orElseThrow(() -> new CampeonatoNaoEncontradoException(MSG_CAMPEONATO_INVALIDO));
		ClubeEntity visitante = clubeRepository.findById(partidaDto.getVisitanteId())
				.orElseThrow(() -> new ClubeNaoEncontradoException(MSG_VISITANTE_INVALIDO));;
		PartidaEntity partidaEntity = new PartidaEntity();
		partidaEntity.setId(partidaDto.getPartidaId());
		partidaEntity.setMandante(mandante);
		partidaEntity.setVisitante(visitante);
		partidaEntity.setCampeonato(campeonato);
		partidaEntity.setNumeroRodada(partidaDto.getRodada());
		partidaEntity.setDataHoraPartida(partidaDto.getDataEHora());
		partidaEntity.setPublico(partidaDto.getPublico());
		partidaEntity.setRenda(partidaDto.getRenda());
		partidaEntity.setGolsMandante(qtdGols(partidaDto.getGolAssistencia(), MandanteOuVisitante.MANDANTE));
		partidaEntity.setGolsVisitante(qtdGols(partidaDto.getGolAssistencia(), MandanteOuVisitante.VISITANTE));
		this.verficaPartida(partidaDto.getMandanteId(), partidaDto.getVisitanteId(), partidaDto.getCampeonatoId(),
				partidaDto.getRodada());
		this.verificaRodadaValida(campeonato, partidaDto);
		this.somarPontosMandante(partidaEntity, partidaDto);
		this.somarPontosVisitante(partidaEntity, partidaDto);
		this.somarDinheiroCaixa(partidaDto);
		partidaRepository.save(partidaEntity);
		this.cadastroDeGolAssist(partidaDto);
		return partidaRepository.save(partidaEntity);
	}

	public void cadastroDeGolAssist(PartidaDto partidaDto) {
		List<GolAssistPartidaEntity> golAssistPartidaEntity = new ArrayList<>();
		partidaDto.getGolAssistencia().forEach(golAssistDto -> {
			GolAssistPartidaEntity dto = golAssistService.cadastrar(golAssistDto, partidaDto);
			golAssistPartidaEntity.add(dto);
		});
	}

	private Long qtdGols(List<GolAssistenciaDto> golsAssistencia, MandanteOuVisitante mandanteouVisitante) {
		return CollectionUtils.isEmpty(golsAssistencia) ? 0L
				: golsAssistencia.stream().filter(gol -> gol.getTipoLance() == TipoGolAssist.GOL
						&& gol.getMandanteOuVisitante() == mandanteouVisitante).count();

	}

	private void verficaPartida(Long mandanteId, Long visitanteId, Long campeonatoId, Integer numeroRodada) {
		List<PartidaEntity> verificarPartida = partidaRepository.VerificaPartida(mandanteId, visitanteId, campeonatoId,
				numeroRodada);
		if (!CollectionUtils.isEmpty(verificarPartida)) {
			throw new NegocioException(MSG_CLUBE_JOGOU);
		}
	}

	private void verificaRodadaValida(CampeonatoEntity campeonatoEntity, PartidaDto partidaDto) {
		CampeonatoEntity campeonatoId = campeonatoRepository.findById(partidaDto.getCampeonatoId()).get();
		ClubeCampeonatoEntity clubeCampeonato = clubeCampeonatoRepository
				.verificaRodadaMandante(partidaDto.getMandanteId(), partidaDto.getCampeonatoId());
		ClubeCampeonatoEntity clube = clubeCampeonatoRepository.verificaRodadaVisitante(partidaDto.getVisitanteId(),
				partidaDto.getCampeonatoId());

		long quantidadeRodadas = campeonatoId.getQuantidadeClubes()
				* campeonatoEntity.getTipoDeCampeonato().valorTipoCampeonato
				- campeonatoEntity.getTipoDeCampeonato().valorTipoCampeonato;
		long rodadaAtual = quantidadeRodadas - clubeCampeonato.getRodadasRestantes() + 1;
		if (rodadaAtual != partidaDto.getRodada()) {
			throw new NegocioException(MSG_RODADA_INVALIDA);

		}
	}

//	private void somarGols(PartidaEntity partidaEntity) {
//		GolAssistPartidaEntityId golAssistPartidaEntityId = new GolAssistPartidaEntityId();
//		GolAssistPartidaEntity golAssistPartidaEntity = new GolAssistPartidaEntity();
//		
//		golAssistPartidaEntityId.setPartida(partidaEntity);
//		golAssistPartidaEntity.setId(golAssistPartidaEntityId);
//		golAssistRepository.save(golAssistPartidaEntity);
//
//	}
	
	private void somarDinheiroCaixa(PartidaDto partidaDto) {
		ClubeEntity clubeEntity = clubeRepository.findById(partidaDto.getMandanteId()).get();
		clubeEntity.setCaixa(clubeEntity.getCaixa().add(partidaDto.getRenda()));
		clubeRepository.save(clubeEntity);
	}

	private void somarPontosMandante(PartidaEntity partidaEntity, PartidaDto partidaDto) {
		ClubeCampeonatoEntity clubeCampeonato = clubeCampeonatoRepository
				.verificaRodadaMandante(partidaDto.getMandanteId(), partidaDto.getCampeonatoId());
		CampeonatoEntity campeonato = campeonatoRepository.findById(partidaDto.getCampeonatoId()).get();
		ClubeCampeonatoId clubeCampeonatoId = new ClubeCampeonatoId();
		clubeCampeonatoId.setCampeonatoId(campeonato);
		clubeCampeonatoId.setClubeId(clubeCampeonato.getId().getClubeId());
		clubeCampeonato.setId(clubeCampeonatoId);
		clubeCampeonato.setRodadasRestantes(clubeCampeonato.getRodadasRestantes() - 1);
		if(partidaEntity.getGolsMandante() > partidaEntity.getGolsVisitante()) {
			clubeCampeonato.setPontos(+ 3);
			clubeCampeonato.setVitorias(+ 1);
		} else if (partidaEntity.getGolsMandante() == partidaEntity.getGolsVisitante()) {
			clubeCampeonato.setPontos(+ 1);
			clubeCampeonato.setEmpates(+ 1);

		} else {
			clubeCampeonato.setDerrotas(+ 1);

		}
			
		clubeCampeonatoRepository.save(clubeCampeonato);
	}
	
	private void somarPontosVisitante(PartidaEntity partidaEntity, PartidaDto partidaDto) {
		ClubeCampeonatoEntity clubeCampeonato = clubeCampeonatoRepository.verificaRodadaVisitante(partidaDto.getVisitanteId(),
				partidaDto.getCampeonatoId());
		CampeonatoEntity campeonato = campeonatoRepository.findById(partidaDto.getCampeonatoId()).get();
		ClubeCampeonatoId clubeCampeonatoId = new ClubeCampeonatoId();
		clubeCampeonatoId.setCampeonatoId(campeonato);
		clubeCampeonatoId.setClubeId(clubeCampeonato.getId().getClubeId());
		clubeCampeonato.setId(clubeCampeonatoId);
		clubeCampeonato.setRodadasRestantes(clubeCampeonato.getRodadasRestantes() - 1);
		if (partidaEntity.getGolsVisitante() > partidaEntity.getGolsMandante()) {
			clubeCampeonato.setPontos(+ 3) ;
			clubeCampeonato.setVitorias(+ 1);
		} else if (partidaEntity.getGolsMandante() == partidaEntity.getGolsVisitante()) {
			clubeCampeonato.setPontos(+ 1);
			clubeCampeonato.setEmpates(+ 1);
		} else {
			clubeCampeonato.setDerrotas(+ 1);

		}
		clubeCampeonatoRepository.save(clubeCampeonato);
	}
}
	

//	private Long qtdGolsVisitanteSemStream(List<GolAssistenciaDto> golsAssistencia) {
//		Long qtdGols = 0L;
//		
//		if(CollectionUtils.isEmpty(golsAssistencia)) {
//			return qtdGols;
//		} else {
//			for (GolAssistenciaDto gol : golsAssistencia) {
//				if(gol.getMandanteOuVisitante() == MandanteOuVisitante.VISITANTE
//						&& gol.getTipoLance() == TipoGolAssist.GOL) {
//					qtdGols++;
//				}
//			}
//		}
//		return qtdGols;
//	}
/*
 * List<GolAssistPartidaEntity> golAssistEntity = new ArrayList<>();
 * List<GolAssistenciaDto> golAssist = partidaDto.getGolAssistencia();
 * golAssist.forEach(golAssistPartidaEntity -> { GolAssistPartidaEntity dto =
 * golAssistConv.listGolAssistenciaDto(); golAssist.add(dto); });
 */
