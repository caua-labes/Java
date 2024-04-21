package main;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Random rad =new Random();
		Scanner rd = new Scanner(System.in);
		System.out.println("Regras: Caso atire em você, se for um tiro falso você não pula a vez e continua");
		System.out.print("\nJogador 1: ");
		String nome1 = rd.next();
		System.out.print("Jogador 2: ");
		String nome2 = rd.next();
		int municao = 6;
		int shot = rad.nextInt(1,7);
		System.out.println(nome1 +" começa!");
		int vez = 1;
		while(municao != 0) {
			System.out.println("Em quem você deseja atirar\n1 - "+ nome1 +"\n2 - "+nome2);
			System.out.println("\nSua vez jogador: "+vez);
			int tiro = rd.nextInt();

			if (municao == shot) {
				if(tiro == 2) {
					System.out.println(nome2 + " morreu");
				}
				else {			
					System.out.println(nome1 + " morreu");
				}
				break;
			}
			System.out.println("Tiro falso");
			if(vez == 1 && tiro == 2) {
				vez = 2;
			}
			else if(vez == 2 && tiro == 1) {
				vez = 1;
			}

		municao--;
		System.out.println("Quantidade de munição: "+municao);
		}
		rd.close();
	}


}
