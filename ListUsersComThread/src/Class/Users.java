package Class;
public class Users implements Runnable{
	private String Nome;
	private String Senha;
	private String Email;
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public void setSenha(String Senha) {
		this.Senha = Senha;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
    public String getNome() {
        return this.Nome;
    }

    public String getSenha() {
        return this.Senha;
    }

    public String getEmail() {
        return this.Email;
    }
	@Override
	public void run() {
		UserSalvo userLog = new UserSalvo();
		userLog.Email = this.Email;
		userLog.Nome = this.Nome;
		userLog.Senha = this.Senha;
	}
}

