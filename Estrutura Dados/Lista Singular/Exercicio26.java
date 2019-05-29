import java.util.Scanner;

/**
26o
) Utilizando-se de aloca��o din�mica de mem�ria para armazenamento em listas
singularmente encadeadas, elaborar um programa em linguagem Java que realize as
seguintes fun��es:
a) Dever� ser digitada uma frase qualquer, de tamanho indeterminado, composta por
diversos caracteres;
b) Cada caractere dessa frase dever� ser armazenado em um n� diferente de uma lista
denominada lista;
c) Dever� ser digitado um caractere qualquer que dever� ser removido da lista em todas
as posi��es onde ele se encontrar;
d) Dever� ser apresentada a frase resultante, sem a presen�a em nenhuma posi��o do
caractere digitado.
e) Fazer todas as consist�ncias necess�rias, tais como: caractere digitado n�o se encontra
na lista, lista vazia, etc..
 * 
 * @author Avanxo
 *
 */
public class Exercicio26 {

	public static class ListInt {

		private Node head;
		private Node tail;
		private Node ponteiro;
		private int size;

		public ListInt() {
			head = null;
			tail = null;
			ponteiro = null;
			size = 0;
		}
		
		public Node getHead() {
			return this.head;
		}
		
		public Node getTail() {
			return this.tail;
		}
		
		public void insertNextNode(String el) {
			
			for(int i = 0; i < el.length(); i++) {
				
				Node node = new Node(el.charAt(i), null);
				
				if(this.isEmpty()) this.head = node;
				else this.tail.setNext(node);
					
				this.tail = node;
				this.size++;
			}		
		}
		
		public void remover(char caracter) {
			for(int i = 0; i < size; i++) {
				if(!this.isEmpty()) {
					if(ponteiro.element == caracter) {
						
					}
					
					
					
				}else {
					System.out.println("Lista vazia!");
				}
			}
		}
		
		
		public void removeNode() {
			if(!this.isEmpty()) {
				
				if(this.size() > 1) {
					Node aux = this.getHead();
					while (aux.getNext() != this.tail) aux = aux.getNext();
					this.tail = aux;
					this.tail.setNext(null);
				}else {
					this.head = null;
					this.tail = null;
				}
				
				this.size--;
			}			
		}
		
		public int size() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return this.size == 0;
		}
		
		public void listAllNodes() {
			Node aux = this.getHead();
			while(aux != null) {
				System.out.println("Elemento: " + aux.getElement());
				aux = aux.getNext();
			}
		}
	}

	public static class Node {

		private char element;
		private Node nextNode;

		public Node(char element, Node nextNode) {
			this.element = element;
			this.nextNode = nextNode;
		}
		
		public void setNext(Node node) {
			this.nextNode = node;
		}
		
		public Node getNext() {
			return this.nextNode;
		}
		
		public boolean hasNext() {
			return this.nextNode != null;
		}

		public int getElement() {
			return this.element;
		}
	}

	public static void main(String[] args) {
		ListInt lstEncadeada = new ListInt();

		Scanner input = new Scanner(System.in);
		char option = 'a';

		while (option != 'd') { 
			System.out.println("Digite a op��o desejada");
			System.out.println("a) Inserir um novo n� em uma lista, sempre ao final dela, digitando seu conte�do");
			System.out.println("b) Remover sempre o �ltimo n� da respectiva lista;");
			System.out.println("c) Verificar todos os n�s;");
			System.out.println("d) Sair");

			option = input.next().charAt(0);
			
			switch (option) {
			case 'a':
				System.out.println("Insera o valor do novo elemento");
				
				String i = input.next();
				lstEncadeada.insertNextNode(i);
				break;
			case 'b':
				lstEncadeada.removeNode();
				break;
			case 'c':
				lstEncadeada.listAllNodes();
				break;
			case 'd':
				System.exit(0);
				break;
			}
		}

	}
}
