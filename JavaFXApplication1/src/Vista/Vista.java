package Vista;

import java.util.Scanner;

public class Vista {
	
	public int menu() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("1.Cargar video.");
		System.out.println("2.Cargar audio.");
		System.out.println("3.Comandos video.");
		System.out.println("4.Comandos audio.");
		System.out.println("5.Salir.");
		int eleccion = myObj.nextInt();
		//myObj.close();
		return eleccion;	
	}
	
	public String pedirRutaAudio() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("¡Indique la ruta donde se encuentra el archivo! (Se aceptan formatos AIFC, AIFF, AU, SND y WAVE) ");
		String ruta = myObj.next();
		//myObj.close();
		return ruta;
	}
	
	public String pedirRutaVideo() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("¡Indique la ruta donde se encuentra el archivo!");
		String ruta = myObj.next();
		//myObj.close();
		return ruta;
	}
	
	public int comandosAudio() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("1.Reproducir.");
		System.out.println("2.Pausa.");
		System.out.println("3.Reanudar.");
		System.out.println("4.Salir.");
		int comando = myObj.nextInt();
		//myObj.close();
		return comando;
	}

}
