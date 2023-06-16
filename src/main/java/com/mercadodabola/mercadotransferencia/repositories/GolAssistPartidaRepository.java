package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

@Repository
public interface GolAssistPartidaRepository extends JpaRepository<GolAssistPartidaEntity, Long>{

	@Query(value = "select jogador.nome, count(gol_assist_partida.tipo_lance), clube.nome from gol_assist_partida\r\n"
			+ "inner join jogador on gol_assist_partida.jogador_id=jogador.id\r\n"
			+ "inner join clube on gol_assist_partida.clube_id=clube.id\r\n"
			+ "where gol_assist_partida.tipo_lance = 'GOL' group by jogador_id  ;", nativeQuery = true)
	List<GolAssistPartidaEntity> listaGols(long jogadorId, TipoGolAssist tipoGolAssist, long clubeId);
	
	@Query(value = "select jogador.nome, count(gol_assist_partida.tipo_lance), clube.nome from gol_assist_partida\r\n"
			+ "inner join jogador on gol_assist_partida.jogador_id=jogador.id\r\n"
			+ "inner join clube on gol_assist_partida.clube_id=clube.id\r\n"
			+ "where gol_assist_partida.tipo_lance = 'ASSISTENCIA' group by jogador_id ;", nativeQuery = true)
	List<GolAssistPartidaEntity> listaAssistencia(long jogadorId, TipoGolAssist tipoGolAssist, long clubeId);
}


