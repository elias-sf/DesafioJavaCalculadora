package br.com.fiap.pos.teste;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.pos.interfacee.CalculadoraBasica;
import br.com.fiap.pos.modelo.Calculadora;

public class CalculadoraTeste {

	public static String[] acao = { "Soma", "Subtracao", "Multiplica��o", "Divis�o", "Sair" };
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		try {

			come�ar();

		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());

		} catch (Exception e) {

			System.err.println("Erro a executar uma operacao, reinicie a calculadora");

		}
	}

	private static void come�ar() {

		int opcao = 0;

		boolean menu = true;

		while (menu) {

			opcao = Integer.valueOf(JOptionPane.showOptionDialog(null,
					"***** *** * PROGRAMA DE CALCULO - CALCULADORA * *** *****" + "\n Escolha uma opcao:", "Tela", 0,
					JOptionPane.QUESTION_MESSAGE, null, acao, acao[0]));

			switch (((opcao == -1) ? "Sair" : acao[opcao])) {
			case "Soma":
				System.out.println("Iniciando opera��o de Soma");
				soma();
				break;
			case "Subtracao":
				System.out.println("Iniciando opera��o de Subtra��o");
				subtracao();
				break;
			case "Multiplica��o":
				System.out.println("Iniciando opera��o de multiplicacao");
				multiplicacao();
				break;
			case "Divis�o":
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

		JOptionPane.showMessageDialog(null, "Resultado da opera��o �:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void multiplicacao() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.multiplicacao(listaNumeros);

		JOptionPane.showMessageDialog(null, "Resultado da opera��o �:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void subtracao() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.subtracao(listaNumeros);

		JOptionPane.showMessageDialog(null, "Resultado da opera��o �:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static void soma() {

		CalculadoraBasica calculadora = new Calculadora();

		ArrayList<Float> listaNumeros = telaLeitura(true);

		float resultado = calculadora.soma(listaNumeros);

		// float resultado = calculadora.soma(primeiroNumero, proximoNumero);

		JOptionPane.showMessageDialog(null, "Resultado da opera��o �:" + df.format(resultado), "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("Resultado da operacao:" + df.format((resultado)));

	}

	private static ArrayList<Float> telaLeitura(boolean flagLeitura) {

		ArrayList<Float> listaNumeros = new ArrayList<>();

		try {

			String dadosPrimeiraEntrada = JOptionPane.showInputDialog("Digite o primeiro n�mero:");

			if (dadosPrimeiraEntrada == null) {
				JOptionPane.showMessageDialog(null, "\n A��o n�o permitida o uso - Uso incorreto", "Uso incorreto",
						JOptionPane.ERROR_MESSAGE);

				throw new Exception("A��o n�o permitida o uso - Uso incorreto");

			}

			Float primeiroNumero = Float.valueOf(dadosPrimeiraEntrada);

			listaNumeros.add(primeiroNumero);

			while (flagLeitura) {

				String dadosSegundaEntrada = JOptionPane.showInputDialog("Digite o proximo n�mero: ");

				if (dadosSegundaEntrada == null) {
					JOptionPane.showMessageDialog(null, "\n A��o n�o permitida o uso - Uso incorreto", "Uso incorreto",
							JOptionPane.ERROR_MESSAGE);
					throw new Exception("A��o n�o permitida o uso - Uso incorreto");
				}

				float proximoNumero = Float.valueOf(dadosSegundaEntrada);

				listaNumeros.add(proximoNumero);

				flagLeitura = (JOptionPane
						.showInputDialog("Se deseja digitar mais n�meros escreva sim, " + "para sair escreva n�o?")
						.equals("sim") ? true : false);

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

		return listaNumeros;

	}

}
