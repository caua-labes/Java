package main;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] Args) {
		MapIntegers();
		}
	
	public static void MapRomanos() {
		Scanner rd = new Scanner(System.in);
		String numerosRomanos = rd.next();
		HashMap<Character,Integer> mapaRomanos = MapaRomanos.mapaRomanos();
		int valorInteiro = calculos.testRomanosParaInteiros(mapaRomanos, numerosRomanos);
		System.out.print(valorInteiro);
	}
	public static void MapIntegers() {
		
		int numerosInteiros = 24;
		HashMap<Integer,Character> mapaInteiros = MapaRomanos.mapaInteiros();
		String valorEmRomano = calculos.testInteirosParaRomanos(mapaInteiros, numerosInteiros);
		System.out.print(valorEmRomano + " Finalizado");
	}
}
