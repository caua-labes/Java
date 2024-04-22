package Models;

import java.util.LinkedList;
import java.util.Scanner;

import BdFunctions.CrudCategoriasBd;

public class Categoria implements Icrud {
	private int Id;
	private String Nome;
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getNome() {
		return this.Nome;
	}
	public int getId() {
		return this.Id;
	}
	public void criar() {
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
	public void ler(){
		LinkedList<Categoria> lista = new LinkedList<Categoria>();
		lista = CrudCategoriasBd.selectAll();
		lista.forEach(categoria -> System.out.println("Id: "+categoria.getId()+ " Nome: "+categoria.getNome()));
	}
	public void lerId(){
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
	public void alterar() {
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
	public void deletar() {
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
