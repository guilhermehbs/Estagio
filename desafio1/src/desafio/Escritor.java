package desafio;

import java.io.IOException;
import java.util.List;

public interface Escritor { // Interface que define os métodos que devem ser criados

	public void escreverSaida(List<Integer> numeros) throws IOException;

}
