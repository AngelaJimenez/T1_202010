package model.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.data_structures.IArregloDinamico;
import model.data_structures.ListaOrdenada;
import model.vo.Infraccion;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<Infraccion> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ListaOrdenada<Infraccion>();
		cargarDatos(datos, "./data/comparendos_dei_2018.geojson");

	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darLongitud();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Infraccion dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Infraccion buscar(Infraccion dato)
	{
		return datos.buscar(dato);
	}
	
	public Infraccion darPrimera()
	{
		return datos.get(0);
	}
	public Infraccion darUltimo()
	{
		return datos.get(darTamano() - 1);
	}
	public String buscarConID(String dato)
	{
		String rta = "";
		Infraccion infraccion = new Infraccion();
		infraccion.setObjectId(dato);
		infraccion = datos.buscar(infraccion);
		if (infraccion == null)
		{
		rta = "No existe informacion del comparendo";	
		}
		else
		{
			rta = "OBJECTID: " + infraccion.getObjectId()
				+ "\n Fecha  y Hora: " + infraccion.getFechaHora()
				+"\n Infraccion: "+ infraccion.getInfraccion()
				+"\n Clase de Behiculo: "+ infraccion.getClaseVehi()
				+"\n Tipo servicio: " + infraccion.getTipoServi()
				+"\n Localidad"+infraccion.getLocalidad();
		}
		return rta;
	}
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Infraccion eliminar(Infraccion dato)
	{
		return datos.eliminar(dato);
	}

	public void cargarDatos(IArregloDinamico<Infraccion> infracciones, String pRutaArchivo) {
		try {
			JsonParser parser = new JsonParser();
			JsonObject object = parser.parse(new FileReader(new File(pRutaArchivo))).getAsJsonObject();
			JsonArray features = object.get("features").getAsJsonArray();
			for(JsonElement jo : features) {
				JsonObject elem = jo.getAsJsonObject();
				Infraccion x = new Infraccion(elem);
				datos.agregar(x);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
