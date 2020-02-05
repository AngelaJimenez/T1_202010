package model.data_structures;

import java.util.Comparator;

public interface IArregloDinamico<T> {

	public int darLongitud( );

	public boolean agregar(T dato );
	
	public boolean agregar (T dato, Comparator<T> comparador);

	public boolean agregarXToString(T dato);		

	public T buscar(T dato);
	
	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	public T eliminar( T dato );

	public T get(int pos);
	public Object[] darArreglo();
}
