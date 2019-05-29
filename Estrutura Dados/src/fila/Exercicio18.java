package fila;
import java.util.Scanner;

public class Exercicio18 {

	private int firstIndex;
	private int lastIndex;
	private int total;
	private boolean isFull;
	private double[] lstDouble;
	
	public Exercicio18() {
		this.lstDouble = new double[3];
		this.isFull = false;
		this.firstIndex = lstDouble.length;
		this.lastIndex  = lstDouble.length;
		this.total = 0;
	}
	
	public void enQueue(double i) {
		if(isFull) throw new RuntimeException("Fila Cheia");
		
		int index = --lastIndex;
		if(index < 0) lastIndex = lstDouble.length-1;
		
		lstDouble[lastIndex] = i;
		isFull = lastIndex == firstIndex;
		total++;
	}
	
	public double deQueue() {
		if(this.isEmpty()) throw new RuntimeException("Fila vazia");
		
		int index = --firstIndex;
		if(index < 0) firstIndex = lstDouble.length-1;
		
		double i = lstDouble[firstIndex];
		isFull = false;
		total--;
		return i;
	}
	
	private double front() {
		if(this.isEmpty()) throw new RuntimeException("Fila vazia");
		return lstDouble[lastIndex];
	}
	
	public boolean isFull() {
		return this.isFull;
	}
	
	public boolean isEmpty() {
		return total == 0;
	}
	
	private void listAll() {
		System.out.println("Lista: ");
		
		for (int i = 0; i < this.lstDouble.length; i++) {
			double key = this.lstDouble[i];
			System.out.println("index: " + i + " key: " + key);
		}
		System.out.println("");
	}
	
	/**
	 * Teste da Fila
	 * @param args
	 */
	public static void main(String[] args) {
		Exercicio18 fila = new Exercicio18();

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
				System.out.println("Digite um número");
				int el = input.nextInt();
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
