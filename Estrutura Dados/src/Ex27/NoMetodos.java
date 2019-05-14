package Ex27;

public class NoMetodos {

	private No inicio;
	private No fim;
	private No ponteiro;
	private int tamanho;
	
	public NoMetodos() {
		inicio = null;
		fim = null;
		ponteiro = null;
		tamanho = 0;
	}
	
	public boolean inserirNoFinal(int elemento) {
		No novoNo = new No(elemento, null, null);
		if(isEmpty()) {
			inicio = novoNo;
			fim = novoNo;
			ponteiro = novoNo;
		}
		else {
			fim.setProximo(novoNo);
			novoNo.setAnterior(fim);
			fim = novoNo;
			ponteiro = inicio;
		}
		tamanho++;
		return true;
	}
	
	public int removerDoFinal() {
		int elemento = fim.getElemento();
		
		if(tamanho == 1) {
			inicio = null;
			fim = null;
			ponteiro = null;
			tamanho--;
			return elemento;
		}
		else {
			fim = fim.getProximo();
			fim.setProximo(null);
			ponteiro = inicio;
			tamanho--;
			return elemento;
		}
	}
	
	
	
	public boolean isEmpty() {
		if(tamanho == 0) return true;
		else return false;
	}
	
	public boolean primeiro() {
		if(ponteiro.getProximo() == null) return true;
		else return false;
	}
	
	public boolean ultimo() {
		if(ponteiro.getProximo() == null) return true;
		else return false;
	}
	
	public int apresentaAtual() {
		return ponteiro.getElemento();
	}
	
	public int apresentaProximo() {
		ponteiro = ponteiro.getProximo();
		return ponteiro.getElemento();
	}
	
	public int apresentaAnterior() {
		ponteiro = ponteiro.getAnterior();
		return ponteiro.getElemento();
	}
	
}
