package Models;

public class Categoria {
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
}
