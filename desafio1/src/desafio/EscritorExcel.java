package desafio;

import java.util.List;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class EscritorExcel extends Calculos implements Escritor { // Classe que herda todos os m�todos de Calculos e
																	// implementa todos os m�todos do Escritor

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private FileOutputStream fileOutput;

	public EscritorExcel(String nomeArquivo, int quantidadeDeNumeros) throws FileNotFoundException {
		workbook = new XSSFWorkbook(); // Cria a planilha excel
		sheet = workbook.createSheet("Sa�daExcel");
		fileOutput = new FileOutputStream(nomeArquivo + ".xlsx"); // Grava o arquivo excel
	}

	public void escreverSaida(List<Integer> numeros) throws IOException {
		try {
			for (int posicao = 0; posicao < numeros.size(); posicao++) {
				criarCelulaDaTabela(posicao, String.valueOf(numeros.get(posicao))); // Cria c�lulas para armazenar os n�meros
			}

			String media = "M�dia: " + this.calculaMedia(numeros);
			criarCelulaDaTabela(numeros.size(), media); // Cria c�lula para armazenar a m�dia

		} catch (Exception e) {
			e.printStackTrace(); // Escrever caso tenha algum erro (N�o muito usado, mais usado � o log)
		} finally {
			workbook.write(fileOutput); // Escreve os n�meros na tabela
			fileOutput.flush();
			fileOutput.close(); // Fecha o arquivo excel
		}

	}

	// M�todo para criar c�lulas na tabela do excel
	private void criarCelulaDaTabela(int posicao, String valor) {
		XSSFRow row = sheet.createRow(posicao); // Define linha na tabela
		XSSFCell cell = row.createCell(0); // Define coluna na tabela
		cell.setCellValue(valor); // Define o que deve ser escrito na tabela
	}
}
