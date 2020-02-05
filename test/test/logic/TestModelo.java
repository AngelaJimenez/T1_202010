package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;
import model.vo.Infraccion;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo();
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(new Infraccion());
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TOD
		setUp2();
		assertEquals(100, modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		Infraccion in = new Infraccion();
		in.setObjectId("Id1");
		modelo.agregar(in);
		assertEquals(1, modelo.darTamano());
	}

	@Test
	public void testBuscar() {
		Infraccion in = new Infraccion();
		in.setObjectId("Id1");
		modelo.agregar(in);
		assertNotNull(modelo.buscar(in));
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		return;
	}

}
