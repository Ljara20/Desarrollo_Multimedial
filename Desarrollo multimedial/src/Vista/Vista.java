package Vista;

import java.util.Scanner;

public class Vista {
	
	public int menu() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("1.Cargar video.");
		System.out.println("2.Cargar audio.");
		System.out.println("5.Salir.");
		int eleccion = myObj.nextInt();
		return eleccion;	
	}
	
	public String pedirRuta() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("¡Indique la ruta donde se encuentra el archivo!");
		String ruta = myObj.next();
		return ruta;
	}
}

