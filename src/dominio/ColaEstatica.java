package dominio;

public class ColaEstatica implements Cola {
	private int primerElemento = 0;
	private int ultimoElemento = -1;
	private int tamanyo;
	private Object[] dato;
	
	public ColaEstatica(int cant) {
		this.dato = new Object[cant];
		this.tamanyo = cant;
	}
	
	@Override
	public void offer(Object dato) throws StackOverflowException {
		if(ultimoElemento + primerElemento == tamanyo || ultimoElemento - primerElemento == tamanyo - 1) 
			throw new StackOverflowException("No hay mas lugar en la cola"); //si la cola esta llena
		
		if(ultimoElemento == tamanyo - 1) ultimoElemento = -1; //manejo como cola circular
		this.dato[++ultimoElemento] = dato;
	}

	@Override
	public Object poll() {
		Object obj = null;
		
		if(primerElemento == ultimoElemento) { //caso de que quede un elemento en la cola, hay que regresarla a su estado original
			obj = dato[primerElemento];
			primerElemento = 0;
			ultimoElemento = -1;
		} else if(ultimoElemento != -1) { //si la cola no esta vacia
			obj = this.dato[primerElemento++];
			if(primerElemento == tamanyo) primerElemento = 0;
		}
				
		return  obj;
	}

	@Override
	public Object peek() {
		return ultimoElemento != -1 ? this.dato[primerElemento] : null;
	}

	@Override
	public boolean isEmpty() {
		return ultimoElemento == -1;
	}

	@Override
	public void empty() {
		primerElemento = 0;
		ultimoElemento = -1;
	}

}
