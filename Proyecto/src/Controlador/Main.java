/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javafx.application.Application;
import javafx.stage.Stage;
import Modelo.*;
import Vista.Vista;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author acer
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException, IOException, LineUnavailableException, Exception {
        // TODO Auto-generated method stub
        Vista vista = new Vista();
        //Imagen imagen = new Imagen();
        Video video = new Video();
        video.setRuta("null");
        Audio audio = new Audio("null");
        int opcion = 0;
        boolean primeraVezAudio = true;

        while (opcion != 5) {
            opcion = vista.menu();
            String rutaAudio;
            String rutaVideo;
            int opcionAudio;

            switch (opcion) {
                case 1:
                    rutaVideo = vista.pedirRutaVideo();
                    video.setRuta(rutaVideo);
                    video.start(stage);
                    
                    break;
                case 2:
                    rutaAudio = vista.pedirRutaAudio();
                    audio.setFileName(rutaAudio);
                    audio.cargar();
                    break;
                case 3:
                    if(video.ruta.equals("null")){
                        vista.cargarArchivo();
                    }else{
                        video.reproductor.play();
                        video.reproducir(stage);
                    }
                    
                    break;
                case 4:
                    if (audio.fileName.equals("null")) {
                        vista.cargarArchivo();
                    } else {

                        try {
                            if (primeraVezAudio == true) {
                                audio.clip.open(audio.audioIn);
                                primeraVezAudio = false;
                            }

                            do {
                                opcionAudio = vista.comandosAudio();
                                switch (opcionAudio) {
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

                            } while (opcionAudio != 4);

                        } catch (LineUnavailableException e) {
                        }
                    }

                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
    
    public void menu(){
        
    }

}
