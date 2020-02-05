package model.vo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Infraccion {
	private String objectId;
	private String fechaHora;
	private String medioDetec;
	private String claseVehi;
	private String tipoServi;
	private String infraccion;
	private String descInfrac;
	private Coordenada coordenada;
	private String localidad;
	
	public Infraccion() {
		// TODO Auto-generated constructor stub
	}

	public Infraccion(String objectId, String fechaHora, String claseVehi, String tipoServi, String infraccion,
			String descInfrac, Coordenada coordenada, String localidad) {
		super();
		this.objectId = objectId;
		this.fechaHora = fechaHora;
		this.claseVehi = claseVehi;
		this.tipoServi = tipoServi;
		this.infraccion = infraccion;
		this.descInfrac = descInfrac;
		this.coordenada = coordenada;
		this.localidad = localidad;
	}

	public Infraccion(JsonObject ob) {
		JsonObject obj = ob.getAsJsonObject("properties");
		this.objectId = obj.get("OBJECTID").getAsString();
		this.fechaHora = obj.get("FECHA_HORA").getAsString();
		this.medioDetec= obj.get("MEDIO_DETE").getAsString();
		this.claseVehi = obj.get("CLASE_VEHI").getAsString();
		this.tipoServi = obj.get("TIPO_SERVI").getAsString();
		this.infraccion = obj.get("INFRACCION").getAsString();
		this.descInfrac = obj.get("DES_INFRAC").getAsString();
		this.localidad = obj.get("LOCALIDAD").getAsString();
		JsonObject je = ob.getAsJsonObject("geometry");
		JsonArray ja = je.getAsJsonArray("coordinates");
		this.coordenada = new Coordenada(ja.get(0).getAsDouble(), ja.get(1).getAsDouble());
		//this.localidad = obj.get("OBJECTID").getAsString();
	}

	public String getObjectId() {
		return objectId;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public String getClaseVehi() {
		return claseVehi;
	}

	public String getTipoServi() {
		return tipoServi;
	}

	public String getInfraccion() {
		return infraccion;
	}

	public String getDescInfrac() {
		return descInfrac;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public String getLocalidad() {
		return this.localidad;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void setClaseVehi(String claseVehi) {
		this.claseVehi = claseVehi;
	}

	public void setTipoServi(String tipoServi) {
		this.tipoServi = tipoServi;
	}

	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}

	public void setDescInfrac(String descInfrac) {
		this.descInfrac = descInfrac;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
String info = "OBJECTID: " + objectId
			+ "\n Fecha  y Hora: " + fechaHora
			+ "\n Clase de Behiculo: "+ claseVehi
			+ "\n Tipo servicio: " + tipoServi
			+"\n Infraccion: "+ infraccion
			+"\n Descripcion infraccion: "+ descInfrac
			+"\n Localidad"+localidad
			+"\n Coordenadas: "+coordenada.getLatitude()+","+coordenada.getLongitude();

// TODO Auto-generated method stub
		return info;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return ((arg0 instanceof Infraccion) && ((Infraccion)arg0).objectId.equals(this.objectId)); 
	}


}
