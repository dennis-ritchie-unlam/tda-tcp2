package dominio;

public class PilaEstática<T> implements Pila {
	private int tope = -1;
	private Object[] dato;
	private int cant;

	public PilaEstática(int cant) {
		this.cant = cant;
		this.dato = new Object[cant];
	}

	@Override
	public void push(Object dato) throws Exception {
		if (tope >= cant)
			throw new Exception();

		this.dato[++tope] = dato;
	}

	@Override
	public Object pop() {
		if (tope == -1)
			return null;

		return this.dato[this.tope--];
	}

	@Override
	public Object peek() {
		if (tope == -1)
			return null;

		return this.dato[tope];
	}

	@Override
	public boolean isEmpty() {
		return tope == -1;
	}

	@Override
	public void empty() {
		for (int i = 0; i <= this.tope; i++)
			this.dato[i] = null;
	}

}
