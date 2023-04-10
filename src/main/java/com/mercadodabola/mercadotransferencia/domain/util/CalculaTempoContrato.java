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
		
		Long diferencaDatas = dateTerminoMs - dateInicioMs ;
		Long mesesTotais = diferencaDatas / 1000 / 60 / 60 / 24 / 30;
				
		String retorno = "";
		
		if (mesesTotais == 12) {
			return retorno = "O jogador tem 1 ano de contrato";
		} else if (mesesTotais == 13) {
			return retorno = "O jogador tem 1 ano e 1 mês de contrato";
		} else if (mesesTotais == 14) {
			return retorno ="O jogador tem 1 ano e 2 meses de contrato";
		} else if (mesesTotais == 15) {
			return retorno ="O jogador tem 1 ano e 3 meses de contrato";
		}else if (mesesTotais == 16) {
				return retorno ="O jogador tem 1 ano e 4 meses de contrato";
		}else if (mesesTotais == 17) {
			return retorno ="O jogador tem 1 ano e 5 meses de contrato";
		}else if (mesesTotais == 18) {
			return retorno ="O jogador tem 1 ano e 6 meses de contrato";
		}else if (mesesTotais == 19) {
			return retorno ="O jogador tem 1 ano e 7 meses de contrato";
		}else if (mesesTotais == 20) {
			return retorno ="O jogador tem 1 ano e 8 meses de contrato";
		}else if (mesesTotais == 21) {
			return retorno ="O jogador tem 1 ano e 9 meses de contrato";
		}else if (mesesTotais == 22) {
			return retorno ="O jogador tem 1 ano e 10 meses de contrato";
		}else if (mesesTotais == 23) {
			return retorno ="O jogador tem 1 ano e 11 meses de contrato";
		}else if (mesesTotais == 24) {
			return retorno ="O jogador tem 2 anos de contrato";
		} 
		
		return retorno;
	}
	
	public Boolean isValidContrato(LocalDate dataInicio, LocalDate dataTermino) {
		Date dateInicio = Date.from(dataInicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dateTermino = Date.from(dataTermino.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		Long dateInicioMs = dateInicio.getTime();
		Long dateTerminoMs = dateTermino.getTime();
		
		Long diferencaDatas = dateTerminoMs - dateInicioMs ;
		Long mesesTotais = diferencaDatas / 1000 / 60 / 60 / 24 / 30;
		
		if(mesesTotais > 24 ) {
			return false;
		}
		
		return true;
	}
		
	
}
