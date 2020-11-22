package Modelo;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	
	public String fileName;
    private ArrayList<Integer> datos;
    public Clip clip;
    public AudioInputStream audioIn;
    public long clipTime;
    
    
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
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(this.fileName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			this.audioIn = AudioSystem.getAudioInputStream(new File(this.fileName).getAbsoluteFile());
			this.clip = AudioSystem.getClip();

		}
		catch (Exception e) {
            System.out.println("Error -- " + e.toString());
            this.fileName = "null";
        }	
	}
	
	public void reproducir() {
		clip.setMicrosecondPosition(0);
		clip.start();	
	}
	
	public void pausar() {
		this.clipTime = this.clip.getMicrosecondPosition();
		clip.stop();
	}

	public void reanudar() {
		clip.start();
	}
}