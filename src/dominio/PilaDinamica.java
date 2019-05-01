package dominio;

public class PilaDinamica<T> implements Pila<T> {

	private Nodo<T> top = null;

	@Override
	public T pop() {
		if (this.top == null)
			return null;

		T elemento = top.getElemento();
		Nodo<T> aux = top.getSiguiente();
		top = null;
		top = aux;

		return elemento;
	}

	@Override
	public T peek() {
		return this.top.getElemento();
	}

	@Override
	public boolean isEmpty() {
		return this.top == null;
	}

	@Override
	public void empty() {
		while(top != null)
			top = top.getSiguiente();
	}

	@Override
	public void push(T elemento) throws Exception {
		this.top = new Nodo<T>(elemento, this.top);
	}
}
