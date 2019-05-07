package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.ColaEstatica;
import dominio.StackOverflowException;

public class ColaEstaticaTest {
	private ColaEstatica<Integer> cola;
	
	@Before
	public void setUp() throws Exception {
		cola = new ColaEstatica<Integer>(5);
		cola.offer(1);
		cola.offer(2);
		cola.offer(3);
		cola.offer(4);
		cola.offer(5);
	}
	
	@Test
	public void vaciadoDeColaTest() {
		Assert.assertEquals(false, cola.isEmpty());
		cola.empty();
		Assert.assertEquals(true, cola.isEmpty());
	}

	@Test
	public void manejoDeColaTest() throws StackOverflowException {
		//cola.offer(0); //StackOverflow exception
		
		Assert.assertEquals(1, cola.poll());
		Assert.assertEquals(2, cola.poll());
		Assert.assertEquals(3, cola.poll());
		
		Assert.assertEquals(4, cola.peek());
		
		cola.offer(6);
		cola.offer(7);
		cola.offer(8);
		
		//cola.offer(9); //StackOverflow exception
		
		Assert.assertEquals(4, cola.poll());
		Assert.assertEquals(5, cola.poll());
		Assert.assertEquals(6, cola.poll());
		Assert.assertEquals(7, cola.poll());
		Assert.assertEquals(8, cola.poll());
		
		Assert.assertEquals(true, cola.isEmpty());		
		Assert.assertEquals(null, cola.peek());
	}

	@Test
	public void tiempoUnMillonTest() throws StackOverflowException {
		cola = new ColaEstatica<Integer>(1000000);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			cola.offer(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.print(endTime - startTime);
		System.out.println(" ms");
	}
}
