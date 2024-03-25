package Program;
import Class.Users;

import java.util.LinkedList;
import java.util.Scanner;

public class CrudUsers {

	static LinkedList<Users> lista = new LinkedList<Users>();
	public static void main(String[] args) {
		boolean aoi = true;
		while (aoi == true) {
			Scanner rd = new Scanner(System.in);
			System.out.println("\n1 - Criar\n2 - Ver\n3 - Alterar\n4 - Deletar\n5 - Pegar por id");
			int function = rd.nextInt();
			switch (function) {
			case 1:
				String mensagemDeVerificacaoCriar = criarUser() == true ? "Usuario salvo!" : "Erro!";
				System.out.println(mensagemDeVerificacaoCriar);
				break;
			
			case 2:
				lerLista(lista);
				rd.next();
				break;
				
			case 3: 
				String mensagemDeVerificacaoAlterar = alterarUser() == true ? "Usuario alterado!" : "Erro!";
				System.out.println(mensagemDeVerificacaoAlterar);
				break;
				
			case 4:
				deletarUser();
				break;
				
			case 5:
				pegarPosicao();
				break;
			}
		}
	}
	public static boolean criarUser() {
		Scanner rd = new Scanner(System.in);
		Users user = new Users();
		System.out.print("Nome: ");
		user.Nome = rd.next();
		System.out.print("Senha: ");
		user.Senha = rd.next();
		System.out.print("Email: ");
		user.Email = rd.next();
		lista.addFirst(user);
		if(lista.contains(user)) {
			return true;
		}
		return false;
	}
	public static void lerLista(LinkedList<Users> lista) {
		int i = 1;
		for (Users user : lista) {
			System.out.println("\nPosição: " + i + "\nNome: " + user.Nome + "\nSenha: "+ user.Senha + "\nEmail: " + user.Email);
			i++;
		}
	}
	public static boolean alterarUser() {
		Scanner rd = new Scanner(System.in);
		Users user = new Users();
		System.out.print("Qual posição será alterada: ");
		int pos = rd.nextInt() - 1;
		if (pos > lista.size()){
			return false;			
		}
		user = lista.get(pos);
		System.out.println("Nome: "+ user.Nome);
		System.out.println("Senha: "+ user.Senha);
		System.out.println("Email: "+ user.Email);
		System.out.println("Tem certeza que deseja alterar este usuario");
		String verificacaoParaAlterar = rd.next();
        char analise = verificacaoParaAlterar.charAt(0);
        if (Character.toLowerCase(analise) == 's') {
        	System.out.print("Nome: ");
    		user.Nome = rd.next();
    		System.out.print("Senha: ");
    		user.Senha = rd.next();
    		System.out.print("Email: ");
    		user.Email = rd.next();
    		lista.set(pos, user);
    		if(lista.get(pos) == user) {
    			return true;
    		}
        }
       return false;
	}
	public static void deletarUser() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Qual posição será deletada: ");
		int pos = rd.nextInt() - 1;
		lista.remove(pos);
	}
	public static void pegarPosicao() {
		Scanner rd = new Scanner(System.in);
		System.out.print("Qual usuario você deseja ver: ");
		int pos = rd.nextInt() - 1;
		Users user = lista.get(pos);
		System.out.print("Nome: " + user.Nome + "\nSenha: "+ user.Senha + "\nEmail: " + user.Email);
	}
}
