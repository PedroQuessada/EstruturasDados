package Ex28;

import Ex27.No;

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
	
	
	
	public boolean inserirNoAtual(int elemento) {		
		No proximo = ponteiro.getProximo(); 
		No novo = new No(elemento, proximo, ponteiro);
		proximo.setAnterior(novo);
		ponteiro.setProximo(novo);
		ponteiro = novo;
		tamanho++;
		return true;
	}
	
	public int removerDoFinal() {
			
		if(ponteiro.getAnterior() == null) {
			No proximo = ponteiro.getProximo();
			proximo.setAnterior(null);
			tamanho--;
			ponteiro = proximo;
			return ponteiro.getElemento();
		}
		else if(ponteiro.getProximo() == null) {
			No anterior = ponteiro.getAnterior();
			anterior.setProximo(null);
			tamanho--;
			ponteiro = anterior;
			return ponteiro.getElemento();
		}else {
			No anterior = ponteiro.getAnterior();
			No proximo = ponteiro.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			int elemento = ponteiro.getElemento();
			ponteiro = anterior;
			tamanho--;
			return elemento;
		}
		
	}
	
	
	
	public boolean isEmpty() {
		if(tamanho == 0) return true;
		else return false;
	}
	
	public boolean primeiro() {
		if(ponteiro.getAnterior() == null) return true;
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
