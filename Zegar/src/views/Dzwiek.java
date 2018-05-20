package views;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dzwiek 
{
	
	public static void odtworz() 
	{
		
		File dzwonek = new File("bell.wav");
		
		try 
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(dzwonek));
			clip.start();
		}
		catch(Exception e)
		{
			
		}
	}
}
