package listaEx23;

public class NoMetodos {

	private No inicio;
	private No fim;
	private int tamanho;
	
	public NoMetodos() {
		inicio = null;
		fim = null;
		tamanho = 0;
	}
	
	public boolean inserirNoFinal(int elemento) {
		
		No novoNo = new No(elemento, null);
		
		if(tamanho == 0) {
			inicio = novoNo;
			fim = novoNo;
		}else {
			fim.setProximo(novoNo);
			fim = novoNo;
		}
		tamanho++;
		return true;
	}
	
	public int removerDoFinal() {
		
		if(isEmpty()) return -1;
		
		int elemento = fim.getElemento();
		
		if(tamanho == 1) {
			inicio = null;
			fim = null;
			tamanho--;
			return elemento;
		}
		else {
			No noAuxiliar = new No();
			noAuxiliar = inicio;
			
			while(noAuxiliar.getProximo() != fim) noAuxiliar = noAuxiliar.getProximo();
			
			fim = noAuxiliar;
			noAuxiliar.setProximo(null);
			tamanho--;
			return elemento;
		}
	}
	
	public void mostrarTodos() {
		if(isEmpty()) System.out.println("A lista esta vazia");
		if(inicio == fim) System.out.println(fim.getElemento());
		else {
			No noAuxiliar = inicio;
			while(noAuxiliar != null) {
				System.out.println("O elemento tem o valor de " + noAuxiliar.getElemento());
				noAuxiliar = noAuxiliar.getProximo();
			}
		}
		
	}
	
	
	public boolean isEmpty() {
		if(tamanho == 0) return true;
		else return false;
	}
	
}
