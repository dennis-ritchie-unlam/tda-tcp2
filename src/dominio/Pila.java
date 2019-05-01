package dominio;

public interface Pila<T> {
	public void push(T elemento) throws Exception;

	public T pop();

	public T peek() throws Exception;

	public boolean isEmpty();

	public void empty();
}
