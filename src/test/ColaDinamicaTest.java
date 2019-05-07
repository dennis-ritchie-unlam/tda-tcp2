package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.ColaDinamica;
import dominio.StackOverflowException;

public class ColaDinamicaTest<T> {
	ColaDinamica<Integer> cola;

	@Before
	public void setUp() throws Exception {
		cola = new ColaDinamica<Integer>();
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
	public void manejoDeCola() throws StackOverflowException {
		
		Assert.assertEquals(1, (int)cola.poll());
		Assert.assertEquals(2, (int)cola.poll());
		Assert.assertEquals(3, (int)cola.poll());
		
		Assert.assertEquals(4, (int)cola.peek());
		
		cola.offer(6);
		cola.offer(7);
		cola.offer(8);
		
		Assert.assertEquals(4, (int)cola.poll());
		Assert.assertEquals(5, (int)cola.poll());
		Assert.assertEquals(6, (int)cola.poll());
		Assert.assertEquals(7, (int)cola.poll());
		Assert.assertEquals(8, (int)cola.poll());
		
		Assert.assertEquals(true, cola.isEmpty());		
		Assert.assertEquals(null, cola.peek());
	}
	
	@Test
	public void tiempoUnMillonTest() throws StackOverflowException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			this.cola.offer(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.print(endTime - startTime);
		System.out.println(" ms");
	}
}
