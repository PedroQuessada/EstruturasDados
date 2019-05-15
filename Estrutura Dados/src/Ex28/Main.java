package Ex28;

import java.util.Scanner;

public class Main {

	
	public static NoMetodos lista = new NoMetodos();
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite uma opcao");
		int opcao = -1;
		
		do {
			System.out.println("1- Inserir elemento");
			System.out.println("2- Inserir Atual");
			System.out.println("3- Apresenta atual");
			System.out.println("4- Apresenta proximo");
			System.out.println("5- Apresenta anterior");
			System.out.println("6- Remover atual");
			opcao = ler.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite o elemento a ser inserido: ");
				int elemento = ler.nextInt();
				lista.inserirNoFinal(elemento);
			}
			else if(opcao == 2) {
				if(lista.isEmpty()) {
					System.out.println("A lista está vazia!");
				}
				else {
					System.out.println("O elemento: " + lista.removerDoFinal() + " Foi adicionado na posicao atual");
				}
				
			}
			else if(opcao == 3) {
				
				if(lista.isEmpty()) {
					System.out.println("A lista está vazia!");
				}
				else {
					System.out.println("O elemento atual é: " + lista.apresentaAtual());
				}
			}
			else if(opcao == 4) {
				if(lista.isEmpty()) {
					System.out.println("A lista está vazia!");
				}
				else if(lista.ultimo()) {
					System.out.println("Não existe proximo elemento");
				}
				else {
					System.out.println("O proximo elemento é: " + lista.apresentaProximo());
				}
			}
			else if(opcao == 5) {
				if(lista.isEmpty()) {
					System.out.println("A lista está vazia!");
				}
				else if(lista.primeiro()) {
					System.out.println("Não existe elemento anterior");
				}
				else {
					System.out.println("O elemento anterior é: " + lista.apresentaAnterior());
				}
			}
			else if(opcao == 6){
				if(lista.isEmpty()) {
					System.out.println("A lista está vazia!");
				}
				else {
					System.out.println("O elemento: " + lista.removerDoFinal() + " Foi removido");
				}
			}
			else if(opcao == 7) {
				System.out.println("Saindo...");
			}
			else {
				System.out.println("Opcao invalida tente novamente");
			}
		}while(opcao != 7);
		
	}

}
