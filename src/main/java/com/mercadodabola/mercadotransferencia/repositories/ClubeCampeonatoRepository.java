package com.mercadodabola.mercadotransferencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;

@Repository
public interface ClubeCampeonatoRepository  extends JpaRepository <ClubeCampeonatoEntity, Long> {
	
	
	@Query(value = "SELECT * FROM clube_campeonato"
			+ " WHERE clube_id = :mandanteId"
			+ " AND campeonato_id = :campeonatoId",  nativeQuery = true)
	ClubeCampeonatoEntity verificaRodadaMandante(Long mandanteId, Long campeonatoId);
	
	@Query(value = "SELECT * FROM clube_campeonato"
			+ " WHERE clube_id = :visitanteId"
			+ " AND campeonato_id = :campeonatoId",  nativeQuery = true)
	ClubeCampeonatoEntity verificaRodadaVisitante(Long visitanteId, Long campeonatoId);
	
	@Query(value = "select clube_campeonato.pontos\r\n"
			+ " from clube_campeonato\r\n"
			+ " where clube_campeonato.clube_id = :clubeId", nativeQuery = true)
	Long qtdPontos(Long clubeId);
	
	@Query(value = " select clube_campeonato.vitorias"
			+ " from clube_campeonato"
			+ " where clube_campeonato.clube_id = :clubeId", nativeQuery = true)
	Long qtdVitorias(Long clubeId);
	
	@Query(value = " select clube_campeonato.derrotas"
			+ " from clube_campeonato"
			+ " where clube_campeonato.clube_id = :clubeId", nativeQuery = true)
	Long qtdDerrotas(Long clubeId);
	
	@Query(value = " select clube_campeonato.empates"
			+ " from clube_campeonato"
			+ " where clube_campeonato.clube_id = :clubeId", nativeQuery = true)
	Long qtdEmpates(Long clubeId);
	
//	@Query(value = "select clube.id,\r\n"
//			+ "(select sum(partida.gols_mandante or partida.gols_visitante)\r\n"
//			+ "from partida\r\n"
//			+ "where partida.mandante_id = :clubeId or partida.visitante_id = :clubeId and campeonato_id = :campeonatoId) \r\n"
//			+ "from clube_campeonato\r\n"
//			+ "inner join clube on clube_campeonato.clube_id=clube.id\r\n"
//			+ "where clube_campeonato.campeonato_id = :campeonatoId and clube.id = :clubeId\r\n"
//			+ "group by clube.id", nativeQuery = true)						
//	Long qtdGols(Long clubeId, Long campeonatoId);
}
