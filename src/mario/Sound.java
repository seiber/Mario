package mario;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound
{
	 
	
		    private Clip clip;
	
		     
	
		
	
		    public static Sound sound1 = new Sound("Res/textures/sound1.wav");
	
		   // public static Sound sound2 = new Sound("/sound2.wav");
	
		   // public static Sound sound3 = new Sound("/sound3.wav");
	
		     

		    public Sound (String fileName) {
	
		        try {
	
		            AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
	
		            clip = AudioSystem.getClip();

		            clip.open(ais);

		        } catch (Exception e) {

		        	e.printStackTrace();

		        }
	
		    }
	
		 
	
		    public void play() {
	
		        try {
	
		            if (clip != null) {
	
		                new Thread() {
	
		                    public void run() {
	
		                        synchronized (clip) {
	
		                            clip.stop();
	
		                            clip.setFramePosition(0);
	
		                            clip.start();
	
		                        }
	
		                    }
	
		                }.start();
	
		            }
	
		        } catch (Exception e) {
	
		            e.printStackTrace();
	
		        }
	
		    }
	
		     
	
		    public void stop(){
	
		        if(clip == null) return;
	
		        clip.stop();
	
		    }
	
		     
	
		    public void loop() {
	
		        try {
	
		            if (clip != null) {
	
		                new Thread() {

		                    public void run() {
	
		                        synchronized (clip) {
	
		                            clip.stop();
	
		                            clip.setFramePosition(0);
	
		                            clip.loop(Clip.LOOP_CONTINUOUSLY);
	
		                        }
	
		                    }
	
		                }.start();
	
		            }
	
		        } catch (Exception e) {
	
		            e.printStackTrace();
	
		        }
	
		    }
	
		     
	
		    public boolean isActive(){

		        return clip.isActive();
	
		    }

}
