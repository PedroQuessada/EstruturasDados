package pilha;
import java.util.Scanner;

/**
 * 4º) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de Dados).
 */
public class Exercicio04 {

	public int index;
	public String[] lstString;

	public Exercicio04() {
		lstString = new String[3];
		index = lstString.length;
	}

	public static void main(String[] args) {
		Exercicio04 pilha = new Exercicio04();

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 4) {
			System.out.println("Digite a ação desejada");
			System.out.println("1) Inserir Elemento");
			System.out.println("2) Consultar Elemento");
			System.out.println("3) Retirar Elemento");
			System.out.println("4) Sair");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o caractere a ser inserido");
				String c = input.next();
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
				System.exit(0);
				break;
			}
		}
	}

	private void push(String e) {
		if (size() == 0) System.err.println("Lista está cheia");
		else this.lstString[--index] = e;
	}

	private String pop() {
		if (this.isEmpty()) System.err.println("Lista está vazia");
		else return this.lstString[index++];
		return null;
	}

	private void top() {
		if (this.isEmpty()) System.err.println("Lista está vazia");
		else System.out.println("Elemento do topo: " + this.lstString[index]);

		System.out.println("");
	}

	private boolean isEmpty() {
		return index == lstString.length;
	}

	private int size() {
		return index;
	}

	private void listAll() {
		System.out.println("Lista: ");

		for (int i = 0; i < lstString.length; i++) {
			String key = lstString[i];

			System.out.println("index: " + i + " char: " + key);
		}
		System.out.println("");
	}
}
