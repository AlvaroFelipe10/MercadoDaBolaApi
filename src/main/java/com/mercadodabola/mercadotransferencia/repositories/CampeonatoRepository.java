package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;

@Repository
public interface CampeonatoRepository extends JpaRepository<CampeonatoEntity, Long> {

	List<CampeonatoEntity> findByCampeonatoId(long campeonatoId);
}
