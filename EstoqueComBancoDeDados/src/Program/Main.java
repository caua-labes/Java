package Program;

import java.util.LinkedList;
import java.util.Scanner;

import BdFunctions.CrudBD;
import Models.Categoria;

public class Main {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("\n1 - Criar\n2 - Ver\n3 - Alterar\n4 - Deletar\n5 - Pegar por id");
            int function = rd.nextInt();
            switch (function) {
                case 1:
                	criarCategoria();
                    break;

                case 2:
                	selectCategorias();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;
            }
		}

	}
	public static void criarCategoria() {
		Scanner rd = new Scanner(System.in);
		Categoria categoria = new Categoria();
		System.out.print("Nome da categoria: ");
		categoria.setNome(rd.next());
		if(CrudBD.insertCategoriaBd(categoria)) {
			System.out.println("Categoria adicionada com sucesso!");
		}
		else {
			System.out.println("Houve um erro!!");

		}
	}
	public static void selectCategorias(){
		LinkedList<Categoria> lista = new LinkedList<Categoria>();
		lista = CrudBD.selectAll();
		for(Categoria categoria : lista) {
			System.out.println("Id: "+categoria.getId()+ " Nome: "+categoria.getNome());
		}
	}

}
