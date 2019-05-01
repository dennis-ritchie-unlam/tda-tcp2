package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.PilaEstática;
import dominio.StackOverflowException;

public class PilaEstáticaTest {

	PilaEstática<Integer> p;

	@Before
	public void before() {
		this.p = new PilaEstática<Integer>(100);
	}

	@Test
	public void isEmptyTest() throws Exception {
		Assert.assertEquals(true, this.p.isEmpty());
	}

	@Test
	public void pushTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		Assert.assertEquals(false, this.p.isEmpty());
		Assert.assertEquals(valor, this.p.peek());
		Assert.assertEquals(false, this.p.isEmpty());
	}

	@Test
	public void peekTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		Assert.assertEquals(false, this.p.isEmpty());
		Assert.assertEquals(valor, this.p.peek());
		Assert.assertEquals(false, this.p.isEmpty());
	}

	@Test
	public void pullTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		Assert.assertEquals(false, this.p.isEmpty());
		Assert.assertEquals(valor, this.p.pop());
		Assert.assertEquals(true, this.p.isEmpty());
	}

	@Test
	public void emptyTest() throws Exception {
		int valor100 = new Integer(100);
		this.p.push(valor100);
		int valor2 = new Integer(2);
		this.p.push(valor2);
		Assert.assertEquals(false, this.p.isEmpty());
		this.p.empty();
		Assert.assertEquals(true, this.p.isEmpty());
	}

	@Test(expected = StackOverflowException.class)
	public void stackOverflowExceptionTest() throws Exception {
		for (int i = 0; i < 102; i++) {
			int valor = new Integer(i);
			this.p.push(valor);
		}
	}
}
