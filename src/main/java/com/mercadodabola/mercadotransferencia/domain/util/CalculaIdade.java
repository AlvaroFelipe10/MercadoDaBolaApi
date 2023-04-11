package com.mercadodabola.mercadotransferencia.domain.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CalculaIdade {
	
	public Integer getIdade(LocalDate dataNascimento) {
		Date dateNascimento = Date.from(dataNascimento.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dataAtual = new Date();

		Long dateNascimentoMs = dateNascimento.getTime();
		Long dateAtualMs = dataAtual.getTime();

		Long diferencaDatas = dateAtualMs - dateNascimentoMs;
		
		return (int) (diferencaDatas / 1000 / 60 / 60 / 24 / 365);
		
	}
	
	public Boolean isIdadeValida(LocalDate dataNascimento) {
		Integer idade = getIdade(dataNascimento);
		if (idade < 18 || idade >= 30) {
			return false;
		}
		return true;
	}

	
}
