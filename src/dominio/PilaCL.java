package dominio;

public class PilaCL<T> implements Pila<T> {

	Lista<T> pila = new Lista<T>();

	@Override
	public void push(T elemento) {
		Nodo<T> nue = new Nodo<T>(elemento, pila.primero);
		pila.primero = nue;
	}

	@Override
	public T pop() {
		if (pila.primero == null)
			return null;

		T elemento = pila.primero.getElemento();
		Nodo<T> nuevoTope = pila.primero.getSiguiente();
		pila.primero = null;
		pila.primero = nuevoTope;

		return elemento;
	}

	@Override
	public T peek() {
		if (pila.primero == null)
			return null;

		return pila.primero.getElemento();
	}

	@Override
	public boolean isEmpty() {
		return pila.isEmpty();
	}

	@Override
	public void empty() {
		pila.empty();
	}

}