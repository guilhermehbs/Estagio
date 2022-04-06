package desafio;

import java.util.List;

public abstract class Calculos {

	//Método para calcular média:
	protected double calculaMedia(List<Integer> numeros) {
		double soma = 0;
		for (int numero : numeros) {
			soma += numero; //For que percorre a lista e soma os números presentes nela
		}
		return soma / numeros.size(); //Retorna soma dividido por total de números = Média
	}
}
