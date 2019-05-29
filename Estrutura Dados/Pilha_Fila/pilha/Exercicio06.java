package pilha;
import java.util.Scanner;

/**
 * 5°) Utilizando o mesmo princípio das funções do exercício anterior, elaborar
 * um programa que realize as 4 operações matemáticas entre 5 números do tipo
 * int, que deverão ser digitados primeiramente em sua totalidade e armazenados
 * em uma pilha e só após isto, conforme as operações matemáticas que forem
 * sendo digitadas, o resultado da conta venha sendo apresentado sempre em
 * relação aos últimos elementos da pilha remanescente.
 * 
 * @author Avanxo
 *
 */
public class Exercicio06 {

	public int index;
	public double lastNum = -999999;
	public double[] lstDouble;

	public Exercicio06() {
		index = 0;
		lstDouble = new double[5];
	}

	public static void main(String[] args) {
		Exercicio06 pilha = new Exercicio06();

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 8) {
			System.out.println("Digite a ação desejada");
			System.out.println("1) Inserir Elemento");
			System.out.println("2) Consultar Elemento");
			System.out.println("3) Retirar Elemento");
			System.out.println("4) Somar +");
			System.out.println("5) Subtrair -");
			System.out.println("6) Multiplicando *");
			System.out.println("7) Divisão /");
			System.out.println("8) Sair");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o caractere a ser inserido");
				int c = input.nextInt();
				pilha.push(c);
				pilha.listAll();
				break;
			case 2:
				pilha.top();
				break;
			case 3:
				System.out.println(pilha.pop());
				break;
			case 4:
				double soma = pilha.somar();
				System.out.println("Soma: " + soma);
				pilha.lastNum = soma;
				break;
			case 5:
				double sub = pilha.subtrair();
				System.out.println("Subtração: " + sub);
				pilha.lastNum = sub;
				break;
			case 6:
				double mult = pilha.multiplicar();
				System.out.println("Multiplicação: " + mult);
				pilha.lastNum = mult;
				break;
			case 7:
				double div = pilha.divisao();
				System.out.println("Divisão: " + div);
				pilha.lastNum = div;
				break;
			case 8:
				System.exit(0);
				break;
			}
		}
	}
	
	//OPERAÇÕES
	private double somar() {
		return this.getLastNum() + this.pop();
	}
	
	private double subtrair() {
		return this.getLastNum() - this.pop();
	}

	private double multiplicar() {
		return this.getLastNum() * this.pop();
	}
	
	private double divisao() {
		return this.getLastNum() / this.pop();
	}

	private void push(double e) {
		if (this.isFull())
			System.err.println("Lista está cheia");
		else
			this.lstDouble[index++] = e;
	}

	private double pop() {
		if (this.isEmpty())
			System.err.println("Lista está vazia");
		else
			return this.lstDouble[--index];
		return 0;
	}

	private double top() {
		if (this.isEmpty()) System.err.println("Lista está vazia");
		else return this.lstDouble[index-1];
		return 0;
	}

	private boolean isEmpty() {
		return index <= 0;
	}
	
	private boolean isFull() {
		return index == lstDouble.length;
	}

	private double size() {
		return index;
	}
	
	private double getLastNum() {
		if(lastNum == -999999) return this.pop();
		else return lastNum;
	}

	private void listAll() {
		System.out.println("Lista: ");

		for (int i = 0; i < lstDouble.length; i++) {
			double key = lstDouble[i];

			System.out.println("index: " + i + " char: " + key);
		}
		System.out.println("");
	}
}
