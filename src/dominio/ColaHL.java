package dominio;

public class ColaHL<T> extends Lista<T> implements Cola<T> {
	
	@Override
	public void offer(T elemento) {
		Nodo<T> nue = new Nodo<T>(elemento, null);
		if (primero == null)
			primero = nue;
		else
			ultimo.setSiguiente(nue);
		ultimo = nue;
	}

	@Override
	public T poll() {
		if (primero == null)
			return null;
		T aux = primero.getElemento();
		Nodo<T> nue = primero.getSiguiente();
		primero = null;
		primero = nue;
		
		return aux;
	}

	@Override
	public T peek() {
		if (primero == null)
			return null;
		
		return primero.getElemento();
	}

	
}
