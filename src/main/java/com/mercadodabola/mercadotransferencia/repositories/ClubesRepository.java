package com.mercadodabola.mercadotransferencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.Clube;

@Repository
public interface ClubesRepository extends JpaRepository<Clube, Long>{

}
