package desafio;

import java.io.IOException;
import java.util.List;

public interface Escritor {

	public void escreverSaida(List<Integer> numeros) throws IOException;

}