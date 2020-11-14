package Controlador;

import Modelo.*;
import Vista.Vista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Imagen imagen = new Imagen();
		Video video = new Video();
		Audio audio = new Audio("null");
		int opcion = 0;
		
		while(opcion != 5) {
			
			opcion = vista.menu();
			String ruta;
			
			switch(opcion) {
				case 1:
					ruta = vista.pedirRuta();
					video.cargar(ruta);
					break;
				case 2:
					ruta = vista.pedirRuta();
					audio.setFileName(ruta);
					audio.cargar();
					break;
				default:
					break;
			}
			
		}
		
		

	}

}
