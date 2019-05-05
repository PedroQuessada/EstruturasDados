/***
Elaborar um programa, em linguagem Java, capaz de armazenar no máximo 10
caracteres em um vetor, manipulando-os através da estrutura de dados denominada pilha
(implementação conceitual). O elemento de índice 0 desse vetor deverá ser o primeiro a
ser armazenado e por consequência o último a ser retirado. As operações básicas dessa
estrutura de dados deverão obedecer ao seguinte menu:
• Inserir Elemento;
• Consultar Elemento;
• Retirar Elemento;
• Sair.
Optando por Inserir Elemento, o programa deverá pedir ao operador que digite o elemento
a ser inserido na pilha; Optando por Consultar Elemento, o programa deverá apresentar
em tela o último elemento inserido na pilha, sem que o mesmo seja retirado dela e a
quantidade de elementos armazenados na pilha; Optando por Retirar Elemento, o
programa deverá retirar o último elemento da pilha, apresentando-o em tela; E, optando
por Sair, o programa deverá ser encerrado.
 */

package pilha;

import java.util.Scanner;

public class Ex1 {
	
	public static int tamanho = 10;
	public static char [] pilha = new char [tamanho];
	public static int posicao = 0;

	public static void main(String [] args) {
		
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
				for(int i = 0; i < 10; i++) {
					System.out.print(pilha[i]);
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
	
	//verifica o tamanho da pilha
	public static int size() {
		return posicao;
	}
	
	//retorna o ultimo elemento do vetor sem remover ele da pilha
	public static char top() {
		if(posicao == 0) return 0;
		return pilha[posicao -1];
	}
	
	//retira o ultimo elemento da pilha
	public static char pop() {
		if(posicao == 0) return 0;
		return pilha[--posicao];
	}
	
	//insere um elemento na pilha
	public static char push(char valor) {
		if(posicao == tamanho)return 0;
		return pilha[posicao++] = valor;
	}
	
	
}
