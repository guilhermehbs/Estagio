
package desafio1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaidaTxt extends CalculoMedia implements EscreverArquivos {

	@Override
		public void escreverTexto() {
			try(
				FileWriter escreverArquivo = new FileWriter("saida.txt");
				PrintWriter gravarArquivo = new PrintWriter(escreverArquivo);
					
				){
				
				gravarArquivo.println(CalculoMedia.getMedia());
				escreverArquivo.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
