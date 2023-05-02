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
    private String userName="";
    private Timer timer = new Timer(20, this::checkTime);
    private JTextField inputField;
    private JLabel dialogLabel;
    private int dialogScrollNum=1; 
    private String dialog1 = "Welcome to your first day";


    private String currentDialog; 
    public GamePlay() {
        timer.start(); 
        // Set up frame.
        frame = new JFrame("Tickets Please!");
        frame.setSize(1000, 700);
        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        // Set icon.
        ImageIcon icon = new ImageIcon("Tickets Please!/src/icon.png"); 
        frame.setIconImage(icon.getImage());

        //set up dialog text line
        dialogLabel = new JLabel("");
        dialogLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialogLabel.setVerticalAlignment(SwingConstants.CENTER);
        Dimension size = dialogLabel.getPreferredSize();
        dialogLabel.setBounds(300, 100, size.width, size.height);
        dialogLabel.setForeground(Color.black);
        dialogLabel.setBackground(new Color(255,255,255));
        dialogLabel.setOpaque(true);
        dialogLabel.setBorder(BorderFactory.createEtchedBorder());
        dialogLabel.setVisible(true);
        //set up input text field
        inputField = new JTextField("");
        inputField.setPreferredSize(new Dimension(140,20));
        inputField.setBounds(50, 50, 150, 0);
        
        //add to frame
        //frame.add(inputField);
        frame.add(dialogLabel);
        frame.getContentPane().setBackground(new Color(191,231,233));
        frame.addKeyListener(this);

        layout.putConstraint(SpringLayout.WEST, dialogLabel,500,SpringLayout.WEST,inputField);

        // Display frame.
        frame.setVisible(true);
    }

   

    private void checkTime(ActionEvent evt){
        dialogLabel.setText(currentDialog);
        switch (dialogScrollNum){
            case 1:
            currentDialog= dialog1;
            break;
            case 2:
            currentDialog=(""+dialogScrollNum);
            break;
        }
    }

    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            dialogScrollNum++;
        }
    }   

    public void getName(String name){
        userName=name; 
    }
    }