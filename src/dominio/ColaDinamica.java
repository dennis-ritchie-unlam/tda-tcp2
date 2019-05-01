package dominio;

public class ColaDinamica<T> implements Cola<T> {
	private Nodo<T> primerElemento;
	private Nodo<T> ultimoElemento;

	@Override
	public void offer(T dato) throws StackOverflowException {
		Nodo<T> nuevo = new Nodo<T>(dato, null);
		if(primerElemento == null) {
			primerElemento = nuevo;
		} else {
			ultimoElemento.setSiguiente(nuevo);
		}
		ultimoElemento = nuevo;
	}

	@Override
	public T poll() {
		if(primerElemento == null) return null;
		Nodo<T> elemento = primerElemento;
		primerElemento = primerElemento.getSiguiente();
		return elemento.getElemento();
	}

	@Override
	public T peek() {
		return primerElemento != null ? primerElemento.getElemento() : null;
	}

	@Override
	public boolean isEmpty() {
		return primerElemento == null;
	}

	@Override
	public void empty() {
		while(primerElemento != null)
			primerElemento = primerElemento.getSiguiente();
		ultimoElemento = null;
	}

}
