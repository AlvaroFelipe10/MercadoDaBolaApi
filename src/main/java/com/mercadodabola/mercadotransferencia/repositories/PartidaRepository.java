package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;


@Repository
public interface PartidaRepository  extends JpaRepository<PartidaEntity, Long> {
	
	@Query(value = "SELECT * FROM partida WHERE (mandante_id IN (:mandanteId, :visitanteId) or visitante_id IN (:visitanteId, :mandanteId)) AND campeonato_id = :campeonatoId AND numero_rodada = :numeroRodada ",  nativeQuery = true)
	List<PartidaEntity> VerificaPartida(Long mandanteId, Long visitanteId, Long campeonatoId, Integer numeroRodada);
	
	List<PartidaEntity> findByCampeonatoId(Long campeonatoId);
	
	@Query(value ="select sum(coalesce(\r\n"
			+ "(select sum(part.gols_mandante) as gols_feitos_mandante\r\n"
			+ "from partida part\r\n"
			+ "inner join clube_campeonato clube_camp ON clube_camp.clube_id = part.mandante_id\r\n"
			+ "inner join clube clube ON clube.id = clube_camp.clube_id\r\n"
			+ "inner join campeonato camp ON camp.id = clube_camp.campeonato_id\r\n"
			+ "WHERE part.mandante_id = :clubeId\r\n"
			+ "AND camp.id = :campeonatoId) , 0) +\r\n"
			+ "COALESCE((select sum(part.gols_visitante)as gols_feitos_visitante from partida part\r\n"
			+ "inner join clube_campeonato clube_camp ON clube_camp.clube_id = part.visitante_id\r\n"
			+ "inner join clube clube ON clube.id = clube_camp.clube_id\r\n"
			+ "inner join campeonato camp ON camp.id = clube_camp.campeonato_id\r\n"
			+ "WHERE part.visitante_id = :clubeId\r\n"
			+ "AND camp.id = :campeonatoId), 0))", nativeQuery = true)
	Long qtdGolsClubeCampeonato(Long clubeId, Long campeonatoId);
	
	@Query(value = "select sum(coalesce(\r\n"
			+ "(select sum(part.gols_visitante) as gols_feitos_mandante\r\n"
			+ "from partida part\r\n"
			+ "inner join clube_campeonato clube_camp ON clube_camp.clube_id = part.mandante_id\r\n"
			+ "inner join clube clube ON clube.id = clube_camp.clube_id\r\n"
			+ "inner join campeonato camp ON camp.id = clube_camp.campeonato_id\r\n"
			+ "WHERE part.mandante_id = :clubeId\r\n"
			+ "AND camp.id = :campeonatoId) , 0) +\r\n"
			+ "COALESCE((select sum(part.gols_mandante)as gols_feitos_visitante from partida part\r\n"
			+ "inner join clube_campeonato clube_camp ON clube_camp.clube_id = part.visitante_id\r\n"
			+ "inner join clube clube ON clube.id = clube_camp.clube_id\r\n"
			+ "inner join campeonato camp ON camp.id = clube_camp.campeonato_id\r\n"
			+ "WHERE part.visitante_id = :clubeId\r\n"
			+ "AND camp.id = :campeonatoId), 0))", nativeQuery = true)
	Long qtdGolsClubeTomadosCampeonato (Long clubeId, Long campeonatoId);
}
 