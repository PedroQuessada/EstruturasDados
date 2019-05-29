import java.util.Scanner;

/**
 * 22º) Utilizando-se de alocação dinâmica de memória para armazenamento em
 * listas singularmente encadeadas, elaborar um programa em linguagem Java que
 * realize as seguintes funções: a) Inserir um novo nó em uma lista, sempre ao
 * final dela, digitando seu conteúdo; b) Remover sempre o último nó da
 * respectiva lista; c) Sair. Cada nó da lista deverá ter um campo para
 * armazenar números inteiros e positivos denominado elemento e um campo para
 * armazenar a ligação ao próximo endereço da lista denominado próximo, formando
 * a estrutura de dados denominada Lista Singularmente Encadeada.
 * 
 * @author Avanxo
 *
 */
public class Exercicio24 {

	public static class ListInt {

		private Node head;
		private Node tail;
		private int size;

		public ListInt() {
			head = null;
			tail = null;
			size = 0;
		}
		
		public Node getHead() {
			return this.head;
		}
		
		public Node getTail() {
			return this.tail;
		}
		
		public void insertNextNode(int el) {
			Node node = new Node(el, null);
			
			if(this.isEmpty()) this.head = node;
			else this.tail.setNext(node);
				
			this.tail = node;
			this.size++;
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

		private int element;
		private Node nextNode;

		public Node(int element, Node nextNode) {
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
			System.out.println("Digite a opção desejada");
			System.out.println("a) Inserir um novo nó em uma lista, sempre ao final dela, digitando seu conteúdo");
			System.out.println("b) Remover sempre o último nó da respectiva lista;");
			System.out.println("c) Verificar todos os nós;");
			System.out.println("d) Sair");

			option = input.next().charAt(0);
			
			switch (option) {
			case 'a':
				System.out.println("Insera o valor do novo elemento");
				
				int i = input.nextInt();
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
