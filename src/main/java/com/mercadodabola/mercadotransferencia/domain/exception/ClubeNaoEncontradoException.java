package com.mercadodabola.mercadotransferencia.domain.exception;

public class ClubeNaoEncontradoException extends EntidadeNaoEncontradaException {

	public ClubeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ClubeNaoEncontradoException(long clubeId) {
		this(String.format("Não existe um cadastro de clube com o código %d", clubeId));
	}
}
