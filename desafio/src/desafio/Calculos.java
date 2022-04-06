package desafio;

import java.util.List;

public abstract class Calculos {

	//M�todo para calcular m�dia:
	protected double calculaMedia(List<Integer> numeros) {
		double soma = 0;
		for (int numero : numeros) {
			soma += numero; //For que percorre a lista e soma os n�meros presentes nela
		}
		return soma / numeros.size(); //Retorna soma dividido por total de n�meros = M�dia
	}
}
