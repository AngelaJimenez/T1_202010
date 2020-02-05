package model.data_structures;

import java.util.Comparator;

public class ListaOrdenada <T> implements IArregloDinamico<T> {
	private int longitud;
	private NodoLista<T> primero;
	public ListaOrdenada()
	{
		primero = null;
		longitud = 0;
	}
	@Override
	public int darLongitud() {
		// TODO Auto-generated method stub
		return longitud;
	}
	@Override
	public boolean agregar(T dato) {
		NodoLista<T> agregante = new NodoLista<T>(dato);
		if(primero == null)
		{
			primero = agregante;
		}
		else
		{
			NodoLista<T> agregable = primero;
			while(agregable.darSiguiente() != null) {
				agregable = agregable.darSiguiente();
			}
			agregable.cambiarSiguiente(agregante);
		}
		longitud ++;
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean agregar(T dato, Comparator<T> comparador) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean agregarXToString(T dato) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T buscar(T dato) {
		NodoLista<T> pos = primero;
		if(pos.darElemento().equals(dato)) return pos.darElemento();
		while(pos.darSiguiente() != null) {
			pos = pos.darSiguiente();
			if(pos.darElemento().equals(dato)) {
				return pos.darElemento();
			}
		}
		return null;
	}
	@Override
	public T eliminar(T dato) {
		NodoLista<T> anterior = primero;
		T rta = null;
		if(anterior == primero)
		{
			rta = primero.darElemento();
			primero = anterior.darSiguiente();
		}
		else
		{
			for (int i = 0; i<longitud && rta==null; i++)
			{
				if(anterior.darSiguiente().darElemento().equals(dato))
				{	
					rta = (T) anterior.darSiguiente().darElemento();
					anterior.cambiarSiguiente(anterior.darSiguiente().darSiguiente());
				}
				anterior = anterior.darSiguiente();
			}
		}
		// TODO Auto-generated method stub
		return rta;
	}
	@Override
	public Object[] darArreglo() {
		NodoLista<T> pos = primero;
		Object[] rta = new Object[longitud];
		for(int i = 0; i<longitud && rta==null; i++)
		{
			rta[i]= pos.darElemento();
			pos = pos.darSiguiente();
		}
		// TODO Auto-generated method stub
		return rta;
	}
	
	public T get(int pos)
	{
		if(pos>=longitud) throw new IndexOutOfBoundsException();
		if (pos == 0) {
			return primero.darElemento();
		}
		NodoLista<T> actual = primero;
		for (int i=1; i<longitud; i++)
		{
			actual = actual.darSiguiente();
		}
		return actual.darElemento();
	}
}
