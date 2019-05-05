/***
Idem ao exercício 1, porém levando-se em conta que o elemento de índice 9 deverá
ser o primeiro armazenado e o elemento de índice 0 deverá ser o último armazenado na
pilha.
 */

package pilha;

import java.util.Scanner;

public class Ex3 {
	
	public static int tamanho = 10;
	public static char [] pilha = new char [tamanho];
	public static int posicao = 10;

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
				for(int i = 0; i < 5; i++) {
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
		if(posicao == 10) return 0;
		return pilha[posicao];
	}
	
	//retira o ultimo elemento da pilha
	public static char pop() {
		if(posicao == 10) return 0;
		return pilha[posicao++];
	}
	
	//insere um elemento na pilha
	public static char push(char valor) {
		if(posicao == 0)return 0;
		return pilha[--posicao] = valor;
	}
	
	
}
