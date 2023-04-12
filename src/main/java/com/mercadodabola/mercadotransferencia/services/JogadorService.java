package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.IdadeNaoPermitadaException;
import com.mercadodabola.mercadotransferencia.domain.exception.NegocioException;
import com.mercadodabola.mercadotransferencia.domain.exception.PeriodoContratoInvalidoException;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaIdade;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaTempoContrato;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private JogadorConverter jogadorConverter;

	@Autowired
	private ClubeRepository clubeRepository;

	@Autowired
	private CalculaIdade calculaIdade;

	@Autowired
	private CalculaTempoContrato calculaTempo;

	public JogadorEntity salvar(JogadorEntity jogador) {
//		
//		Long clubeId = jogador.getClube().getId();
//		ClubeEntity clube = clubeRepository.findById(clubeId).orElseThrow(() -> new ClubeNaoEncontradoException(
//				String.format("Não existe um cadastro de clube com o código %d", clubeId)));
//		jogador.setClube(clube);

		if (calculaIdade.isIdadeValida(jogador.getDataNascimento())) {
			return jogadorRepository.save(jogador);
		} else {
			throw new IdadeNaoPermitadaException(calculaIdade.getIdade(jogador.getDataNascimento()));
		}

	}

	public List<JogadorListDto> listar(String nome) {

		List<JogadorListDto> retorno = new ArrayList<>();

		if (StringUtils.isEmpty(nome) || nome.length() < 3) {
			throw new NegocioException("Passar no mínimo 3 letras no nome");
		} else {
			List<JogadorEntity> listEntity = jogadorRepository.findTodosByNomeContaining(nome.trim());
			listEntity.forEach(jogadorEntity -> {
				JogadorListDto dto = jogadorConverter.listToJogadorDto(jogadorEntity);
				retorno.add(dto);
			});
		}

		return retorno;
	}

	public ResponseEntity<JogadorDto> buscar(Long jogadorId) {
		Optional<JogadorEntity> jogador = jogadorRepository.findById(jogadorId);
		if (jogador != null) {
			return ResponseEntity.ok(jogadorConverter.toJogadorDto(jogador.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
