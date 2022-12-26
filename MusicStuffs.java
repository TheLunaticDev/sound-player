//I don't know what to do...
//nothing's working :(

import javax.sound.sampled.*;
import java.io.*;

public class MusicStuffs{

    static AudioInputStream audio_stream;
    static Clip clip;

    public void playaudio(File audioFile){
        try{
            audio_stream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audio_stream);
        }catch(Exception e){

        }
        finally{
            clip.start();
        }
    }

    public void pauseaudio(File audioFile){
        try{
            audio_stream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audio_stream);
        }catch(Exception e){

        }
        finally{
            clip.stop();
        }
    }

    public void replayaudio(File audioFile){
        try{
            audio_stream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audio_stream);
        }catch(Exception e){

        }
        finally{
            clip.setMicrosecondPosition(0);
        }
    }

}