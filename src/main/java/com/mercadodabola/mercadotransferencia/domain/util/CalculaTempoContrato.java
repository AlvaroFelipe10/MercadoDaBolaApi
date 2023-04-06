package com.mercadodabola.mercadotransferencia.domain.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CalculaTempoContrato {
	
	public String getTempoRestante(LocalDate dataInicio, LocalDate dataTermino) {
		String retorno = "";
		Date dateInicio = Date.from(dataInicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dateTermino = Date.from(dataTermino.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		Long dateInicioMs = dateInicio.getTime();
		Long dateTerminoMs = dateTermino.getTime();
		
		Long diferencaDatas = dateTerminoMs - dateInicioMs;
		Long diasTotais = diferencaDatas / 1000 / 60 / 60 / 24 / 365;
		
//		if(diasTotais > 365) {
//			
//		}
		
		return retorno;
	}
		
}
