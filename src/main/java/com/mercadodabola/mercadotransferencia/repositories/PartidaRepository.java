package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;


@Repository
public interface PartidaRepository  extends JpaRepository<PartidaEntity, Long> {
	
	@Query(value = "SELECT * FROM partida WHERE (mandante_id   or visitante_id ) AND campeonato_id = 1 AND numero_rodada ",  nativeQuery = true)
	List<PartidaEntity> verificaPartida(Long mandanteId, Long visitanteId, Long campeonatoId, Long numero_rodada);
}
