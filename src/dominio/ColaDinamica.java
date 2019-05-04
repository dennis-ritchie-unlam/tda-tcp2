package dominio;

public class ColaDinamica<T> implements Cola<T> {
	private Nodo<T> primero;
	private Nodo<T> ultimo;

	@Override
	public void offer(T dato) throws StackOverflowException {
		Nodo<T> nuevo = new Nodo<T>(dato, null);
		if(primero == null) {
			primero = nuevo;
		} else {
			ultimo.setSiguiente(nuevo);
		}
		ultimo = nuevo;
	}

	@Override
	public T poll() {
		if(primero == null) 
			return null;
		Nodo<T> elemento = primero;
		primero = primero.getSiguiente();
		
		return elemento.getElemento();
	}

	@Override
	public T peek() {
		return primero != null ? primero.getElemento() : null;
	}

	@Override
	public boolean isEmpty() {
		return primero == null;
	}

	@Override
	public void empty() {
		while(primero != null)
			primero = primero.getSiguiente();
		ultimo = null;
	}

}
