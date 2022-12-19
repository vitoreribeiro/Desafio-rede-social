package rede_social;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Applications program = new Applications();
		do {
			program.menuInicial();

		} while (program.getEncerrar() == 0);

		sc.close();

	}

}
