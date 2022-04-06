package desafio;

import java.io.IOException;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class EscritorTxt extends Calculos implements Escritor {

	private FileWriter arquivo;
	private PrintWriter gravarArquivo;

	protected EscritorTxt(String nomeArquivo, int quantidadeDeNumeros) throws IOException {
		arquivo = new FileWriter(nomeArquivo + ".txt"); // Cria o arquivo txt
		gravarArquivo = new PrintWriter(arquivo); // Gravar os números e a média no arquivo txt
	}

	public void escreverSaida(List<Integer> numeros) throws IOException {
		try {
			for (Integer num : numeros) {
				this.gravarArquivo.println(num); // For para percorrer a lista e escrever os números no txt
			}
			this.gravarArquivo.println("Média: " + this.calculaMedia(numeros)); // Escrever a média no txt

		} catch (Exception e) {
			e.printStackTrace(); // Escrever caso tenha algum erro (Não muito usado, mais usado é o log)
		} finally {
			if (arquivo != null) { // Se o arquivo não for nulo, fechar arquivo
				arquivo.close();
			}
		}
	}
}
