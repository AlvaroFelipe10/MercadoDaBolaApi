package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
	
	List<JogadorEntity> findTodosByNomeContaining (String nome);
	
 

}
