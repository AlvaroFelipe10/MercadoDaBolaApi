package com.mercadodabola.mercadotransferencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;

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
	
	@Query(value = " select count(golassis.tipo_lance) from gol_assist_partida golassis\r\n"
			+ " inner join clube cb on golassis.clube_id=cb.id\r\n"
			+ " where golassis.tipo_lance = 'gol' and  clube_id = :clubeId", nativeQuery = true)
	Long qtdGolsFeitos(Long clubeId);
	
	@Query(value = "select count(gol_assist_partida.tipo_lance) from gol_assist_partida\r\n"
			+ "inner join clube on gol_assist_partida.clube_id=clube.id\r\n"
			+ "inner join campeonato on gol_assist_partida.campeonato_id=campeonato.id\r\n"
			+ "where gol_assist_partida.tipo_lance = \"gol\" and clube.id = :clubeId and campeonato.id = :campeonatoId", nativeQuery = true)
	Long qtdGolsClubesTab (long campeonatoId, long clubeId);
	
	@Query(value = "select count(gol_assist_partida.tipo_lance) from gol_assist_partida\r\n"
			+ "inner join clube on gol_assist_partida.clube_id=clube.id\r\n"
			+ "inner join campeonato on gol_assist_partida.campeonato_id=campeonato.id\r\n"
			+ "where gol_assist_partida.tipo_lance = \"gol\" and  clube.id  NOT IN (:clubeId) and campeonato.id = :campeonatoId and partida_id = :partidaId", nativeQuery = true)
	Long qtdGolsTomadosTab (long campeonatoId, long clubeId, long partidaId);
	
	
}


