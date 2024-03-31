package Program;

import java.util.LinkedList;
import java.util.Scanner;

import BdFunctions.CrudBD;
import BdFunctions.CrudCategoriasBd;
import Models.Categoria;

public class Main {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("\n1 - Criar categoria\n2 - Ver categorias\n3 - Alterar categoria\n4 - Deletar categoria\n5 - Pegar categoria por id");
            int function = rd.nextInt();
            switch (function) {
                case 1:
                	criarCategoria();
                    break;

                case 2:
                	selectCategorias();
                    break;

                case 3:
                	updateCategorias();
                    break;

                case 4:
                	deleteCategoria();
                    break;

                case 5:
                	selectIdCategorias();
                	break;
            }
		}

	}
	public static void criarCategoria() {
		Scanner rd = new Scanner(System.in);
		Categoria categoria = new Categoria();
		System.out.print("Nome da categoria: ");
		categoria.setNome(rd.next());
		if(CrudCategoriasBd.insertCategoriaBd(categoria)) {
			System.out.println("Categoria adicionada com sucesso!");
		}
		else {
			System.out.println("Houve um erro!!");
		}
	}
	public static void selectCategorias(){
		LinkedList<Categoria> lista = new LinkedList<Categoria>();
		lista = CrudCategoriasBd.selectAll();
		for(Categoria categoria : lista) {
			System.out.println("Id: "+categoria.getId()+ " Nome: "+categoria.getNome());
		}
	}
	public static void selectIdCategorias(){
		Scanner rd = new Scanner(System.in);
		System.out.print("Id: ");
		int id = rd.nextInt();
		Categoria categoria = CrudCategoriasBd.selectId(id);
		if(categoria.getNome() == null) {
			System.out.println("Categoria inexistente!!");
			return;
		}
		System.out.println("Id: " + categoria.getId() + " Nome: " + categoria.getNome());
	}
	public static void updateCategorias() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Id: ");
		int id = rd.nextInt();
		Categoria categoriaId = CrudCategoriasBd.selectId(id);
		if(categoriaId.getNome() == null) {
			System.out.println("Categoria inexistente!!");
			return;
		}
		System.out.println("Id: "+ categoriaId.getId() + "\nNome: "+categoriaId.getNome());
		System.out.print("Você deseja alterar está categoria:");
		String verificacao = rd.next();
		if(verificacao.toLowerCase().startsWith("s")) {
			System.out.print("Novo nome: ");
			categoriaId.setNome(rd.next());
			if(CrudCategoriasBd.updateCategoria(categoriaId)) {
				System.out.println("Categoria alterada!");
			}
			else {
				System.out.println("Houve um erro!3");

			}
		}
	}
	public static void deleteCategoria() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Qual id você deseja deletar: ");
		int id = rd.nextInt();
		Categoria categoria = CrudCategoriasBd.selectId(id);
		if(categoria.getNome() == null) {
			System.out.println("Categoria inexistente!!");
			return;
		}
		System.out.println("Id: " + categoria.getId() + " Nome: "+ categoria.getNome());
		System.out.println("Tem certeza que deseja deletar esta categoria");
		String verificacao = rd.next();
		if(verificacao.toLowerCase().startsWith("s")) {
			if(CrudCategoriasBd.deleteCategoria(id)) {
				System.out.println("Categoria deletada");
			}
			else {
				System.out.println("Erro!!");
			}
		}
	}

}
