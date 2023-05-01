import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TicketsPlease implements KeyListener{
    private JFrame frame;
    private JButton button;
    private JLabel label;

    private JLabel keyPressLabel = new JLabel("Key pressed: ");
    private Timer timer = new Timer(20, this::checkTime);
    public TicketsPlease() {
        // Set up frame.
        frame = new JFrame("My GUI App");
        frame.setSize(550, 700);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setResizable(false);
        // Set icon.
        ImageIcon icon = new ImageIcon("Tickets Please!/src/icon.png"); // Image needs to be in project folder.
        frame.setIconImage(icon.getImage());
        // Set up label.
        label = new JLabel("Hi!");
        Dimension size = label.getPreferredSize();
        label.setBounds(300, 100, size.width, size.height);
        label.setForeground(Color.white);
        label.setBackground(new Color(80,130,175));
        label.setOpaque(true);
        //label.setBorder(BorderFactory.createEtchedBorder());
        //label.setIcon(icon);

        
        // Set up button.
        button = new JButton("I am a button");
        button.addActionListener(this::handleButton);
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        
    
        // Add components to frame.

        frame.add(label);
        frame.add(button);
        frame.addKeyListener(this);
        //frame.add(keyPressLabel);
        

        // Resize frame to fit components.
        // frame.pack();

        frame.getContentPane().setBackground(new Color(191,231,233));

        // Display frame.
        frame.setVisible(true);
    }

    private void handleButton(ActionEvent event) {
   
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
                this.label.setText("You pressed space");
                break;
     
        }
    }   
    }