package com.mercadodabola.mercadotransferencia.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;

@Repository
public interface ContratoRepository extends JpaRepository <ContratoEntity, Long>{
	
	List<ContratoEntity> findByClubeId(Long clubeId);
	
	ContratoEntity findByJogadorId(Long jogadorId);
	
	int countByClubeId(Long clubeId);
	
	Page<ContratoEntity> findAll(Pageable pageble);
	
	@Query(value = "SELECT * FROM contrato order by salario DESC LIMIT 10", nativeQuery = true)
	List<ContratoEntity> porOrdemSalarioMaior();
	
	@Query(value = "SELECT * FROM contrato order by salario ASC LIMIT 10", nativeQuery = true)
	List<ContratoEntity> porOrdemSalarioMenor();
	
	@Query(value = "SELECT sum(salario) FROM contrato WHERE clube_id", nativeQuery = true)
	BigDecimal obterSalarioTotal(Long clubeId);
	
	
	
}
