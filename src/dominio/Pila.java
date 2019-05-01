package dominio;

public interface Pila {
	public void push(Object dato) throws Exception;

	public Object pop() throws Exception;

	public Object peek() throws Exception;

	public boolean isEmpty();
	
	public void empty();
}
