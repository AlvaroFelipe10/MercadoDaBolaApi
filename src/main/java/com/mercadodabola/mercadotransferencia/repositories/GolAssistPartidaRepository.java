package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

@Repository
public interface GolAssistPartidaRepository extends JpaRepository<GolAssistPartidaEntity, Long>{

	@Query(value = "select count(golassis.tipo_lance) from gol_assist_partida golassis\r\n"
			+ "inner join jogador jog on golassis.jogador_id=jog.id\r\n"
			+ "where golassis.tipo_lance = 'gol' and golassis.clube_id = :clubeId and jogador_id = :jogadorId\r\n"
			+ "group by golassis.jogador_id;" , nativeQuery = true)
	Long qtdGolsClube(long clubeId, long jogadorId);
	
	@Query(value = "select count(golassis.tipo_lance) from gol_assist_partida golassis\r\n"
			+ "inner join jogador jog on golassis.jogador_id=jog.id\r\n"
			+ "where golassis.tipo_lance = 'assistencia' and golassis.clube_id = :clubeId and jogador_id = :jogadorId\r\n"
			+ "group by golassis.jogador_id;",  nativeQuery = true)
	Long qtdAssistenciasClube(Long clubeId, long jogadorId);
	
	@Query(value = "select count(golassis.tipo_lance) from gol_assist_partida golassis\r\n"
			+ "inner join jogador jog on golassis.jogador_id=jog.id\r\n"
			+ "where golassis.tipo_lance = 'assistencia' and jogador_id = :jogadorId\r\n"
			+ "group by golassis.jogador_id;",  nativeQuery = true)
	Long qtdAssistenciasCarreira(long jogadorId);
	
	@Query(value = "select count(golassis.tipo_lance) from gol_assist_partida golassis\r\n"
			+ "inner join jogador jog on golassis.jogador_id=jog.id\r\n"
			+ "where golassis.tipo_lance = 'gol' and jogador_id = :jogadorId\r\n"
			+ "group by golassis.jogador_id;",  nativeQuery = true)
	Long qtdGolsCarreira(long jogadorId);
	
	
}


