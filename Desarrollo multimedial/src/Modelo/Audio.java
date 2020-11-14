package Modelo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {
	
	private String fileName;
    private ArrayList<Integer> datos;
    
    public Audio(String filename){
        this.fileName = filename;
        this.datos = new ArrayList<Integer>();
    }
    
	public ArrayList<Integer> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Integer> datos) {
		this.datos = datos;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void cargar() {
		System.out.println("Se metio audio");
		
		try {
			//File song = new File(fileName);
            InputStream file = getClass().getResourceAsStream("Crazy_Train.mp3");
            
         // Se obtiene un Clip de sonido
            //Clip sonido = AudioSystem.getClip();
            
            // Se carga con un fichero wav
            //sonido.open(AudioSystem.getAudioInputStream(new BufferedInputStream(file)));
            //sonido.start();
			
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		}
		catch (Exception e) {
            System.out.println("Error -- " + e.toString());
            this.fileName = "null";
        }	
	}
}




/*try
{
	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds" + System.getProperty("file.separator") + ruta).getAbsoluteFile());
	AudioFormat format = audioInputStream.getFormat();
	DataLine.Info info = new DataLine.Info(Clip.class, format);
	Clip sound = (Clip)AudioSystem.getLine(info);
	sound.open(audioInputStream);
	System.out.println("Se caego");
}
catch(Exception e)
{
	System.out.println("noooooo");
}*/
