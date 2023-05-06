import javax.sound.sampled.*;
import java.io.File;

public class Audio {
    Clip clip;
    AudioInputStream sound;
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
}