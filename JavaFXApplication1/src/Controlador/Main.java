/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Modelo.*;
import Vista.Vista;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author acer
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException, IOException, LineUnavailableException {
        // TODO Auto-generated method stub
        Vista vista = new Vista();
        //Imagen imagen = new Imagen();
        //Video video = new Video();
        Audio audio = new Audio("null");
        int opcion = 0;
        boolean primeraVezAudio = true;
        URL myURL = new URL("http://example.com/");
        while (opcion != 5) {

            opcion = vista.menu();
            String rutaAudio;
            String rutaVideo;
            int opcionAudio = 0;

            switch (opcion) {
                case 1:
                    final String NOMBRE_ARCHIVO = "video2.mp4";
                    File archivo = new File(NOMBRE_ARCHIVO);

                    Media video = new Media(archivo.toURI().toString());
                    MediaPlayer reproductor = new MediaPlayer(video);
                    MediaView ventana = new MediaView(reproductor);
                    

                    Group escenario = new Group();
                    escenario.getChildren().add(ventana);
                    Scene escena = new Scene(escenario, 500, 400);
                    stage.setScene(escena);
                    stage.setTitle("Reproducción Vídeo");
                    stage.show();
                    reproductor.setAutoPlay(true);
                    
                    break;
                case 2:
                    rutaAudio = vista.pedirRutaAudio();
                    audio.setFileName(rutaAudio);
                    audio.cargar();
                    break;
                case 3:

                case 4:
                    if (audio.fileName.equals("null")) {
                        System.out.println("Cargue un archivo primero");
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

                            e.printStackTrace();
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

}
