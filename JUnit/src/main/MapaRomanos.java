package main;

import java.util.HashMap;

public class MapaRomanos {
	public static HashMap<Character,Integer> mapaRomanos(){
		HashMap<Character,Integer> maparomanos = new HashMap<Character,Integer>();
		maparomanos.put('I', 1);
		maparomanos.put('V', 5);
		maparomanos.put('X', 10);
		maparomanos.put('L', 50);
		maparomanos.put('C', 100);
		maparomanos.put('D', 500);
		maparomanos.put('M', 1000);
		return maparomanos;
	}
	public static HashMap<Integer,Character> mapaInteiros(){
		HashMap<Integer,Character> mapainteiros = new HashMap<Integer,Character>();
		mapainteiros.put(1, 'I');
		mapainteiros.put(5, 'V');
		mapainteiros.put(10,'X');
		mapainteiros.put(50,'L');
		mapainteiros.put(100,'C');
		mapainteiros.put(500,'D');
		mapainteiros.put(1000,'M');
		return mapainteiros;
	}
}
