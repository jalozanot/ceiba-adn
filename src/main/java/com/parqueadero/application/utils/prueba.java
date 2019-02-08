package com.parqueadero.application.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class prueba {
	public static void main(String[] args) {

		LocalDateTime time = LocalDateTime.now();
		LocalDateTime time2 = LocalDateTime.now();
		
		time2 = time2.plusHours(8);
		
		System.out.println("Resultado : " + calcularFecha(time, time2, 0l));
		
	}
	
	public static Long calcularFecha(LocalDateTime f1, LocalDateTime f2, Long saldo) {
		
		long horas = ChronoUnit.HOURS .between(f1, f2);

		
		if (  horas > 0 && horas <= 9) {
			long calculoHoras = 1000L * horas;
			saldo = saldo + calculoHoras;
			return saldo;
		}
		if(ChronoUnit.HOURS .between(f1, f2) > 9) {
			f1 = f1.plusHours(24);
			saldo += 8000;
			return calcularFecha(f1, f2, saldo);
		}
		return saldo;
	}
}
