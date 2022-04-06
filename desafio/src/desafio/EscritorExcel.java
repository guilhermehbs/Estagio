package desafio;

import java.util.List;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class EscritorExcel extends Calculos implements Escritor {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private FileOutputStream fileOutput;

	public EscritorExcel(String nomeArquivo, int quantidadeDeNumeros) throws FileNotFoundException {
		fileOutput = new FileOutputStream(nomeArquivo + ".xlsx"); //Grava o arquivo excel
		workbook = new XSSFWorkbook(); //Cria a planilha excel
		sheet = workbook.createSheet("SaídaExcel");
	}

	public void escreverSaida(List<Integer> numeros) throws IOException {
		try {
			for (int posicao = 0; posicao < numeros.size(); posicao++) {
				criarCelulaDaTabela(posicao, String.valueOf(numeros.get(posicao))); //Cria células para armazenar os números
			}

			String media = "Média: " + this.calculaMedia(numeros);
			criarCelulaDaTabela(numeros.size(), media); //Cria célula para armazenar a média

		} catch (Exception e) {
			e.printStackTrace(); //Escrever caso tenha algum erro (Não muito usado, mais usado é o log)
		} finally {
			workbook.write(fileOutput); //Escreve os números na tabela
			fileOutput.flush();
			fileOutput.close(); //Fecha o arquivo excel
		}

	}

	//Método para criar células na tabela do excel
	private void criarCelulaDaTabela(int posicao, String valor) {
		XSSFRow row = sheet.createRow(posicao);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(valor);
	}
}
