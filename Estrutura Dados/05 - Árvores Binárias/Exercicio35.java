import java.util.Scanner;

/**
 * 35º) Elaborar um programa em linguagem Java que apresente ao operador o menu
 * abaixo e execute as funções descritas nele: A- Inserir Nó na Árvore (Acesso
 * Pré-Ordenado); A- Apresentar Árvore; B- Eliminar Nó da Árvore (Digitado o
 * Conteúdo do Nó); C- Sair. Obs.: Os itens A e B são semelhantes ao exercício
 * anterior. O item C deve solicitar a digitação de um Nó, que se existir na
 * árvore, será ser eliminado. Informar todas as possibilidades em tela. Quando
 * eliminar um nó pai que tenha apenas um dos dois nós filhos, esse nó filho
 * assumirá o lugar do nó pai. Quando eliminar um nó pai que tenha os dois nós
 * filhos, o nó filho da direita assumirá o lugar do nó pai e o nó filho da
 * esquerda deverá ser alocado corretamente ao novo nó pai.
 * 
 * @author Avanxo
 *
 */
public class Exercicio35 {

	static final int COUNT = 10;

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
				System.err.println("Árvore Binária Vazia");

			if (type.equals("preOrdered"))
				this.preOrdered(this.raiz);
		}

		public void preOrdered(Node node) {
			if (node != null) {
				System.out.print(node.getElement() + " ");
				this.preOrdered(node.getLeft());
				this.preOrdered(node.getRight());
			}
		}

		public void print2DUtil(Node raiz, int space) {
			if (raiz == null)
				return;

			space += COUNT;

			print2DUtil(raiz.getRight(), space);

			System.out.print("\n");
			for (int i = COUNT; i < space; i++)
				System.out.print(" ");
			System.out.print(raiz.getElement() + "\n");

			print2DUtil(raiz.getLeft(), space);
		}

		public void print2D(Node root) {
			this.print2DUtil(root, 0);
		}

		public boolean isElementAtTree(int element, Node node) {
			if (node != null) {
				if (element == node.getElement())
					return true;
				else {
					if (element < node.getElement()) {
						if (this.isElementAtTree(element, node.getLeft()))
							return true;
					} else {
						if (isElementAtTree(element, node.getRight()))
							return true;
					}
				}
			}
			return false;
		}

		public Node removeNode(int element, Node node) {
			Node nodeAux;

			if (node != null) {
				if (node.getElement() == element) {
					if (node.getLeft() == node.getRight())
						return null;
					else {
						if (node.getLeft() == null)
							return node.getRight();
						else {
							if (node.getRight() == null)
								return node.getLeft();
							else {
								nodeAux = node.getRight();
								while (nodeAux.getLeft() != null)
									nodeAux = nodeAux.getLeft();
								nodeAux.setLeft(node.getLeft());
								return node.getRight();
							}
						}
					}
				}
				if (node.getElement() < element)
					node.setRight(removeNode(element, node.getRight()));
				else
					node.setLeft(removeNode(element, node.getLeft()));
			}
			return node;
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
		while (option != 'd') {
			System.out.println("a) Inserir um nó na árvore");
			System.out.println("b) Apresentar Árvore");
			System.out.println("c) Remover nó da árvore");
			System.out.println("d) Sair");

			option = input.next().charAt(0);

			switch (option) {
			case 'a':
				System.out.println("Digite um número para inserir na árvore");

				int num = input.nextInt();

				tree.insert(num);
				break;
			case 'b':
				tree.print2D(tree.raiz);
				System.out.println("");
				break;
			case 'c':
				System.out.println("Digite o elemento que deseja remover");
				
				int num1 = input.nextInt();
				Node removed = tree.removeNode(num1, tree.raiz);
				
				if(removed != null) System.out.println("Elemento: " + num1 + " removido");
				
				break;
			case 'd':
				System.exit(0);
				break;
			default:
				System.err.println("Ação não configurada");
				break;
			}

		}

	}
}
