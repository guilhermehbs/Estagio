package desafio;

import java.util.List;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class EscritorExcel extends Calculos implements Escritor { // Classe que herda todos os métodos de Calculos e
																	// implementa todos os métodos do Escritor

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private FileOutputStream fileOutput;

	public EscritorExcel(String nomeArquivo, int quantidadeDeNumeros) throws FileNotFoundException {
		workbook = new XSSFWorkbook(); // Cria a planilha excel
		sheet = workbook.createSheet("SaídaExcel");
		fileOutput = new FileOutputStream(nomeArquivo + ".xlsx"); // Grava o arquivo excel
	}

	public void escreverSaida(List<Integer> numeros) throws IOException {
		try {
			for (int posicao = 0; posicao < numeros.size(); posicao++) {
				criarCelulaDaTabela(posicao, String.valueOf(numeros.get(posicao))); // Cria células para armazenar os números
			}

			String media = "Média: " + this.calculaMedia(numeros);
			criarCelulaDaTabela(numeros.size(), media); // Cria célula para armazenar a média

		} catch (Exception e) {
			e.printStackTrace(); // Escrever caso tenha algum erro (Não muito usado, mais usado é o log)
		} finally {
			workbook.write(fileOutput); // Escreve os números na tabela
			fileOutput.flush();
			fileOutput.close(); // Fecha o arquivo excel
		}

	}

	// Método para criar células na tabela do excel
	private void criarCelulaDaTabela(int posicao, String valor) {
		XSSFRow row = sheet.createRow(posicao); // Define linha na tabela
		XSSFCell cell = row.createCell(0); // Define coluna na tabela
		cell.setCellValue(valor); // Define o que deve ser escrito na tabela
	}
}
