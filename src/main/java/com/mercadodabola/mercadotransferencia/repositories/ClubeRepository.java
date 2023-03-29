package com.mercadodabola.mercadotransferencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;

@Repository
public interface ClubeRepository extends JpaRepository<ClubeEntity, Long>{

}
