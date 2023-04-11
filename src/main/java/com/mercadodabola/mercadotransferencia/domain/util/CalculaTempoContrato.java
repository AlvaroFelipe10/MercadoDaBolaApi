package com.mercadodabola.mercadotransferencia.domain.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CalculaTempoContrato {

	public String getTempoRestante(LocalDate dataInicio, LocalDate dataTermino) {

		Date dateInicio = Date.from(dataInicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dateTermino = Date.from(dataTermino.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		Long dateInicioMs = dateInicio.getTime();
		Long dateTerminoMs = dateTermino.getTime();

		Long diferencaDatas = dateTerminoMs - dateInicioMs;
		Long mesesTotais = diferencaDatas / 1000 / 60 / 60 / 24 / 30;

		if (mesesTotais < 12) {
			return "O jogador tem " + mesesTotais + "de contrato";
		} else {
			Integer resto = mesesTotais.intValue() % 12;
			if (resto == 0) {
				resto = mesesTotais.intValue() / 12;
			}
			String retorno = "";
			for (int i = 1; i <= resto; i++) {
				retorno = "O jogador tem " 
			    + i + ""
			    + " ano" + (i > 1 ? "s" : "")
				+ (mesesTotais > (12 * i) ? 
						" e " +  (Integer.valueOf(mesesTotais.intValue() - (12 * i))).toString()
						+ " mes" + ((mesesTotais.intValue() - (12 * i)) > 1 ? "es" : "") : "");
			}
			return retorno;
		} 

	}

	public Boolean isValidContrato(LocalDate dataInicio, LocalDate dataTermino) {
		Date dateInicio = Date.from(dataInicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dateTermino = Date.from(dataTermino.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		Long dateInicioMs = dateInicio.getTime();
		Long dateTerminoMs = dateTermino.getTime();

		Long diferencaDatas = dateTerminoMs - dateInicioMs;
		Long mesesTotais = diferencaDatas / 1000 / 60 / 60 / 24 / 30;

		if (mesesTotais > 24) {
			return false;
		}

		return true;
	}

}
