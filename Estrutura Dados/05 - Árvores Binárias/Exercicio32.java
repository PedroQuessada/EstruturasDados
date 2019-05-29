import java.util.Scanner;

/**
 * 
 * 32o) Elaborar um programa em linguagem Java capaz de armazenar itens
 * num�ricos e inteiros em N�S de uma estrutura de dados do tipo �RVORE BIN�RIA.
 * O operador dever� digitar os valores para os itens seguindo a regra de Acesso
 * PR�-ORDENADO e apresent�-los seguindo o Acesso P�S-ORDENADO.
 * 
 * @author Avanxo
 *
 */
public class Exercicio32 {

	public static class Arvore {
		private Node raiz;
		private int size;

		public Arvore() {
			this.raiz = null;
			size = 0;
		}

		public void insert(int num) {
			Node node = new Node(num, null, null);

			if (this.isEmpty())
				this.raiz = node;
			else
				this.insertLeaf(this.raiz, node);

			this.size++;
		}

		public void insertLeaf(Node nodeRaiz, Node node) {

			if (node.getElement() >= nodeRaiz.getElement()) {

				Node right = nodeRaiz.getRight();

				if (right != null)
					this.insertLeaf(right, node);
				else
					nodeRaiz.setRight(node);
			} else {
				Node left = nodeRaiz.getLeft();

				if (left != null)
					this.insertLeaf(left, node);
				else
					nodeRaiz.setLeft(node);
			}
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public void listTree(String type) {
			if (this.isEmpty())
				System.err.println("�rvore Bin�ria Vazia");

			if (type.equals("posOrdered"))
				this.posOrdered(this.raiz);
		}

		public void posOrdered(Node node) {
			if (node != null) {
				this.posOrdered(node.getLeft());
				this.posOrdered(node.getRight());
				System.out.print(node.getElement() + " ");
			}
		}

	}

	public static class Node {
		private int element;
		private Node left;
		private Node right;

		public Node(int e, Node nodeLeft, Node nodeRight) {
			this.element = e;
			this.left = nodeLeft;
			this.right = nodeRight;
		}

		public int getElement() {
			return element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	public static void main(String[] args) {
		Arvore tree = new Arvore();

		Scanner input = new Scanner(System.in);

		char option = 0;
		while (option != 'c') {
			System.out.println("a) Inserir um n� na �rvore");
			System.out.println("b) Apresentar P�s Ordenado");
			System.out.println("c) Sair");

			option = input.next().charAt(0);

			switch (option) {
			case 'a':
				System.out.println("Digite um n�mero para inserir na �rvore");

				int num = input.nextInt();

				tree.insert(num);
				break;
			case 'b':
				tree.listTree("posOrdered");
				System.out.println("");
				break;
			case 'c':
				System.exit(0);
				break;
			default:
				System.err.println("A��o n�o configurada");
				break;
			}

		}

	}
}
