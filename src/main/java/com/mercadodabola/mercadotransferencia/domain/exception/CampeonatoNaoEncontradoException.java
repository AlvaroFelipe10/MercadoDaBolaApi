package com.mercadodabola.mercadotransferencia.domain.exception;

public class CampeonatoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public CampeonatoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CampeonatoNaoEncontradoException(long campeonatoId) {
		this(String.format("Não existe um cadastro de campeonato com o código %d", campeonatoId));
	}
}
