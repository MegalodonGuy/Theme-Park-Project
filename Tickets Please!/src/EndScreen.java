
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


public class EndScreen {
    private JFrame frame;
    private JLabel endLabel;

    /**
     * false if you want player to lose true for win
     * @param win
     */
    public EndScreen(boolean win){
        if (!win){
        frame = new JFrame("Lose Screen");
        frame.setLayout(new FlowLayout());
        

        endLabel= new JLabel("You go home and try to forget about what just happened"); 
        Dimension labelSize = endLabel.getPreferredSize();
        endLabel.setFont(new Font("Papyrus", Font.PLAIN, 45));
        endLabel.setBounds(300, 100, labelSize.width, labelSize.height);
        endLabel.setForeground(Color.yellow);
        endLabel.setOpaque(true);
        endLabel.setBackground(new Color(112,10,12));

        frame.getContentPane().setBackground(new Color(112,10,12));
        frame.add(endLabel);
        frame.pack(); 
        frame.setVisible(true);
        } else{
            frame = new JFrame("Win Screen");
        frame.setLayout(new FlowLayout());
        

        endLabel= new JLabel("You just bailed a criminal out by commiting more crime, you win?"); 
        Dimension labelSize = endLabel.getPreferredSize();
        endLabel.setFont(new Font("Times New Roman", Font.PLAIN, 45));
        endLabel.setBounds(300, 100, labelSize.width, labelSize.height);
        endLabel.setForeground(new Color(10, 166, 44));
        endLabel.setOpaque(true);
        endLabel.setBackground(new Color(112,10,12));

        frame.getContentPane().setBackground(new Color(17, 3, 54));
        frame.add(endLabel);
        frame.pack(); 
        frame.setVisible(true);
        }
    }
}
