package dominio;

public class ColaCL<T> extends Lista<T> implements Cola<T> {

	Lista<T> cola = new Lista<T>();

	@Override
	public void offer(T elemento) {
		Nodo<T> nue = new Nodo<T>(elemento, null);
		if (cola.primero == null)
			cola.primero = nue;
		else
			cola.ultimo.setSiguiente(nue);
		cola.ultimo = nue;
	}

	@Override
	public T poll() {
		if (cola.primero == null)
			return null;

		T aux = cola.primero.getElemento();
		Nodo<T> nue = cola.primero.getSiguiente();
		cola.primero = null;
		cola.primero = nue;

		return aux;
	}

	@Override
	public T peek() {
		if (cola.primero == null)
			return null;
		
		return cola.primero.getElemento();
	}

	@Override
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	@Override
	public void empty() {
		cola.empty();
	}

}