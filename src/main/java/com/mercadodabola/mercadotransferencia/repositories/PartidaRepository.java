package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;


@Repository
public interface PartidaRepository  extends JpaRepository<PartidaEntity, Long> {
	
	@Query(value = "SELECT * FROM partida WHERE (mandante_id = :mandanteId or visitante_id = :visitanteId ) AND campeonato_id = :campeonatoId AND numero_rodada = :numeroRodada ",  nativeQuery = true)
	int countByVerificaPartidaId(Long mandanteId, Long visitanteId, Long campeonatoId, Integer numeroRodada);
	
}
