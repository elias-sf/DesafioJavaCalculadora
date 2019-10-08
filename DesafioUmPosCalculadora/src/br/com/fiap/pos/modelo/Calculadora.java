package br.com.fiap.pos.modelo;

import java.util.ArrayList;
import java.util.Collection;

import br.com.fiap.pos.interfacee.CalculadoraBasica;

public class Calculadora implements CalculadoraBasica {

	private static long numeroMemoria;

	@Override
	public float soma(ArrayList<Float> listaNumeros) {

		float resultado = 0;

		for (Float numero : listaNumeros) {

			resultado += numero;
		}

		return resultado;
	}

	@Override
	public float subtracao(ArrayList<Float> listaNumeros) {

		float resultado = listaNumeros.get(0);
		listaNumeros.remove(0);

		for (Float numero : listaNumeros) {

			if (resultado < 0) {
				resultado = resultado - (numero * -1);
			} else {
				resultado -= numero;
			}

		}

		return resultado;
	}

	@Override
	public float multiplicacao(ArrayList<Float> listaNumeros) {

		float resultado = listaNumeros.get(0);
		listaNumeros.remove(0);

		for (Float numero : listaNumeros) {

			resultado *= numero;
		}

		return resultado;
	}

	@Override
	public float divisao(ArrayList<Float> listaNumeros) {

		float resultado = listaNumeros.get(0);
		listaNumeros.remove(0);

		for (Float numero : listaNumeros) {

			if (numero == 0)
				throw new NumberFormatException(" Não é permitido o numerador ser igual a 0, "
						+ "condição de existencia da matemática, reinicei a calculadora");

			resultado /= numero;
		}

		return resultado;
	}

}
