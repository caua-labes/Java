package Models;

import java.util.LinkedList;
import java.util.Scanner;

import BdFunctions.CrudProdutosBd;

public class Produto implements Icrud {
	private int Id;
	public void setId(int id) {
		this.Id = id;
	}
	public int getId() {
		return this.Id;
	}
	private String Descricao;
	public void setDescricao(String des) {
		this.Descricao = des;
	}
	public String getDescricao() {
		return this.Descricao;
	}
	private double valorUni;
    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }
    public double getValorUni() {
        return this.valorUni;
    }
    private int quantidade;
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    private int categoriaId;
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
    public int getCategoriaId() {
        return this.categoriaId;
    }
    private Categoria categoria;
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void criar() {
    	Scanner rd = new Scanner(System.in);
    	Produto produto = new Produto();
    	System.out.print("Descrição: ");
    	produto.setDescricao(rd.next());
    	System.out.print("Valor unitário: ");
    	produto.setValorUni(rd.nextDouble());
    	System.out.print("Quantidade: ");
    	produto.setQuantidade(rd.nextInt());
    	boolean confirmarCategoria = true;
    	while(confirmarCategoria) {
        	System.out.print("Id da categoria: ");
        	produto.setCategoriaId(rd.nextInt());
    		produto.setCategoria(BdFunctions.CrudCategoriasBd.selectId(produto.getCategoriaId()));
    		if(produto.getCategoria().getNome() == null) {
    			System.out.println("Erro, categoria inválida");
    		}
    		else {
	    		System.out.println("Categoria: " + produto.getCategoria().getNome());
	    		System.out.print("Confirmar categoria?");
	    		String verificacao = rd.next();
	    		if(verificacao.toLowerCase().startsWith("s")) {
	    			confirmarCategoria = false;
	    		}
    		}
    	}
    	CrudProdutosBd.insertProduto(produto);

    }
	public void ler() {
		LinkedList<Produto> lista = BdFunctions.CrudProdutosBd.selectProduto();
		for(Produto produto : lista) {
			System.out.println("\nId: " + produto.getId() + "\nDescrição: " + produto.getDescricao() + "\nValor Unitario: R$:" + produto.getValorUni() + "\nQuantidade: "+ produto.getQuantidade() + "\nCategoria: "+produto.getCategoria().getId()+ " " + produto.getCategoria().getNome());
		}
	}
	@Override
	public void alterar() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Qual id deseja alterar: ");
		int id = rd.nextInt();
		Produto produto = BdFunctions.CrudProdutosBd.selectId(id);
		if(produto.getCategoria() != null) {
		System.out.println("\nId: " + produto.getId() + "\nDescrição: " + produto.getDescricao() + "\nValor Unitario: R$:" + produto.getValorUni() + "\nQuantidade: "+ produto.getQuantidade() + "\nCategoria: "+produto.getCategoria().getId()+ " " + produto.getCategoria().getNome());
		System.out.println("\nTem certeza que deseja alterar este produto?");
		String confirmacao = rd.next();
		if(confirmacao.toLowerCase().startsWith("s")) {
			System.out.print("Descrição: ");
	    	produto.setDescricao(rd.next());
	    	System.out.print("Valor unitário: ");
	    	produto.setValorUni(rd.nextDouble());
	    	System.out.print("Quantidade: ");
	    	produto.setQuantidade(rd.nextInt());
	    	boolean confirmarCategoria = true;
	    	while(confirmarCategoria) {
	        	System.out.print("Id da categoria: ");
	        	produto.setCategoriaId(rd.nextInt());
	    		produto.setCategoria(BdFunctions.CrudCategoriasBd.selectId(produto.getCategoriaId()));
	    		if(produto.getCategoria().getNome() == null) {
	    			System.out.println("Erro, categoria inválida");
	    		}
	    		else {
		    		System.out.println("Categoria: " + produto.getCategoria().getNome());
		    		System.out.print("Confirmar categoria?");
		    		String verificacao = rd.next();
		    		if(verificacao.toLowerCase().startsWith("s")) {
		    			confirmarCategoria = false;
		    		}
	    		}
	    	}
	    	if(BdFunctions.CrudProdutosBd.updateProduto(produto)) {
	    		System.out.println("Produto atualizado");
	    	}
	    	else {
	    		System.out.println("Erro ao atualizar");
	    	}
	    	
		}
		}
		else {
			System.out.println("Erro na consulta");
		}
		
	}
	@Override
	public void deletar() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Qual o id do produto você deseja deletar: ");
		int id = rd.nextInt();
		Produto produto = BdFunctions.CrudProdutosBd.selectId(id);
		if(produto.getCategoria() != null) {
		System.out.println("\nId: " + produto.getId() + "\nDescrição: " + produto.getDescricao() + "\nValor Unitario: R$:" + produto.getValorUni() + "\nQuantidade: "+ produto.getQuantidade() + "\nCategoria: "+produto.getCategoria().getId()+ " " + produto.getCategoria().getNome());
		System.out.println("\nTem certeza que deseja deletar este produto?");
		String confirmacao = rd.next();
		if(confirmacao.toLowerCase().startsWith("s")) {
			BdFunctions.CrudProdutosBd.deleteProduto(id);
			System.out.println("Produto deletado!!");
		}
		}
		else {
			System.out.println("Erro na consulta");
		}
		

	}
	@Override
	public void lerId() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Id: ");
		int id = rd.nextInt();
		Produto produto = BdFunctions.CrudProdutosBd.selectId(id);
		if(produto.getCategoria() != null) {
		System.out.println("\nId: " + produto.getId() + "\nDescrição: " + produto.getDescricao() + "\nValor Unitario: R$:" + produto.getValorUni() + "\nQuantidade: "+ produto.getQuantidade() + "\nCategoria: "+produto.getCategoria().getId()+ " " + produto.getCategoria().getNome());
		}
		else {
			System.out.println("Erro na consulta");
		}
	}
}
