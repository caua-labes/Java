package Program;

import java.util.Scanner;

public class Main implements Runnable {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		Main main = new Main();
		//Crio uma objeto thread passando um objeto de uma classe que tem thread
		Thread th = new Thread(main);
		//Começo a executar a função do Thread dentro da classe passada no objeto Thread
		th.start();
		try {
			Thread.sleep(1);
		}
		catch(Exception ex) {
			//Mostra o local do erro
			ex.printStackTrace();
		}
		int i = 0;
		while(i <= 10) {
			System.out.print("0");
			i++;
			rd.next();
			
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		int j = 0;
		while(j <= 10) {
			System.out.print("1");
			j++;
		}
		
	}
	//Resultado 1: 0000000000111111111101, obs: Valor aleatorio;
	//Resultado 2 com sleep = 1: Conjunto aleatorio;
	//Resultado 3 com Scanner no 1° loop: 011111111111_,  obs: este exemplo mostra como funciona um thread de forma mais simples;

}
