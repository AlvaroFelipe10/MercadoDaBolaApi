package com.mercadodabola.mercadotransferencia.repositories;

import java.math.BigDecimal;
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
	
	/*
	 * @Query(value = "SELECT quantidade_clubes FROM campeonato", nativeQuery =
	 * true) Long obterQtdClubes(Long campeonatoId);
	 */
}
