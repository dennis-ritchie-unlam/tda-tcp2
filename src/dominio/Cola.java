package dominio;

public interface Cola {

	public void offer(Object dato);
	
	public Object poll();
	
	public Object peek();
	
	public boolean isEmpty();
	
	public void empty();
}
