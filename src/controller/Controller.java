package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:	
				view.printMessage("--------- \nLa lista se agrego:");
				modelo = new Modelo(); 
				
				view.printMessage("El primero comparendo es: \n"+modelo.darPrimera().toString());
				view.printMessage("\n El ultimo comparendo es: \n"+modelo.darUltimo().toString());
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 2:
				view.printMessage("--------- \nDar objectid: ");
				dato = lector.next(); 
				view.printMessage("El dato es:" + modelo.buscarConID(dato));
				view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
