package dominio;

public class PilaEstática implements Pila {
	private int primero = 0;
	private int tope = -1;
	private Object[] dato;
	private int cant;
	
	public PilaEstática(int cant) {
		this.cant = cant;
		this.dato = new Object[cant];
	}
	
	@Override
	public void push(Object dato) throws Exception {
		if(this.primero >= cant) 
			throw new Exception();
		
		this.dato[this.primero++] = dato;
		this.tope++;
	}

	@Override
	public Object pop() throws Exception {
		if(tope == -1 && primero == 0)
			throw new Exception();
		tope--;
		
		return this.dato[this.primero--];
	}

	@Override
	public Object peek() throws Exception {
		if(tope == -1 && primero == 0)
			throw new Exception();
		
		return this.dato[this.tope];
	}

	@Override
	public boolean isEmpty() {
		return (tope == -1 && primero == 0);
	}

	@Override
	public void empty() {
		for(int i = this.primero;i <= this.primero;i++)
			this.dato[i] = null;
	}

}
