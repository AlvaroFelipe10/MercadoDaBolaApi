package com.mercadodabola.mercadotransferencia.domain.exception;

public class IdadeNaoPermitadaException extends NegocioException {
	
	private static final long serialVersionUID = 1L;
	
	public IdadeNaoPermitadaException(String mensagem) {
		super(mensagem);
	}
	
	public IdadeNaoPermitadaException(Integer idade) {
		this(String.format("Idade não permitada %d", idade));
	}

}
