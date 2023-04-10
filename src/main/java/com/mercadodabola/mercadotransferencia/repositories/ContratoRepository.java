package com.mercadodabola.mercadotransferencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;

@Repository
public interface ContratoRepository extends JpaRepository <ContratoEntity, Long>{

}
