package com.mercadodabola.mercadotransferencia.domain.exception;

public class ContratoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public ContratoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ContratoNaoEncontradoException(long contratoId) {
		this(String.format("Não existe um cadastro de contrato com o id %d", contratoId));
	}
}
