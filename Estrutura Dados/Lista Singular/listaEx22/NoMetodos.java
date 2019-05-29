package listaEx22;

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
	
	
	
	public boolean isEmpty() {
		if(tamanho == 0) return true;
		else return false;
	}
	
}
