package com.mercadodabola.mercadotransferencia.domain.exception;

public class PeriodoContratoInvalidoException extends NegocioException {
	
	private static final long serialVersionUID = 1L;
	
	public PeriodoContratoInvalidoException(String mensagem) {
		super(mensagem);
	}
		
	public PeriodoContratoInvalidoException(Long contrato) {
		this(String.format("Data de contrato não permitido %d", contrato));
	}
}
