/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class Video extends Application {

    public String ruta;
    public Media video;
    public MediaPlayer reproductor;
    public MediaView ventana;   
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void start(Stage stage) throws Exception {
        File archivo = new File(this.ruta);
        this.video = new Media(archivo.toURI().toString());
        this.reproductor = new MediaPlayer(video);
        this.ventana = new MediaView(reproductor);
        //this.reproductor.play();
    }
    
    public void reproducir(Stage stage) throws Exception {
        Group escenario = new Group();
        escenario.getChildren().add(ventana);
        Scene escena = new Scene(escenario, 500, 400);
        stage.setScene(escena);
        stage.setTitle("Reproducción Vídeo");
        stage.show();
        
        
        //To change body of generated methods, choose Tools | Templates.
    }

}
