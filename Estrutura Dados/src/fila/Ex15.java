/***
 * Elaborar um programa, em linguagem Java, capaz de armazenar no máximo 10
caracteres em um vetor, manipulando-os através da estrutura de dados denominada fila
circular (implementação conceitual). O elemento de índice 0 desse vetor deverá ser o
primeiro a ser armazenado e por conseqüência o primeiro a ser retirado. As operações
básicas dessa estrutura de dados deverão obedecer ao seguinte menu:
• Inserir Elemento;
• Consultar Elemento;
• Retirar Elemento;
• Sair.
Optando por Inserir Elemento, o programa deverá pedir ao operador que digite o elemento
a ser inserido na fila circular; Optando por Consultar Elemento, o programa deverá
apresentar em tela o primeiro elemento inserido na fila circular, sem que o mesmo seja
retirado dela e a quantidade de elementos armazenados na fila circular; Optando por
Retirar Elemento, o programa deverá retirar o primeiro elemento da fila circular,
apresentando-o em tela; E, optando por Sair, o programa deverá ser encerrado.
 */

package fila;

import java.util.Scanner;

public class Ex15 {
	
	public static int    tamanho  = 10;
	public static char [] fila  = new char[tamanho];
	public static int    primeiro = 0;
	public static int    ultimo   = 0;
	public static int    total    = 0;

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.println("Escolha uma opçao: ");
			System.out.println("");
			System.out.println("1) Inserir elemento");
			System.out.println("2) Consultar elemento");
			System.out.println("3) Pegar elemento");
			System.out.println("4) Mostrar todo vetor");
			System.out.println("0-) Sair");
			opcao = ler.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite o caracter");
				char valor = ler.next().charAt(0);
				char resp = push(valor);
				if(resp == 0) {
					System.out.println("Pilha cheia");
				}else {
					System.out.println("Caracter inserido com sucesso");
				}
			}
			else if(opcao == 2) {
				char resp = top();
				if(resp == 0) {
					System.out.println("Pilha vazia");
				}else {
					System.out.println(resp);
				}
				
			}
			else if(opcao == 3) {
				char resp = pop();
				if(resp == 0) {
					System.out.println("Pilha vazia");
				}else {
					System.out.println(resp);
				}
			}
			else if(opcao == 4) {
				for(int i = 0; i < fila.length; i++) {
					System.out.print(fila[i]);
					System.out.println("");
				}
			}
			else if(opcao == 0) {
				System.out.println("Saindo...");
			}
			else {
				System.out.println("Opcao invalida");
			}
			
		}while(opcao != 0);


	}

	public static char push(char elemento) {
		if(isFull()) {
			return 0;
		}
		fila[ultimo] = elemento;
		ultimo = (ultimo + 1) % fila.length;
		total++;
		return elemento;
	}
	
	public static char top() {
		if(isEmpty()) {
			return 0;
		}
		char elemento = fila[primeiro];
		return elemento;
	}
	
	public static char pop() {
		if(isEmpty()) {
			return 0;
		}
		char elemento = fila[primeiro];
		primeiro = (primeiro + 1) % fila.length;
		total--;
		return elemento;
	}
	
	public static boolean isEmpty() {
		return total == 0;
	}
	
	public static boolean isFull() {
		return total == fila.length;
	}
	
}
