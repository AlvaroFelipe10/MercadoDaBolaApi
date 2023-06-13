package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;

@Repository
public interface GolAssistPartidaRepository extends JpaRepository<GolAssistPartidaEntity, Long>{


	@Query(value = "select nome, count(tipo_lance) from jogador inner join gol_assist_partida on gol_assist_partida.jogador_id=jogador.id group by tipo_lance;;", nativeQuery = true)
	List<GolAssistPartidaEntity> verificaGols() ;
	
}
