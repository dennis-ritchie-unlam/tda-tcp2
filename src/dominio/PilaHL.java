package dominio;

public class PilaHL<T> extends Lista<T> implements Pila<T> {

	@Override
	public void push(T elemento) throws Exception {
		Nodo<T> nue = new Nodo<T>(elemento, primero);
		primero = nue;
	}

	@Override
	public T pop() {
		if (primero == null)
			return null;
		
		T elemento = primero.getElemento();
		Nodo<T> nuevoTope = primero.getSiguiente();
		primero = null;
		primero = nuevoTope;
		
		return elemento;
	}

	@Override
	public T peek() {
		if (primero == null)
			return null;
		
		return primero.getElemento();
	}
}
