package br.com.fiap.pos.teste;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.pos.interfacee.CalculadoraBasica;
import br.com.fiap.pos.modelo.Calculadora;

public class CalculadoraTeste {

	public static String[] acao = { "Soma", "Subtracao", "Multiplicação", "Divisão", "Sair" };
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		try {

			começar();

		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());

		} catch (Exception e) {

			System.err.println("Erro a executar uma operacao, reinicie a calculadora");

		}
	}

	private static void começar() {

		int opcao = 0;

		boolean menu = true;

		while (menu) {

			opcao = Integer.valueOf(JOptionPane.showOptionDialog(null,
					"***** *** * PROGRAMA DE CALCULO - CALCULADORA * *** *****" + "\n Escolha uma opcao:", "Tela", 0,
					JOptionPane.QUESTION_MESSAGE, null, acao, acao[0]));

			switch (((opcao == -1) ? "Sair" : acao[opcao])) {
			case "Soma":
				System.out.println("Iniciando operação de Soma");
				soma();
				break;
			case "Subtracao":
				System.out.println("Iniciando operação de Subtração");
				subtracao();
				break;
			case "Multiplicação":
				System.out.println("Iniciando operação de multiplicacao");
				multiplicacao();
				break;
			case "Divisão":
				System.out.println("divisao");
				divisao();
				break;
			default:
				System.out.println("sair");
				System.exit(0);
				break;
			}

		}

	}

	private static void divisao() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.divisao(listaNumeros);

		JOptionPane.showMessageDialog(null, "Resultado da operação é:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void multiplicacao() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.multiplicacao(listaNumeros);

		JOptionPane.showMessageDialog(null, "Resultado da operação é:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void subtracao() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.subtracao(listaNumeros);

		JOptionPane.showMessageDialog(null, "Resultado da operação é:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void soma() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.soma(listaNumeros);

		// float resultado = calculadora.soma(primeiroNumero, proximoNumero);

		JOptionPane.showMessageDialog(null, "Resultado da operação é:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static ArrayList<Float> telaLeitura(boolean flagLeitura) {

		ArrayList<Float> listaNumeros = new ArrayList<>();

		try {

			String dadosPrimeiraEntrada = JOptionPane.showInputDialog("Digite o primeiro número:");

			if (dadosPrimeiraEntrada == null) {
				JOptionPane.showMessageDialog(null, "\n Ação não permitida o uso - Uso incorreto", "Uso incorreto",
						JOptionPane.ERROR_MESSAGE);

				throw new Exception("Ação não permitida o uso - Uso incorreto");

			}

			Float primeiroNumero = Float.valueOf(dadosPrimeiraEntrada);

			listaNumeros.add(primeiroNumero);

			while (flagLeitura) {

				String dadosSegundaEntrada = JOptionPane.showInputDialog("Digite o proximo número: ");

				if (dadosSegundaEntrada == null) {
					JOptionPane.showMessageDialog(null, "\n Ação não permitida o uso - Uso incorreto", "Uso incorreto",
							JOptionPane.ERROR_MESSAGE);
					throw new Exception("Ação não permitida o uso - Uso incorreto");
				}

				float proximoNumero = Float.valueOf(dadosSegundaEntrada);

				listaNumeros.add(proximoNumero);

				flagLeitura = (JOptionPane
						.showInputDialog("Se deseja digitar mais números escreva sim, " + "para sair escreva não?")
						.equals("sim") ? true : false);

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

		return listaNumeros;

	}

}
