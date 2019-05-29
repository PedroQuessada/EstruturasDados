package pilha;
import java.util.Scanner;

/**
 * 5�) Utilizando o mesmo princ�pio das fun��es do exerc�cio anterior, elaborar
 * um programa que realize as 4 opera��es matem�ticas entre 5 n�meros do tipo
 * int, que dever�o ser digitados primeiramente em sua totalidade e armazenados
 * em uma pilha e s� ap�s isto, conforme as opera��es matem�ticas que forem
 * sendo digitadas, o resultado da conta venha sendo apresentado sempre em
 * rela��o aos �ltimos elementos da pilha remanescente.
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
			System.out.println("Digite a a��o desejada");
			System.out.println("1) Inserir Elemento");
			System.out.println("2) Consultar Elemento");
			System.out.println("3) Retirar Elemento");
			System.out.println("4) Somar +");
			System.out.println("5) Subtrair -");
			System.out.println("6) Multiplicando *");
			System.out.println("7) Divis�o /");
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
				System.out.println("Subtra��o: " + sub);
				pilha.lastNum = sub;
				break;
			case 6:
				double mult = pilha.multiplicar();
				System.out.println("Multiplica��o: " + mult);
				pilha.lastNum = mult;
				break;
			case 7:
				double div = pilha.divisao();
				System.out.println("Divis�o: " + div);
				pilha.lastNum = div;
				break;
			case 8:
				System.exit(0);
				break;
			}
		}
	}
	
	//OPERA��ES
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
			System.err.println("Lista est� cheia");
		else
			this.lstDouble[index++] = e;
	}

	private double pop() {
		if (this.isEmpty())
			System.err.println("Lista est� vazia");
		else
			return this.lstDouble[--index];
		return 0;
	}

	private double top() {
		if (this.isEmpty()) System.err.println("Lista est� vazia");
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
