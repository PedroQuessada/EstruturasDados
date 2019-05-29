import java.util.Scanner;

/**
 * 27o) Utilizando-se de alocação dinâmica de memória para armazenamento em
 * listas duplamente ligadas, elaborar um programa em linguagem Java que realize
 * as seguintes funções: a) Inserir novo nó sempre ao final da lista denominada
 * lista, digitando-se seus conteúdos. Após a inserção, o nó atual da lista
 * sempre deverá passar a ser o nó inicial da mesma; b) Remover sempre o último
 * nó da lista denominada lista. Após a eliminação, o nó atual da lista sempre
 * deverá passar a ser o nó inicial da mesma; c) Apresentar o conteúdo do nó
 * atual da lista denominada lista; d) Apresentar o conteúdo do próximo nó da
 * lista denominada lista. Caso não haja o próximo nó, apresentar a mensagem
 * “Lista Encerrada”. Havendo o próximo nó, após sua apresentação, o nó atual da
 * lista passará a ser o próximo nó da mesma, que acabou de ser apresentado.; e)
 * Apresentar o conteúdo do nó anterior da lista denominada lista. Caso não haja
 * o nó anterior, apresentar a mensagem “Lista Encerrada”. Havendo o nó
 * anterior, após sua apresentação, o nó atual da lista passará a ser o nó
 * anterior da mesma, que acabou de ser apresentado. Cada nó da lista deverá ter
 * um campo para armazenar números inteiros denominado item, um campo para
 * armazenar a ligação ao endereço anterior da lista denominado anterior e um
 * campo para armazenar a ligação ao próximo endereço da lista denominado
 * proximo.
 * 
 * @author Avanxo
 *
 */
public class Exercicio27 {

	public static class ListDE {
		
		private Node head;
		private Node tail;
		private Node indexNode;
		private int  size;
		
		public ListDE() {
			this.head = null;
			this.tail = null;
			this.indexNode = null;
			this.size = 0;
		}
		
		public void insertNext(int element) {
			Node node = new Node(element, null, null);
			
			if(this.isEmpty()) {
				this.head = node;
				this.tail = node;
				this.indexNode = this.head;
			}else {
				this.tail.setNext(node);
				node.setPrevious(this.tail);
				this.tail = node;
				this.indexNode = this.head;
			}
			
			this.size++;
		}
		
		public int removeFinal() {
			int element = this.tail.getElement();
			
			if(this.size() == 1) {
				this.head = null;
				this.tail = null;
				this.indexNode = null;
			}else {
				this.tail = this.tail.getPrevious();
				this.tail.setNext(null);
				this.indexNode = this.head;
			}
			
			this.size--;
			return element;
		}
		
		public void listAllElements() {
			if(this.isEmpty()) System.err.println("\nLista Vazia");
			
			Node aux = this.head;
			while (aux != null) {
				System.out.println("Elemento: " + aux.getElement());
				aux = aux.getNext();
			}
			System.out.println("");
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
		
		public void setNext(Node next){
			this.nextNode = next;
		}
		
		public Node getNext(){
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
		while(opcao != 'h') {
			System.out.println("Digite a opção desejada");
			System.out.println("a) Inserir novo nó sempre ao final da lista denominada lista, digitando-se seu conteúdo.");
			System.out.println("b) Remover sempre o último nó da lista denominada lista.");
			System.out.println("c) Apresentar o conteúdo do nó atual da lista denominada lista.");
			System.out.println("d) Apresentar o conteúdo do próximo nó da lista denominada lista.");
			System.out.println("e) Apresentar o conteúdo do nó anterior da lista denominada lista.");
			System.out.println("f) Apresentar a lista.");
			System.out.println("g) Sair.");
			
			opcao = input.next().toLowerCase().charAt(0);
			switch (opcao) {
			case 'a':
				System.out.println("\nDigite um número");
				lista.insertNext(input.nextInt());
				break;
			case 'b':
				if(lista.isEmpty()) System.err.println("Lista vazia");
				else {
					int element = lista.removeFinal();
					System.out.println("Elemento removido: " + element);
				}
				break;
			case 'c':
				if(lista.isEmpty()) System.err.println("Lista vazia");
				else System.out.println(lista.getCurrentElement());
				break;
			case 'd':
				if(lista.isEmpty()) System.err.println("Lista vazia");
				else if(lista.hasNext()) System.out.println(lista.getNextElement());
				else System.err.println("Não há próximo na Lista");
				break;
			case 'e':				
				if(lista.isEmpty()) System.err.println("Lista vazia");
				else if(lista.hasPrevious()) System.out.println(lista.getPreviousElement());
				else System.err.println("Não há anterior na Lista");
				break;		
			case 'f':				
				lista.listAllElements();
				break;				
			case 'g':
				System.exit(0);
				break;

			default:
				break;
			}
		}
		
	}
		
}
