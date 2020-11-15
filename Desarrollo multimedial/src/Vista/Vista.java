package Vista;

import java.util.Scanner;

import java.awt.BorderLayout;

import java.awt.Component;

import java.io.*;

import javax.media.CannotRealizeException;

import javax.media.Manager;

import javax.media.NoPlayerException;

import javax.media.Player;

import javax.swing.JPanel;

import java.net.URL;

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


