package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Perfil;
import exceptions.InvalidPasswordException;
import exceptions.UserNotFoundException;

public class Program {

	public static Scanner sc = new Scanner(System.in);
	public static List<Perfil> perfisCadastrados = new ArrayList<Perfil>();
	static int encerrar = 0;

	public static void main(String[] args) {
		do {
			menuInicial();
		} while (encerrar == 0);
		sc.close();
	}

	public static void menuInicial() {
		System.out.print("\n----------------------------------------- \n");
		System.out.print("******** Bem-vindo ao AdaCoders! ********\n " + "- A rede social dos alunos DevMakers! - "
				+ "\n----------------------------------------- \n");
		System.out.print(
				"\nVocê deve digitar (somente a letra): \n\n  'C' para Cadastrar-se; \n  'E' para Entrar; ou \n  'F' para Fechar.\n");
		System.out.print("\nDigite a opção desejada: ");
		String opcaoMenu = sc.nextLine().toUpperCase();

		if (opcaoMenu.equals("C")) {
			cadastrarPerfil();
		}

		else if (opcaoMenu.equals("E")) {
			if (perfisCadastrados.isEmpty()) {
				System.out.print("\nDesculpe, ainda não há perfis cadastrados.\n");
				System.out.print("Acesse as opções 'Cadastrar-se' ou 'Fechar'.\n\n");
				menuInicial();
			} else {
				efetuarLogin();
			}
		} else if (opcaoMenu.equals("F")) {
			encerrar = 1;
			System.out.println("\nObrigado por usar o AdaCoders!");
		}

		else {
			System.out.println("\nOpção inválida!");
			menuInicial();
		}
	}

	private static void cadastrarPerfil() {
		String nome = cadastrarNome();
		String login = criarLogin();
		String senha = cadastrarSenha();

		Perfil perfil = new Perfil(nome, login, senha);
		perfisCadastrados.add(perfil);
		System.out.println("\nPerfil criado com sucesso! \n");
		listarPerfis();
		menuInicial();
	}

	public static String cadastrarNome() {
		System.out.print("\nComo você deseja ser chamado? ");
		String nome = sc.nextLine();
		if (nome.isEmpty() || nome == null || nome.trim().equals("")) {
			System.out.println("\nO nome não pode ser vazio ou nulo.");
			menuInicial();
		}
		return nome;
	}

	public static String criarLogin() {
		System.out.print("\nDigite um login para criar: ");
		String login = sc.nextLine();

		for (Perfil perfil : perfisCadastrados) {
			if (login.equals(perfil.getLogin())) {
				System.out.println("\nEsse login já existe! Favor digitar outro login.");
				menuInicial();
			}
			if (login.isEmpty() || login == null || login.trim().equals("")) {
				System.out.println("\nDesculpe, o login não pode ser nulo ou vazio.");
				menuInicial();
			}
		}
		return login;
	}

	public static String cadastrarSenha() {
		System.out.print("\nDigite uma senha de ao menos 8 caracteres: ");
		String senha = sc.nextLine();
		if (senha.length() < 8 || senha.isEmpty() || senha == null || senha.trim().equals("")) {
			System.out.println("\nA senha deve possuir ao menos 8 caracteres, não pode ser nula nem vazia.");
			menuInicial();
		} else {
			System.out.print("\nDigite novamente a senha: ");
			String repeteSenha = sc.nextLine();
			if (!repeteSenha.equals(senha)) {
				System.out.println("\nDesculpe, mas as senhas devem ser iguais.");
				menuInicial();
			}
		}
		return senha;
	}

	public static void efetuarLogin() {

		try {
			int loginExiste = 0;
			System.out.print("\nDigite seu login: ");
			String login = sc.nextLine();
			System.out.print("Digite sua senha: ");
			String senha = sc.nextLine();

			for (int i = 0; i < perfisCadastrados.size(); i++) {
				if (perfisCadastrados.get(i).getLogin().equals(login)) {
					loginExiste = 1;
					if (perfisCadastrados.get(i).getSenha().equals(senha)) {
						perfisCadastrados.get(i).menuPerfil();

					} else {
						loginExiste = 0;
						throw new InvalidPasswordException();
					}
				}
			}
			if (loginExiste == 0) {
				throw new UserNotFoundException();
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void listarPerfis() {
		for (Perfil perfil : perfisCadastrados) {
			System.out.println(perfil);
		}
	}

}
