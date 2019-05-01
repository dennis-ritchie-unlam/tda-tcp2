package dominio;

public class Lista<T> {

	protected Nodo<T> primero;
	protected Nodo<T> ultimo;
	protected int cant;

	public void pushBack(T elemento) throws StackOverflowException {
		if (null == primero)
			primero = ultimo = new Nodo<T>(elemento, null);
		else {
			Nodo<T> nuevo = new Nodo<T>(elemento, null);
			ultimo.setSiguiente(nuevo);
			ultimo = ultimo.getSiguiente();
		}
		cant++;

	}

	public T popBack() {
		if (primero == null)
			return null;

		T elemento = ultimo.getElemento();
		if (primero == ultimo)
			primero = ultimo = null;
		else {
			Nodo<T> nodoActual = primero;
			while (nodoActual.getSiguiente() != ultimo)
				nodoActual = nodoActual.getSiguiente();
			ultimo = nodoActual;
			nodoActual.setSiguiente(null);
		}
		cant--;

		return elemento;
	}

	public void pushFront(T elemento) {
		if (null == primero)
			primero = ultimo = new Nodo<T>(elemento, null);
		else
			primero = new Nodo<T>(elemento, primero);
		cant++;
	}

	public void remove(T elemento) throws EmptyListException, NotFoundException {
		Nodo<T> nodoActual = primero;
		Nodo<T> nodoAnterior = ultimo;

		if (primero == null)
			throw new EmptyListException();

		while (nodoActual != null && nodoActual.getElemento() != elemento) {
			nodoAnterior = nodoActual;
			nodoActual = nodoActual.getSiguiente();
		}

		if (nodoActual == null)
			throw new NotFoundException();

		if (primero == nodoActual)
			primero = nodoActual.getSiguiente();
		else if (ultimo == nodoActual) {
			ultimo = nodoAnterior;
			ultimo.setSiguiente(null);
		} else
			nodoAnterior.setSiguiente(nodoActual.getSiguiente());
		cant--;

	}

	public void reverse() {
		switch (cant) {
		case 0:
		case 1:
			break;
		case 2:
			ultimo.setSiguiente(primero);
			primero = ultimo;
			ultimo = primero.getSiguiente();
			ultimo.setSiguiente(null);
			break;
		default:
			Nodo<T> nodoActual = primero;
			Nodo<T> siguienteActual = primero.getSiguiente();
			Nodo<T> siguienteSiguienteActual = siguienteActual.getSiguiente();
			ultimo = primero;
			while (siguienteActual != null) {
				siguienteActual.setSiguiente(nodoActual);
				nodoActual = siguienteActual;
				siguienteActual = siguienteSiguienteActual;
				if (siguienteSiguienteActual != null)
					siguienteSiguienteActual = siguienteSiguienteActual.getSiguiente();
			}
			ultimo.setSiguiente(null);
			primero = nodoActual;
		}
	}

	public void insertAt(int posición, T elemento) throws NotFoundException {
		if (posición < 1 || posición > cant + 1)
			throw new NotFoundException("La posicion es invalida");

		int contador = 1;
		Nodo<T> nodoActual = primero;
		Nodo<T> nodoAnterior = null;
		while (nodoActual != null && contador != posición) {
			contador++;
			nodoAnterior = nodoActual;
			nodoActual = nodoActual.getSiguiente();
		}
		Nodo<T> nuevo = new Nodo<T>(elemento, nodoActual);
		if (contador == 1)
			primero = nuevo;
		else
			nodoAnterior.setSiguiente(nuevo);
		cant++;
	}

	public void eraseAt(int posicion) throws NotFoundException, EmptyListException {
		if (posicion < 1 || posicion > cant)
			throw new NotFoundException("La posicion es invalida");
		if (primero == null)
			throw new EmptyListException("No se puede eliminar de una lista vacia");
		Nodo<T> nodoActual = primero;
		if (posicion - 1 == 0) {
			primero = nodoActual.getSiguiente();
			cant--;
		} else {
			for (int i = 1; nodoActual != null && i < posicion - 1; i++)
				nodoActual = nodoActual.getSiguiente();
			Nodo<T> aux = nodoActual.getSiguiente().getSiguiente();
			nodoActual.setSiguiente(aux);
			cant--;
		}
	}

	public boolean isEmpty() {
		return primero == null;
	}

	public void empty() {
		Nodo<T> aux;
		while (primero.getSiguiente() != ultimo) {
			aux = primero.getSiguiente();
			primero = null;
			primero = aux;
		}

		primero = ultimo = null;
		cant = 0;
	}

	public T search(T elemento) throws EmptyListException, NotFoundException {
		if (primero == null)
			throw new EmptyListException();

		Nodo<T> nodoActual = primero;

		do {
			if (nodoActual.getElemento() == elemento)
				return nodoActual.getElemento();
		} while ((nodoActual = nodoActual.getSiguiente()) != null);

		throw new NotFoundException();
	}

	public T searchAt(int posicion) throws NotFoundException, EmptyListException {
		if (posicion < 1 || posicion > cant)
			throw new NotFoundException("La posicion es invalida");
		if (primero == null)
			throw new EmptyListException();
		
		Nodo<T> nodoActual = primero;
		while (posicion != 1) {
			nodoActual = nodoActual.getSiguiente();
			posicion--;
		}

		return nodoActual.getElemento();
	}

	public int size() {
		return cant;
	}
}
