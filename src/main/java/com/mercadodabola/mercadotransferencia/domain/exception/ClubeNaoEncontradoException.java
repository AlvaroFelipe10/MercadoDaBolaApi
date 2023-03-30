package com.mercadodabola.mercadotransferencia.domain.exception;

public class ClubeNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public ClubeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ClubeNaoEncontradoException(Long clubeId) {
		this(String.format("Não existe um cadastro de clube com o código %d", clubeId));
	}
}
