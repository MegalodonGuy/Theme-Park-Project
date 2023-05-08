import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * class for audio, set a wav audio file as the clip and uses that clip to use the audio
 */
public class Audio {
    Clip clip;
    AudioInputStream sound;

    /**
     * Set relative path of wav audio file as string
     * @param soundFileName
     */
    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            
        }
    }
    public void play() {
        clip.start();
    }

    public void stop() {
        try {
            sound.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.close();
        clip.stop();
    }

}