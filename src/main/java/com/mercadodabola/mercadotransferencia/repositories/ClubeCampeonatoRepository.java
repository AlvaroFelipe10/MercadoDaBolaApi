package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;

@Repository
public interface ClubeCampeonatoRepository  extends JpaRepository <ClubeCampeonatoEntity, Long> {
	
	@Query(value = "SELECT * FROM clube_campeonato WHERE clube_id = :mandanteId AND campeonato_id = :campeonatoId",  nativeQuery = true)
	ClubeCampeonatoEntity verificaRodadaMandante(Long mandanteId, Long campeonatoId);
	
	@Query(value = "SELECT * FROM clube_campeonato WHERE clube_id = :visitanteId AND campeonato_id = :campeonatoId",  nativeQuery = true)
	ClubeCampeonatoEntity verificaRodadaVisitante(Long visitanteId, Long campeonatoId);
	
	
}
