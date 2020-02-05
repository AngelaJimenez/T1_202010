package model.data_structures;

public class NodoLista <T> {

	private T elemento ;
	private NodoLista<T> siguiente;

	public NodoLista(T dato)
	{
		elemento = dato;
		siguiente = null;	
	}
	public NodoLista<T> darSiguiente()
	{
		return siguiente;
	}
	public T darElemento()
	{
		return elemento;
	}

	public void cambiarSiguiente(NodoLista<T> nodo)
	{
		siguiente = nodo;	
	}
}
