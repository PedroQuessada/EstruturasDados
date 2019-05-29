import java.util.Scanner;

/**
 * 25�) Utilizando-se de aloca��o din�mica de mem�ria para armazenamento em listas
singularmente encadeadas, elaborar um programa em linguagem Java que apresente ao
operador um menu com as seguintes op��es, sobre uma lista denominada lista:
a) Inicializar a lista fazendo com que o pr�ximo n� a ser apresentado, quando o operador
escolher a op��o b), seja o primeiro n�. Apresentar a mensagem �Lista Inicializada�;

b) Apresentar o conte�do do pr�ximo n� a cada vez que esta op��o for escolhida,
percorrendo assim toda a lista atrav�s desta op��o. Se a lista estiver vazia, apresentar
a mensagem �Lista Vazia�. Se for o �ltimo n�, ap�s a apresenta��o de seu conte�do,
apresentar a mensagem ��ltimo N� da Lista�. Se n�o existir o pr�ximo n�, apresentar
a mensagem �Lista Encerrada�;

c) Inserir um n� na posi��o corrente da lista (ap�s o �ltimo n� apresentado e antes do
pr�ximo n� a ser apresentado), sendo que seu conte�do dever� ser digitado pelo
operador. Ap�s a inser��o, a lista dever� ser inicializada (op��o a) automaticamente;

d) Eliminar da lista o �ltimo n� v�lido que foi apresentado em tela. Apresentar a
mensagem �N� Eliminado� em caso de sucesso. Se a lista foi inicializada
imediatamente antes ou se a lista estiver vazia, apresentar a mensagem �N�o h� n� a
ser Eliminado�. Ap�s a elimina��o, a lista dever� ser inicializada (op��o a)
automaticamente.

Cada n� da lista dever� ter um campo string de tamanho 20 caracteres denominado nome
para armazenar o nome do aluno, um campo long denominado ra para armazenar o RA
do aluno e um campo para armazenar a liga��o ao pr�ximo endere�o da lista denominado
proximo.
 * 
 * @author Avanxo
 *
 */
public class Exercicio25 {

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
		
		public void insertNextNode(String nome, long ra) {
			Node node = new Node(nome, ra, null);
			
			if(this.isEmpty()) this.head = node;
			
			else if(ponteiro.getNext() == null){
				tail.setNext(node);
				ponteiro = tail.getNext();
			}
			else {
				Node aux = ponteiro.getNext();
				
				this.tail.setNext(node);
			}
				
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
		
		public Node getNext() {
			Node aux = null;
			if(isEmpty()) {
				System.out.print("A lista esta vazia");
			}
			
			aux = ponteiro.nextNode;
			if(aux == null) {
				System.out.println("A lista esta vazia");
			}
			
			return aux;
		}
		
		public boolean isEmpty() {
			return this.size == 0;
		}
		
		public void listAllNodes() {
			Node aux = this.getHead();
			while(aux != null) {
				System.out.println("Nome: " + aux.getNome() + "\nRa: " + aux.getRa());
				aux = aux.getNext();
			}
		}
	}

	public static class Node {

		private String nome;
		private long ra;
		private Node nextNode;

		public Node(String nome, long ra, Node nextNode) {
			this.nome = nome;
			this.ra = ra;
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

		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public long getRa() {
			return this.ra;
		}
		
		public void setRa(long ra) {
			this.ra = ra;
		}
	}

	public static void main(String[] args) {
		ListInt lstEncadeada = new ListInt();

		Scanner input = new Scanner(System.in);
		char option = 'a';

		while (option != 'd') { 
			System.out.println("Digite a op��o desejada");
			System.out.println("a) Iniciar lista");
			System.out.println("b) Remover sempre o �ltimo n� da respectiva lista;");
			System.out.println("c) Verificar todos os n�s;");
			System.out.println("d) Sair");

			option = input.next().charAt(0);
			
			switch (option) {
			case 'a':
				System.out.println("Insera o ra");
				long ra = input.nextLong();
				
				System.out.println("Insera o nome");
				String nome = input.next();
				
				lstEncadeada.insertNextNode(nome, ra);
				break;
			case 'b':
				//lstEncadeada.get
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
