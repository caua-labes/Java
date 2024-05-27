package main;

import java.util.Scanner;

public class Program {

	public static String[][] grade;
	
	public static void main(String[] Args) {
		Scanner rds = new Scanner(System.in);
		System.out.print("Area: ");
		int area = rds.nextInt();
		System.out.println("Quantidade de alvos: ");
		int alvos = rds.nextInt();
		String[] alvosnomapa = new String[alvos];
		String tiposdealvos[] = {"navioG","aviao","navioP","helicoptero"};
		grade = new String[area][area];
		for(int coluna = 0;coluna< grade.length;coluna++) {
			for(int linha = 0;linha< grade.length;linha++) {
					grade[linha][coluna] = "~";
				}
		}
		for(int i =0;i < alvosnomapa.length;i++) {
			int alvoaleatorio = (int)(Math.random() * 4);
			alvosnomapa[i] = tiposdealvos[alvoaleatorio];
		}
		for(int i =0;i < alvosnomapa.length;i++) {
			int posicaoX = (int)(Math.random() * area);
			int posicaoY = (int)(Math.random() * area);
			grade[posicaoX][posicaoY] = alvosnomapa[i];
		}
			System.out.println();
			mostrarGrade();
			
			System.out.println("Como deseja jogar:\n1 - Bot\n2 - Jxj");
			int tipodejogo = rds.nextInt();
			switch (tipodejogo) {
			case 1:
				jogarcombot(rds,alvos);
				break;
			case 2:
				jogarjxj(rds,alvos);
				break;
			}
		}
	private static void jogarcombot(Scanner rds, int alvos){
		System.out.println("Você começa!");
		boolean vez = false;
		while(!VerificarGrade(alvos)) {
			boolean acerto = jogar(rds,vez);
			if(!acerto) {
				if(vez) {
					vez = false;
				}
				else {
					vez = true;
				}
			}
			else {
				if(vez) {
					System.out.println("O bot acertou!");
				}
				else {
					System.out.println("Você acertou!");

				}
			}
			
			
		}
		if(vez == true) {
			System.out.println("O bot ganhou");
		}
		else {
			System.out.println("Você ganhou");

		}
		
	}
	public static void jogarjxj(Scanner rds, int alvos) {
		// TODO Auto-generated method stub
		
	}
	public static void mostrarGrade() {
		System.out.println();

		for(int coluna = 0;coluna< grade.length;coluna++) {
			for(int linha = 0;linha < grade.length;linha++) {
				if(grade[linha][coluna] == "X") {
					System.out.print("X" + " ");
				}
				else if(grade[linha][coluna] == "O") {
					System.out.print("O" + " ");
				}
				else {
					System.out.print("~" + " ");

				}
				}
			System.out.println(coluna);
		}
		for(int i=0;i< grade.length;i++) {
			if(i >= 9) {
				System.out.print(i+"");
			}						 
			else {
			System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	public static boolean jogar(Scanner rds, boolean bot) {
		if(bot) {
			mostrarGrade();
			int posicaoX;
			int posicaoY;
			while(true) {
			posicaoX = (int)(Math.random() * grade.length);
			posicaoY = (int)(Math.random() * grade.length);
			if(grade[posicaoX][posicaoY] != "O") {
				break;
			}
			}
			try {
			System.out.println("Vez do bot!");
			Thread.sleep(2000);
			System.out.println("X = "+posicaoX);
			Thread.sleep(100);
			System.out.println("Y = "+ posicaoY);
			Thread.sleep(1000);

			}
			catch(Exception ex) {
				
			}
			if(grade[posicaoX][posicaoY] != "~" && grade[posicaoX][posicaoY] != "O") {
				grade[posicaoX][posicaoY] = "X";
				return true;
			}
			else {
				grade[posicaoX][posicaoY] = "O";
			}
			return false;
			
		}
		else {
		mostrarGrade();
		System.out.println("Onde deseja atirar?");
		System.out.print("X = ");
		int posicaoX = rds.nextInt();
		System.out.print("Y = ");
		int posicaoY = rds.nextInt();
		if(grade[posicaoX][posicaoY] != "~" && grade[posicaoX][posicaoY] != "O") {
			grade[posicaoX][posicaoY] = "X";
			return true;
		}
		else {
			grade[posicaoX][posicaoY] = "O";
		}
		return false;
	}
	}
	public static boolean VerificarGrade(int alvos) {
		int verificacao= 0;
		for(int coluna = 0;coluna< grade.length;coluna++) {
			for(int linha = 0;linha< grade.length;linha++) {
				if(grade[linha][coluna] == "X") {
					verificacao++;
				}
			}

		}
		if(verificacao == alvos) {
			return true;
		}
		return false;
		
	}
}


