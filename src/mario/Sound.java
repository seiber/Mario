package mario;

import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * @author www.codejava.net
 *
 */


public class Sound implements Runnable
{
     public static Clip audioClip;
     String audioFilePath = "Res/Textures/Music/ikson.wav";
     public static boolean playCompleted;
    
     
     
  
    void play(String audioFilePath) 
    {
    	
        File audioFile = new File(audioFilePath);
    
       
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

 
            audioClip = (Clip) AudioSystem.getLine(info);
            
      
            audioClip.open(audioStream);
            
            	
            audioClip.start();
            
            
        
       
           while (!playCompleted) {
                // wait for the playback completes
        	    System.out.println("song length:"+audioClip.getMicrosecondLength() +" "+ "current position in song: " +audioClip.getMicrosecondPosition());
        	   //System.out.println("song playing");
        	   if(audioClip.getMicrosecondLength()== audioClip.getMicrosecondPosition())
               {
            	   playCompleted=true;
            	   break;
               }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
           }
           
           //System.out.println("song length:"+audioClip.getMicrosecondLength() +" "+ "current position in song: " +audioClip.getMicrosecondPosition());
           
           //if song length duration >= current duration
          
             
           
           	if(playCompleted=true)
           	{
           		
           		System.out.println("play completed" + Thread.currentThread());
           		
           	 audioClip.close();
             
           	}
           
           
    
            
          
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
    }


    public void update(LineEvent event) 
    {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }

	@Override
	public void run() 
	{
		play(audioFilePath);
		
	
	}
		
	}

