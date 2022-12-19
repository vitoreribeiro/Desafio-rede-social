package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {

	static Scanner sc = new Scanner(System.in);

	private String nome;
	private String login;
	private String senha;

	List<Post> postsUsuario = new ArrayList<Post>();

	public Perfil(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public List<Post> getPostsUsuario() {
		return postsUsuario;
	}

	public void setPostsUsuario(List<Post> postsUsuario) {
		this.postsUsuario = postsUsuario;
	}

	@Override

	public String toString() {
		return nome + ", " + login + ", " + senha;
	}

	public void menuPerfil() {
		String opcaoMenuPerfil;
		do {
			System.out.print("\n----------------------------------------- \n");
			System.out.println("\nBem-vindo de volta, " + this.nome + "!");
			System.out.println(
					"\nO que deseja fazer?\n  'P' para Postar; \n  'T' para Timeline; ou \n  'S' para Sair.\n");
			opcaoMenuPerfil = sc.nextLine().toUpperCase();
			System.out.print("\n----------------------------------------- \n");
			switch (opcaoMenuPerfil) {
			case "P":
				postar();
				break;
			case "T":
				timeline();
				break;
			case "S":
				System.out.println("\nSaindo...\nVocê se desconectou.\nObrigado!");
				break;
			default:
				System.out.println("\nDesculpe, opção inválida.");
				break;
			}
		} while (!opcaoMenuPerfil.equals("S"));
	}

	private void postar() {
		int postValido = 0;
		while (postValido == 0) {

			System.out.print("Digite o texto que deseja postar:  ");
			String texto = sc.nextLine();

			if (texto.trim().equals("") || texto.isEmpty()) {
				postValido = 0;
			} else {
				Post post = new Post(texto);
				postsUsuario.add(post);
				postValido = 1;
				System.out.println("\nPost realizado com sucesso!\n");
			}
		}
	}

	private void timeline() {
		if (postsUsuario.size() == 0) {
			System.out.println("\nVocê ainda não publicou nenhum post!\n");
		} else {
			for (Post post : postsUsuario) {
				System.out.println(post);
			}
		}
	}
}
