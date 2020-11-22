package Modelo;

import java.io.File;

import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage;  
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Video extends Application{
	
	public String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
        //Initialising path of the media file, replace this with your file path   
        String path = "video.mp4";  
          
        //Instantiating Media class  
        Media media = new Media(new File(path).toURI().toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);  
          
        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);  
          
        //setting group and scene   
        Group root = new Group();  
        root.getChildren().add(mediaView);  
        Scene scene = new Scene(root,500,400);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Playing video");  
        primaryStage.show();  
    }

	/*public void start(Stage stage) throws Exception {
	public void start(Stage stage) throws Exception {
		System.out.println(this.ruta);
        final String NOMBRE_ARCHIVO = "video.mp4";
        File archivo = new File(this.ruta);
        
        Media video = new Media(archivo.toURI().toString());
        MediaPlayer reproductor = new MediaPlayer(video);
        MediaView ventana = new MediaView(reproductor);
        reproductor.setAutoPlay(true);
        
        Group escenario = new Group();
        escenario.getChildren().add(ventana);
        Scene escena = new Scene(escenario, 500, 400);
        stage.setScene(escena);
        stage.setTitle("Reproducción Vídeo");
        stage.show();
    }*/
	
	public void main(String[] args) throws Exception {
        launch(args);
    }
}
	