
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


public class LoseScreen {
    private JFrame frame;
    private JLabel loseLabel;
    public LoseScreen(){
        frame = new JFrame("Lose Screen");
        frame.setLayout(new FlowLayout());
        

        loseLabel= new JLabel("You go home and try to forget about what just happend"); 
        Dimension labelSize = loseLabel.getPreferredSize();
        loseLabel.setFont(new Font("Papyrus", Font.PLAIN, 45));
        loseLabel.setBounds(300, 100, labelSize.width, labelSize.height);
        loseLabel.setForeground(Color.yellow);
        loseLabel.setOpaque(true);
        loseLabel.setBackground(new Color(112,10,12));

        frame.getContentPane().setBackground(new Color(112,10,12));
        frame.add(loseLabel);
        frame.pack(); 
        frame.setVisible(true);
    }
}
