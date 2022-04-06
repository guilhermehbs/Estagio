package desafio;

import java.io.IOException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registra {

	private static final String NOME_ARQUIVO_DEFAULT = "Saida"; // Definindo nome default
	private static final int QUANTIDADE_DE_NUMEROS_DEFAULT = 5; // Definindo quantidade default

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String leitura = "";

		Scanner scan = new Scanner(System.in);

		List<Integer> list = new ArrayList<>();

		System.out.print(
				"Digite a quantidade de n�meros, (0 = quantidade default (" + QUANTIDADE_DE_NUMEROS_DEFAULT + ")): ");
		int quantidadeDeNumeros = scan.nextInt(); // Salva a quantidade de n�meros
		if (quantidadeDeNumeros == 0) {
			quantidadeDeNumeros = QUANTIDADE_DE_NUMEROS_DEFAULT; // Se digitar 0 vai para a quantidade default
		}

		System.out.print("Digite o nome do arquivo, (0 = nome default (" + NOME_ARQUIVO_DEFAULT + ")): ");
		String nomeArquivo = scan.next(); // Salva o nome do arquivo
		if (nomeArquivo.equals("0")) {
			nomeArquivo = NOME_ARQUIVO_DEFAULT; // Se digitar 0 vai para o nome default
		}

		entradaDeDadosEValidacao(scan, list, quantidadeDeNumeros); // Entrada dos n�meros, valida��o deles e adcionar na lista

		Escritor[] escritores = { new EscritorTxt(nomeArquivo, quantidadeDeNumeros),
				new EscritorExcel(nomeArquivo, quantidadeDeNumeros) };

		for (Escritor escritor : escritores) {
			escritor.escreverSaida(list); // For que passa pela lista e escreve os n�meros no txt e xlsx
		}

		System.out.println("N�meros digitados: " + list);

	}

	// M�todo para a entrada dos n�meros, valida��o deles e adcionar na lista
	private static void entradaDeDadosEValidacao(Scanner scan, List<Integer> list, int quantidadeDeNumeros) {
		String leitura;
		for (int i = 1; i <= quantidadeDeNumeros; i++) {
			boolean valida = false;
			System.out.print("Digite o " + (i) + "� n�mero: ");

			if (scan.hasNextInt()) { // Se o n�mero for inteiro, salva ele na vari�vel leitura e converte para inteiro
				leitura = scan.next();
				int valor = Integer.parseInt(leitura);

				if (valor >= 0 && valor <= 10) { // Se o valor for entre 0 e 10 adcionar a lista
					list.add(valor);
				} else {
					valida = true;
				}
			} else {
				valida = true;
				scan.nextLine();
			}
			if (valida) { // Se o n�mero n�o for inteiro nem entre 0 e 10, digitar outro
				System.out.println("Digite um valor inteiro entre 0 e 10!");
				i--;
			}
		}
	}

}
