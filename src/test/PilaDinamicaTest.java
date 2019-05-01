package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.PilaDinamica;

public class PilaDinamicaTest {

	PilaDinamica<Integer> p;

	@Before
	public void before() {
		this.p = new PilaDinamica<Integer>();
	}

	@Test
	public void isEmptyTest() throws Exception {
		Assert.assertEquals(true, this.p.isEmpty());
	}

	@Test
	public void pushTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		int valorActual =  this.p.peek();
		Assert.assertEquals(false, this.p.isEmpty());
		Assert.assertEquals(valor, valorActual);
		Assert.assertEquals(false, this.p.isEmpty());
	}

	@Test
	public void peekTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		int valorActual =  this.p.peek();
		Assert.assertEquals(false, this.p.isEmpty());
		Assert.assertEquals(valor, valorActual);
		Assert.assertEquals(false, this.p.isEmpty());
	}

	@Test
	public void pullTest() throws Exception {
		int valor = new Integer(100);
		this.p.push(valor);
		Assert.assertEquals(false, this.p.isEmpty());
		int valorActual = this.p.pop();
		Assert.assertEquals(valor, valorActual);
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
}
