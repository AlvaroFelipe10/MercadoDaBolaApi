package com.mercadodabola.mercadotransferencia.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferenciaJogadorDto {

	private Long clubeOrigemId;
	private Long clubeDestinoId;
	private Long jogadorId;
	private String multa;
	private String valorDaTransferencia;
	private String salario;
}
