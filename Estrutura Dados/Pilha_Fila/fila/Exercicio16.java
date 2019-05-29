package fila;
import java.util.Scanner;

public class Exercicio16 {

	private int firstIndex;
	private int lastIndex;
	private int total;
	private boolean isFull;
	private String[] lstString;

	public Exercicio16() {
		this.firstIndex = 0;
		this.lastIndex = 0;
		this.total = 0;
		this.lstString = new String[3];
		this.isFull = false;
	}

	public void enQueue(String e) {
		if (isFull)
			throw new RuntimeException("Fila Cheia");

		lstString[lastIndex++] = e;

		if (lastIndex >= lstString.length)
			lastIndex = 0;
		isFull = lastIndex == firstIndex;
		total++;
	}

	public String deQueue() {
		if (this.isEmpty())
			throw new RuntimeException("Fila vazia");

		String el = lstString[firstIndex++];

		if (firstIndex >= lstString.length)
			firstIndex = 0;
		isFull = false;
		total--;
		return el;
	}

	private String front() {
		if (this.isEmpty()) System.out.println("Fila vazia");
		return lstString[firstIndex];
	}

	public boolean isFull() {
		return this.isFull;
	}

	public boolean isEmpty() {
		return total == 0;
	}

	private void listAll() {
		System.out.println("Lista: ");

		for (int i = 0; i < this.lstString.length; i++) {
			String key = this.lstString[i];
			System.out.println("index: " + i + " key: " + key);
		}
		System.out.println("");
	}

	/**
	 * Teste da Fila
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Exercicio16 fila = new Exercicio16();

		Scanner input = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 4) {
			System.out.println("Digite a ação desejada");
			System.out.println("1) Inserir Elemento");
			System.out.println("2) Consultar Elemento do Topo");
			System.out.println("3) Remover Elemento");
			System.out.println("4) Sair");
			
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite uma frase");
				String el = input.next();
				fila.enQueue(el);
				
				// Verifica lista
				fila.listAll();
				
				break;
			case 2:
				System.out.println("Primeiro elemento: " + fila.front());
				System.out.print("\n");
				break;
			case 3:
				System.out.println("Removendo elemento: " + fila.deQueue());
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
	}
}
