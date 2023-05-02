import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;
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
    private Timer timer = new Timer(50, this::checkTime);
    private JTextArea inputField;
    private JLabel dialogLabel;
    private JLabel gameTimer;
    private int dialogScrollNum=1; 
    private String dialog1;
    private String dialog2;
    private String dialog3;
    private String dialog4;
    private String dialog5;
    private String dialog6;
    private String dialog7;
    private String dialog8;
    private String dialog9;
    private String dialog10;
    private String dialog11;
    private String dialog12;
    private String dialog13;
    private String dialog14;
    private String dialog15;
    private String dialog16;
    private String dialog17;
    private String dialog18;
    private String dialog19;
    private String dialog20;
    private String dialog21;
    private String dialog22;
    private String dialog23;
  

    private int tikCounter=0;
    private int secondCounter=0;

    private String currentDialog; 
    public GamePlay(String name) {
        //set up dialog
        userName=name;
        dialog1="Ona: Welcome to your first day "+userName+"! to get to the next dialog box press \"enter\".";
        dialog2="Ona: Your job is to make sure the rides work, give good customer service and if you can, try to limit the causualties to three a day.";
        dialog3=userName+": Three?";
        dialog4="Ona: Ya we're trying to get that average down.";
        dialog5=userName+": Huh, alright. Anyway what will my wage look like?";
        dialog6="Ona: It's a competitave wage.";
        dialog7=userName+": Competitave to what?";
        dialog8="Ona: To your fellow employees.";
        dialog9=userName+": I am the only employee.";
        dialog10="Ona: Exactly. It's about time I come clean about something.";
        dialog11=userName+": About what?";
        dialog12="Ona: We are in severe debt.";
        dialog13=userName+": Figured, how much?";
        dialog14="Ona: 2 million dollars ... and 42 pending lawsuits. I got about 10 minutes to pay the debt.";
        dialog15=userName+": How are you getting out of that?";
        dialog16 ="Ona: By using you of course, you're going to have to cut some corners for me.";
        dialog17=userName+": What corners?";
        dialog18 ="Ona: Safty, ethics and the law. Do what you can to get as much money as possible.";
        dialog19 ="Ona: When customers come in, charge an extra fee, when rides are unsafe, run them anyway. Evaluate risk and gouge.";
        dialog20 ="Ona: Use the text area to enter customer names when they come in, their information will appear, you can deny or accept their entrance";
        dialog21 ="Ona: Use the buttons on the side to repair rides when they turn red, it will still run unrepaired but have an increase chance of a minor fatal oopsie";
        dialog22 ="Ona: Thats about it! Have fun I'll be hiding from the law!";
        dialog23=userName+": good lord";


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

        //set up game timer
        gameTimer = new JLabel("");
        gameTimer.setHorizontalAlignment(SwingConstants.CENTER);
        gameTimer.setVerticalAlignment(SwingConstants.CENTER);
        Dimension timerSize = dialogLabel.getPreferredSize();
        gameTimer.setBounds(300, 100, timerSize.width, timerSize.height);
        gameTimer.setForeground(Color.black);
        gameTimer.setBackground(new Color(255,255,255));
        gameTimer.setOpaque(true);
        gameTimer.setBorder(BorderFactory.createEtchedBorder());
        gameTimer.setVisible(true);
        //set up input text area
        inputField = new JTextArea("");
        inputField.setPreferredSize(new Dimension(440,200));
        inputField.setBounds(50, 50, 150, 0);
        
        //add to frame
        frame.add(inputField);
        frame.add(gameTimer);
        frame.add(dialogLabel);
        frame.getContentPane().setBackground(new Color(191,231,233));
        frame.addKeyListener(this);

        //GUI Layout
        layout.putConstraint(SpringLayout.WEST, dialogLabel,50,SpringLayout.WEST,gameTimer);
        layout.putConstraint(SpringLayout.WEST, inputField,300,SpringLayout.WEST,gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, inputField,300,SpringLayout.SOUTH,gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, dialogLabel,50,SpringLayout.SOUTH,gameTimer);
        // Display frame.
        frame.setVisible(true);
    }

   

    private void checkTime(ActionEvent evt){
        frame.setFocusable(true);
        frame.requestFocus();
        tikCounter++;
        if (tikCounter%16==0){ // account for lag :\, should be 20 in a perfect world
            secondCounter++;
        }
        dialogLabel.setText(currentDialog);
        gameTimer.setText("Time: "+ secondCounter+ "s");
        switch (dialogScrollNum){
            case 1:
            currentDialog= dialog1;
            break;
            case 2:
            currentDialog=dialog2;
            break;
            case 3:
            currentDialog=dialog3;
            break;
            case 4:
            currentDialog=dialog4;
            break;
            case 5:
            currentDialog=dialog5;
            break;
            case 6:
            currentDialog=dialog6;
            break;
            case 7:
            currentDialog=dialog7;
            break;
            case 8:
            currentDialog=dialog8;
            break;
            case 9:
            currentDialog=dialog9;
            break;
            case 10:
            currentDialog=dialog10;
            break;
            case 11:
            currentDialog=dialog11;
            break;
            case 12:
            currentDialog=dialog12;
            break;
            case 13:
            currentDialog=dialog13;
            break;
            case 14:
            currentDialog=dialog14;
            break;
            case 15:
            currentDialog=dialog15;
            break;
            case 16:
            currentDialog=dialog16;
            break;
            case 17:
            currentDialog=dialog17;
            break;
            case 18:
            currentDialog=dialog18;
            break;
            case 19:
            currentDialog=dialog19;
            break;
            case 20:
            currentDialog=dialog20;
            break;
            case 21:
            currentDialog=dialog21;
            break;
            case 22:
            currentDialog=dialog22;
            break;
            case 23:
            currentDialog=dialog23;
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
        if (e.getKeyChar()==KeyEvent.VK_ENTER){
            dialogScrollNum++;
        }
    }   

    
    }