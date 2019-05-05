/***
 * Idem ao exercício 15, porém levando-se em conta que o elemento de índice 9 deverá
ser o primeiro armazenado e o elemento de índice 0 deverá ser o último armazenado na
fila circular, e assim seguindo sucessivamente.
 */

package fila;

import java.util.Scanner;

public class ex17 {
	
	public static int    tamanho  = 3;
	public static char [] fila  = new char[tamanho];
	public static int    primeiro = fila.length;
	public static int    ultimo   = fila.length ;
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
				for(int i = 0; i < 3; i++) {
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
		if(ultimo == 0) {
			ultimo = fila.length -1;
		}else {
			ultimo = (ultimo - 1) % fila.length;
		}
		fila[ultimo] = elemento;
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
		
		if(primeiro == 0) {
			primeiro = fila.length - 1;
		}else {
			primeiro = (primeiro - 1) % fila.length;
		}
		char elemento = fila[primeiro];
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
