import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay implements KeyListener{
    private JFrame frame;
    private String userName;
    private Timer timer = new Timer(20, this::checkTime);
    private JTextField nameField;
    public GamePlay() {
        // Set up frame.
        frame = new JFrame("Tickets Please!");
        frame.setSize(1000, 700);
        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
       // frame.setResizable(false);
        // Set icon.
        ImageIcon icon = new ImageIcon("Tickets Please!/src/icon.png"); 
        frame.setIconImage(icon.getImage());
        //Set up title label

        
        frame.getContentPane().setBackground(new Color(191,231,233));

        // Display frame.
        frame.setVisible(true);
    }

   

    private void checkTime(ActionEvent evt){

    }

    public void keyPressed(KeyEvent e) {
       // System.out.println("Pressed: " + e.getKeyChar());
        //this.keyPressLabel.setText("Key pressed: " + e.getKeyChar());
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ' ':
                
                break;
     
        }
    }   
    }