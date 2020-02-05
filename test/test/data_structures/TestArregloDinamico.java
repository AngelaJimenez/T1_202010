package test.data_structures;

import model.data_structures.IArregloDinamico;
import model.data_structures.ListaOrdenada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private IArregloDinamico<String> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ListaOrdenada<String>();
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	@Test
	public void testArregloDinamico() {
		// TODO
		assertNotNull(arreglo);
		assertEquals(0, arreglo.darLongitud());
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
	}

}
