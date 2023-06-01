package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntityId;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ClubeNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.JogadorNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	@Autowired 
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	public GolAssistPartidaEntity salvar(GolAssistPartidaEntity golAssist) {
		return golAssistRepository.save(golAssist);
	}

	public GolAssistPartidaEntity cadastrar(GolAssistenciaDto golAssistDto, PartidaDto partidaDto) {
		GolAssistPartidaEntity golAssistPartidaEntity = new GolAssistPartidaEntity();
		GolAssistPartidaEntityId golAssistPartidaEntityId = new GolAssistPartidaEntityId();
		JogadorEntity jogador = jogadorRepository.findById(golAssistDto.getIdJogador())
				.orElseThrow((() -> new JogadorNaoEncontradoException(
						String.format("Não existe um cadastro de jogador com este Id"))));
		PartidaEntity partida = partidaRepository.findById(partidaDto.getPartidaId()).get();
		
		golAssistPartidaEntity.setMinutoSegundos(golAssistDto.getMinutoSegundo());
		golAssistPartidaEntity.setTipoLance(golAssistDto.getTipoLance());
		
		golAssistPartidaEntityId.setIdJogador(jogador);
		golAssistPartidaEntityId.setPartida(partida);
		
		golAssistPartidaEntity.setId(golAssistPartidaEntityId);
		 
		return golAssistRepository.save(golAssistPartidaEntity);
		
	}
	
	

		
}
