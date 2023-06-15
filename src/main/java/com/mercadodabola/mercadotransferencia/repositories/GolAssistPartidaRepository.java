package com.mercadodabola.mercadotransferencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

@Repository
public interface GolAssistPartidaRepository extends JpaRepository<GolAssistPartidaEntity, Long>{

	@Query(value = "select jogador.nome, count(gol_assist_partida.tipo_lance) from jogador \r\n"
			+ "inner join gol_assist_partida on gol_assist_partida.jogador_id=jogador.id\r\n"
			+ "where gol_assist_partida.tipo_lance = 'GOL' group by jogador_id ;", nativeQuery = true)
	List<GolAssistPartidaEntity> listaGols(long jogadorId, TipoGolAssist tipoGolAssist);
}

