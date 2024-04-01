package Models;

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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void lerId() {
		// TODO Auto-generated method stub
		
	}
}
