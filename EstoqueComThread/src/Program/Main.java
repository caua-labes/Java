package Program;

import java.util.Scanner;
import Models.*;

public class Main {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		Produto funcaoProduto = new Produto();
		Categoria funcaoCategoria = new Categoria();
		boolean loop = true;
		while(loop) {
			System.out.println("\n1 - Produtos\n2 - Categorias");
			int choseType = rd.nextInt();
			if(choseType == 1) {
				System.out.println("\n1 - Criar produto\n2 - Ver produtos\n3 - Alterar produto\n4 - Deletar produto\n5 - Pegar produto por id");
	            int function = rd.nextInt();
	            switch (function) {
	                case 1:
	                	funcaoProduto.criar();
	                    break;

	                case 2:
	                	funcaoProduto.ler();
	                    break;

	                case 3:
	                	funcaoProduto.alterar();
	                    break;

	                case 4:
	                	funcaoProduto.deletar();
	                    break;

	                case 5:
	                	funcaoProduto.lerId();
	                	break;
	            }
			}
			else if(choseType == 2) {
			System.out.println("\n1 - Criar categoria\n2 - Ver categorias\n3 - Alterar categoria\n4 - Deletar categoria\n5 - Pegar categoria por id");
            int function = rd.nextInt();
            switch (function) {
                case 1:
                	funcaoCategoria.criar();
                    break;

                case 2:
                	funcaoCategoria.ler();
                    break;

                case 3:
                	funcaoCategoria.alterar();
                    break;

                case 4:
                	funcaoCategoria.deletar();
                    break;

                case 5:
                	funcaoCategoria.lerId();
                	break;
            }
		}
			else {
				System.out.println("Número desconhecido!");
			}
		}
	}
	

}
