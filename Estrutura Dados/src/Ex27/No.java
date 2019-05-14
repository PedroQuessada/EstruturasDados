package Ex27;

public class No {

	private int elemento;
	private No proximo;
	private No anterior;
	
	public No() {
		elemento = 0;
		proximo = null;
		anterior = null;
	}

	public No(int elemento, No proximo, No anterior) {
		this.elemento = elemento;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
	
	
}
