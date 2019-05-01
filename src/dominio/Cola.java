package dominio;

public interface Cola<T> {

	public void offer(T dato) throws StackOverflowException;
	
	public T poll();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void empty();
}
