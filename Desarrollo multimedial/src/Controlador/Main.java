package Controlador;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.LineUnavailableException;

import Modelo.*;
import Vista.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		//Imagen imagen = new Imagen();
		Video video = new Video();
		Audio audio = new Audio("null");
		int opcion = 0;
		boolean primeraVezAudio = true;
		URL myURL = new URL("http://example.com/");
		while(opcion != 5) {
			
			opcion = vista.menu();
			String rutaAudio;
			String rutaVideo;
			int opcionAudio = 0;
			
			
			switch(opcion) {
				case 1:
					rutaVideo = vista.pedirRutaVideo();
					video.setRuta(rutaVideo);
					video.main(args);
					break;
				case 2:
					rutaAudio = vista.pedirRutaAudio();
					audio.setFileName(rutaAudio);
					audio.cargar();
					break;
				case 3:
				
					
				case 4:
					if(audio.fileName.equals("null")) {
						System.out.println("Cargue un archivo primero");
					}
					else {
						
						try {
							if(primeraVezAudio == true) {
								audio.clip.open(audio.audioIn);
								primeraVezAudio = false;
							}
							
							
							do {
								opcionAudio = vista.comandosAudio();
								switch(opcionAudio) {
									case 1:
										audio.reproducir();
										break;
									case 2:
										audio.pausar();
										break;
									case 3:
										audio.reanudar();
										break;
									case 4:
										audio.pausar();
										audio.clip.setMicrosecondPosition(0);
										break;
								}
								
							}while(opcionAudio != 4);
						
						}catch (LineUnavailableException e) {
							
							e.printStackTrace();
						}	
					}
					
					break;
				default:
					break;
			}		
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
