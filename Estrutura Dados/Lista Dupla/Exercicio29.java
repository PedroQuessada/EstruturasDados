import java.util.Scanner;

/**
 * 29o
) Utilizando-se de aloca��o din�mica de mem�ria para armazenamento em listas
duplamente encadeadas, elaborar um programa em linguagem Java que realize as
seguintes fun��es:
a) Dever� ser digitada uma frase qualquer, de tamanho indeterminado, composta por
diversos caracteres;
b) Cada caractere dessa frase dever� ser armazenado em um n� diferente de uma lista
denominada lista;
c) Dever� ser digitado um caractere qualquer que dever� ser removido da lista em todas
as posi��es onde ele se encontrar;
d) Dever� ser apresentada a frase resultante, do primeiro n� ao �ltimo da lista, sem a
presen�a em nenhuma posi��o do caractere digitado;
e) Dever� ser apresentada a frase resultante, do �ltimo n� ao primeiro da lista, sem a
presen�a em nenhuma posi��o do caractere digitado;
f) Fazer todas as consist�ncias necess�rias, tais como: caractere digitado n�o se encontra
na lista, lista vazia, etc.
 * 
 * @author Avanxo
 *
 */
public class Exercicio29 {

	public static class ListDE {

		private Node head;
		private Node tail;
		private Node indexNode;
		private int size;

		public ListDE() {
			this.head = null;
			this.tail = null;
			this.indexNode = null;
			this.size = 0;
		}

		public void insertNext(int element) {
			Node node = new Node(element, null, null);

			if (this.isEmpty()) {
				this.head = node;
				this.tail = node;
				this.indexNode = this.head;
			} else {
				this.tail.setNext(node);
				node.setPrevious(this.tail);
				this.tail = node;
				this.indexNode = this.head;
			}

			this.size++;
		}

		public int removeIndex() {
			
			int element = this.indexNode.getElement();
			if (this.size() == 1) {
				this.head = null;
				this.tail = null;
				this.indexNode = null;
			} else {
				Node previous = this.indexNode.getPrevious();
				if(this.hasNext()) {
					previous.setNext(this.indexNode.getNext());
					this.indexNode.getNext().setPrevious(previous);
					this.indexNode.setNext(null);
					this.indexNode.setPrevious(null);
				}
				
				this.indexNode = this.head;
			}

			this.size--;
			return element;
		}

		public void listAllElements() {
			if (this.isEmpty())
				System.err.println("\nLista Vazia");

			Node aux = this.head;
			while (aux != null) {
				System.out.println("Elemento: " + aux.getElement());
				aux = aux.getNext();
			}
			System.out.println("");
		}
		
		public void setIndexNode(Node node) {
			if(this.isEmpty()) {
				this.head = node;
				this.tail = node;
				this.indexNode = this.head;
			}else {
				node.setPrevious(this.indexNode);
				this.indexNode.setNext(node);
				this.indexNode = node;
			}
			
			this.size++;
		}
		
		public void setIndexNode(int element) {
			Node node = new Node(element, null, null);
			
			if(this.isEmpty()) {
				this.head = node;
				this.tail = node;
				this.indexNode = this.head;
			}else {
				node.setPrevious(this.indexNode);
				node.setNext(this.indexNode.getNext());
				if(this.hasNext()) this.indexNode.getNext().setPrevious(node);
				
				this.indexNode.setNext(node);
				this.indexNode = node;
			}
			
			this.size++;
		}
			
		public boolean hasNext() {
			return this.indexNode.getNext() != null;
		}

		public boolean hasPrevious() {
			return this.indexNode.getPrevious() != null;
		}

		public int getCurrentElement() {
			return this.indexNode.getElement();
		}

		public int getNextElement() {
			int proximo = this.indexNode.getNext().getElement();
			this.indexNode = this.indexNode.getNext();
			return proximo;
		}

		public int getPreviousElement() {
			int anterior = this.indexNode.getPrevious().getElement();
			this.indexNode = this.indexNode.getPrevious();
			return anterior;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return this.size;
		}
	}

	public static class Node {

		private int element;
		private Node nextNode;
		private Node previousNode;

		public Node(int element, Node previous, Node next) {
			this.element = element;
			this.previousNode = previous;
			this.nextNode = next;
		}

		public int getElement() {
			return this.element;
		}

		public void setNext(Node next) {
			this.nextNode = next;
		}

		public Node getNext() {
			return this.nextNode;
		}

		public void setPrevious(Node previous) {
			this.previousNode = previous;
		}

		public Node getPrevious() {
			return this.previousNode;
		}
	}

	public static void main(String[] args) {
		ListDE lista = new ListDE();

		Scanner input = new Scanner(System.in);

		char opcao = 'i';
		while (opcao != 'h') {
			System.out.println("Digite a op��o desejada");
			System.out.println("a) Insira um novo elemento a lista");
			System.out.println("b) Apresentar pr�ximo n�");
			System.out.println("c) Apresentar n� anterior");
			System.out.println("d) Inserir um n� na posi��o corrente da lista");
			System.out.println("e) Remove n� atual");
			System.out.println("g) Sair.");

			opcao = input.next().toLowerCase().charAt(0);
			switch (opcao) {
			case 'a':
				System.out.println("\nDigite um n�mero");
				lista.insertNext(input.nextInt());
				break;
			case 'b':
				if (lista.isEmpty()) System.err.println("Lista vazia");
				
				else if(lista.hasNext()) {
					int element = lista.getNextElement();
					System.out.println("Elemento: " + element);
					
					if(!lista.hasNext()) System.err.println("�ltimo Elemento");
				}else{
					System.err.println("Lista Encerrada");
				}
				break;
			case 'c':
				if (lista.isEmpty()) System.err.println("Lista vazia");
				
				else if(lista.hasPrevious()) {
					int element = lista.getPreviousElement();
					System.out.println("Elemento: " + element);
					
					if(!lista.hasPrevious()) System.err.println("Primeiro da Lista");
				}else{
					System.err.println("Lista Encerrada");
				}
				break;
			case 'd':
				if (lista.isEmpty()) System.err.println("Lista vazia");
				
				else {
					System.out.println("\nDigite um n�mero");
					lista.setIndexNode(input.nextInt());
				}
				break;
			case 'e':
				if (lista.isEmpty()) System.err.println("N�o h� n� a ser eliminado");
				else {
					int element = lista.removeIndex();
					System.out.println("N� Eliminado: " + element);
				}
				break;
				
			default:
				System.err.println("A��o n�o configurada");
				break;
			}
		}

	}

}
