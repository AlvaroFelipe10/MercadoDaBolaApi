package com.mercadodabola.mercadotransferencia.domain.exception;

public class JogadorNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	
	public JogadorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public JogadorNaoEncontradoException(Long jogadorId) {
		this(String.format(("Não existe um cadastro de jogador com o codigo %d"), jogadorId));
	}
}
