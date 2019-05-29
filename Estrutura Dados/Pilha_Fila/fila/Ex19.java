package fila;

import java.util.Scanner;

public class Ex19 {

	public static int    tamanho  = 3;
	public static int [] fila  = new int[tamanho];
	public static int    primeiro = 0;
	public static int    ultimo   = 0;
	public static int    total    = 0;
	
	public static void main(String [] args) {
		
		Scanner ler = new Scanner(System.in);
		int opcaoMatematica = 0;
		int opcao = 0;
		do {
			System.out.println("Escolha uma opçao: ");
			System.out.println("");
			System.out.println("1) Inserir elemento");
			System.out.println("2) Consultar elemento");
			System.out.println("3) Pegar elemento");
			System.out.println("4) Mostrar todo vetor");
			System.out.println("5) fazer operacao matematica");
			System.out.println("0-) Sair");
			opcao = ler.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite o caracter");
				int valor = ler.nextInt();
				int resp = push(valor);
				if(resp == 0) {
					System.out.println("Pilha cheia");
				}else {
					System.out.println("Caracter inserido com sucesso");
				}
			}
			else if(opcao == 2) {
				int resp = top();
				if(resp == 0) {
					System.out.println("Pilha vazia");
				}else {
					System.out.println(resp);
				}
				
			}
			else if(opcao == 3) {
				int resp = pop();
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
			else if(opcao == 5) {
				System.out.println("1) + ");
				System.out.println("2) - ");
				System.out.println("3) * ");
				System.out.println("4) / ");
				opcaoMatematica = ler.nextInt();
				if(opcaoMatematica == 1) {
					//adicicao
					int resp = soma();
					if(resp == -1) {
						System.out.println("Não a numeros suficiente para fazer a operacao");
					}else {
						System.out.println("A soma entre os dois ultimos elementos é de: " + resp);
					}
				}
				else if(opcaoMatematica == 2) {
					//subtracao
					int resp = subtracao();
					if(resp == -1) {
						System.out.println("Não a numeros suficiente para fazer a operacao");
					}else {
						System.out.println("A subtracao entre os dois ultimos elementos é de: " + resp);
					}
				}
				else if(opcaoMatematica == 3) {
					//multiplicacao
					int resp = multiplicacao();
					if(resp == -1) {
						System.out.println("Não a numeros suficiente para fazer a operacao");
					}else {
						System.out.println("A multiplicacao entre os dois ultimos elementos é de: " + resp);
					}
				}
				else if(opcaoMatematica == 4) {
					//divisao
					int resp = divisao();
					if(resp == -1) {
						System.out.println("Não a numeros suficiente para fazer a operacao");
					}else {
						System.out.println("A divisao entre os dois ultimos elementos é de: " + resp);
					}
				}
				else{
					System.out.println("Opcao invalida");
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
	
	public static int push(int elemento) {
		if(isFull()) {
			return 0;
		}
		fila[ultimo] = elemento;
		ultimo = (ultimo + 1) % fila.length;
		total++;
		return elemento;
	}
	
	public static int top() {
		if(isEmpty()) {
			return 0;
		}
		int elemento = fila[primeiro];
		return elemento;
	}
	
	public static int pop() {
		if(isEmpty()) {
			return 0;
		}
		int elemento = fila[primeiro];
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
	
	//pega os dois ultimo valores e soma, apos isso insere a soma na pilha
	public static int soma() {
		int numero1 = pop();
		int numero2 = pop();
		
		if(numero1 == 0 || numero2 == 0) {
			return -1;
		}
		else {
			int soma = numero1 + numero2;
			int resp = push(soma);
			return resp;
		}
		
	}
	
	//pega os dois ultimo valores e subtrai, apos isso insere a subtracao na pilha
	public static int subtracao() {
		int numero1 = pop();
		int numero2 = pop();
		
		if(numero1 == 0 || numero2 == 0) {
			return -1;
		}
		else {
			int soma = numero1 - numero2;
			int resp = push(soma);
			return resp;
		}
		
	}
	
	//pega os dois ultimo valores e multiplica, apos isso insere a multiplicacao na pilha
	public static int multiplicacao() {
		int numero1 = pop();
		int numero2 = pop();
		
		if(numero1 == 0 || numero2 == 0) {
			return -1;
		}
		else {
			int soma = numero1 * numero2;
			int resp = push(soma);
			return resp;
		}
		
	}
	
	//pega os dois ultimo valores e dividi, apos isso insere a divicao na pilha
	public static int divisao() {
		int numero1 = pop();
		int numero2 = pop();
		
		if(numero1 == 0 || numero2 == 0) {
			return -1;
		}
		else {
			int soma = numero1 / numero2;
			int resp = push(soma);
			return resp;
		}
			
	}
	
}
