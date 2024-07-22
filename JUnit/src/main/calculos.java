package main;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class calculos {

	@Test
	static Integer testRomanosParaInteiros(HashMap<Character, Integer> maparomanos, String romano) {
		char[] valores = romano.toUpperCase().toCharArray();
		int valor = maparomanos.get(valores[0]);
		for(int i = 1; i<valores.length;i++) {
			//XIV
			if(valor >= maparomanos.get(valores[i]) && maparomanos.get(valores[i]) > maparomanos.get(valores[i + 1])) {
				valor += maparomanos.get(valores[i]);
			}
			else {
				int valorMaior = maparomanos.get(valores[i]);
				valorMaior -= valor;
				valor = valorMaior;
			}
		}
		return valor;
	}
	@Test
	static String testInteirosParaRomanos(HashMap<Integer,Character> mapainteiros, Integer numeros) {
		String romanos = "";
		int valoresSobra = numeros;
		for(int i=numeros; i>0; i--) {
			if(mapainteiros.get(i) != null) {
			romanos += mapainteiros.get(i);
			valoresSobra -= i;
			i = valoresSobra + 1;
			}
		}
		return romanos;
	}
}
