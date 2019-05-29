import java.util.Scanner;

/**
 * 28o) Utilizando-se de aloca��o din�mica de mem�ria para armazenamento em
 * listas duplamente ligadas, elaborar um programa em linguagem Java que
 * apresente ao operador um menu com as seguintes op��es, sobre uma lista
 * denominada lista: a) Inicializar a lista, fazendo com que o pr�ximo n� a ser
 * apresentado, quando o operador escolher a op��o b), seja o primeiro n�.
 * Apresentar a mensagem �Lista Inicializada�; b) Apresentar o conte�do do
 * pr�ximo n� a cada vez que esta op��o for escolhida, percorrendo assim toda a
 * lista atrav�s desta op��o. Se a lista estiver vazia, apresentar a mensagem
 * �Lista Vazia�. Se for o �ltimo n�, ap�s a apresenta��o de seu conte�do,
 * apresentar a mensagem ��ltimo da Lista�. Se n�o existir o pr�ximo n�,
 * apresentar a mensagem �Lista Encerrada�; c) Apresentar o conte�do do n�
 * anterior a cada vez que esta op��o for escolhida, percorrendo assim toda a
 * lista atrav�s desta op��o. Se a lista estiver vazia, apresentar a mensagem
 * �Lista Vazia�. Se for o primeiro n�, ap�s a apresenta��o de seu conte�do,
 * apresentar a mensagem �Primeiro da Lista�. Se n�o existir o n� anterior,
 * apresentar a mensagem �Lista Encerrada�; d) Inserir um n� na posi��o corrente
 * da lista (ap�s o �ltimo n� apresentado e antes do pr�ximo n� a ser
 * apresentado), sendo que seu conte�do dever� ser digitado pelo operador; e)
 * Eliminar da lista o �ltimo n� v�lido que foi apresentado em tela. Apresentar
 * a mensagem �N� Eliminado� em caso de sucesso. Se a lista foi inicializada
 * imediatamente antes ou se a lista estiver vazia, apresentar a mensagem �N�o
 * h� n� a Proibida a reprodu��o, total ou parcial, do conte�do sem pr�via
 * autoriza��o do autor. Todos os direitos reservados �.
 * USJT-2019-SIN2AN-MCA-ALGESD-Exerc�cios-ProfCalvetti-Parte 2_2.docx 8/10 ser
 * Eliminado�. Ap�s a elimina��o, o n� atual da lista sempre dever� passar a ser
 * o n� inicial da mesma. Cada n� da lista dever� ter um campo string de tamanho
 * 20 caracteres denominado nome para armazenar o nome do aluno, um campo long
 * denominado ra para armazenar o RA do aluno, um campo para armazenar a liga��o
 * ao endere�o anterior da lista denominado anterior e um campo para armazenar a
 * liga��o ao pr�ximo endere�o da lista denominado proximo.
 * 
 * @author Avanxo
 *
 */
public class Exercicio28 {

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
