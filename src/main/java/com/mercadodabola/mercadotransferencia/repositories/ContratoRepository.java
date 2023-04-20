package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

@Repository
public interface ContratoRepository extends JpaRepository <ContratoEntity, Long>{
	
	List<ContratoEntity> findByClubeId(Long clubeId);
	
	ContratoEntity findByJogadorId(Long jogadorId);
	
	int countByClubeId(Long clubeId);
	
}
