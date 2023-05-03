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

public class GamePlay implements KeyListener {
    private JFrame frame;
    private String userName;
    private Timer timer = new Timer(50, this::checkTime);
    private JTextArea inputField;
    private JLabel dialogLabel;
    private JLabel gameTimer;
    private JLabel moneyLabel;

    private JButton toggleTextArea;

    private JButton yesButton;
    private JButton noButton;
    private JButton gougeButton;

    private JButton repairButton1;
    private JButton repairButton2;
    private JButton repairButton3;
    private JButton repairButton4;



    private int dialogScrollNum = 1;
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

    private boolean areaToggled=true; 
    private int tikCounter = 0;
    private int secondCounter = 0;
    private int minuteCounter =0;
    private boolean timeStart = false;
    private boolean rideBroken1 = false;
    private boolean rideBroken2 = false;
    private boolean rideBroken3 = false;
    private boolean rideBroken4 = false;

    private String currentDialog;
    private int money = -2000000;

    public GamePlay(String name) {
        // set up dialog
        userName = name;
        dialog1 = "Ona: Welcome to your first day " + userName + "! to get to the next dialog box press \"enter\".";
        dialog2 = "Ona: Your job is to make sure the rides work, give good customer service and if you can, try to limit the causualties to three a day.";
        dialog3 = userName + ": Three?";
        dialog4 = "Ona: Ya we're trying to get that average down.";
        dialog5 = userName + ": Huh, alright. Anyway what will my wage look like?";
        dialog6 = "Ona: It's a competitave wage.";
        dialog7 = userName + ": Competitave to what?";
        dialog8 = "Ona: To your fellow employees.";
        dialog9 = userName + ": I am the only employee.";
        dialog10 = "Ona: Exactly. It's about time I come clean about something.";
        dialog11 = userName + ": Your business is in shambels, it's obvious.";
        dialog12 = "Ona: Ya we're in severe debt.";
        dialog13 = userName + ": Figured, how much?";
        dialog14 = "Ona: 2 million dollars ... and 42 pending lawsuits. I got about 10 minutes to pay the debt.";
        dialog15 = userName + ": How are you getting out of that?";
        dialog16 = "Ona: By using you of course, you're going to have to cut some corners for me.";
        dialog17 = userName + ": What corners?";
        dialog18 = "Ona: Safty, ethics and the law. Do what you can to get as much money as possible.";
        dialog19 = "Ona: When customers come in, charge an extra fee, when rides are unsafe, run them anyway. Evaluate risk and gouge.";
        dialog20 = "Ona: Use the text area to enter customer names when they come in, their information will appear, you can deny or accept their entrance";
        dialog21 = "Ona: Use the buttons on the side to repair rides when they turn red, it will still run unrepaired but have an increase chance of a minor fatal oopsie";
        dialog22 = "Ona: Also use the toggle terminal button to use or stop using the text field. Thats about it! Have fun I'll be hiding from the law!";
        dialog23 = userName + ": I need to learn how to start saying no.";

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

        // set up dialog text line
        dialogLabel = new JLabel("");
        dialogLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialogLabel.setVerticalAlignment(SwingConstants.CENTER);
        Dimension size = dialogLabel.getPreferredSize();
        dialogLabel.setBounds(300, 100, size.width, size.height);
        dialogLabel.setForeground(Color.black);
        dialogLabel.setBackground(new Color(255, 255, 255));
        dialogLabel.setOpaque(true);
        dialogLabel.setBorder(BorderFactory.createEtchedBorder());
        dialogLabel.setVisible(true);


        //set up money label
        moneyLabel = new JLabel("");
        moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moneyLabel.setVerticalAlignment(SwingConstants.CENTER);
        moneyLabel.setVisible(false);
        Dimension moneyLabelSize = moneyLabel.getPreferredSize();
        moneyLabel.setBounds(300, 100, moneyLabelSize.width, moneyLabelSize.height);
        moneyLabel.setForeground(Color.black);
        moneyLabel.setBackground(new Color(255, 255, 255));
        moneyLabel.setOpaque(true);
        moneyLabel.setBorder(BorderFactory.createEtchedBorder());
        //set up "yes" button
        yesButton = new JButton("Accept");
        yesButton.addActionListener(this::acceptOffer);
        yesButton.setFocusable(false);
        yesButton.setContentAreaFilled(false);
        yesButton.setVisible(false);

        //set up "no" button
        noButton = new JButton("Deny");
        noButton.addActionListener(this::denyOffer);
        noButton.setFocusable(false);
        noButton.setContentAreaFilled(false);
        noButton.setVisible(false);

        //set up "gouge" button
        gougeButton = new JButton("Gouge em!");
        gougeButton.addActionListener(this::gouge);
        gougeButton.setFocusable(false);
        gougeButton.setContentAreaFilled(false);
        gougeButton.setVisible(false);

        //set up repair button 1
        repairButton1 = new JButton("Carousel ($10000)");
        repairButton1.addActionListener(this::repair1);
        repairButton1.setFocusable(false);
        repairButton1.setBackground(Color.green);
        repairButton1.setVisible(false);
        //set up repair button 2
        repairButton2 = new JButton("Whirly Gig ($12000)");
        repairButton2.addActionListener(this::repair2);
        repairButton2.setFocusable(false);
        repairButton2.setBackground(Color.green);
        repairButton2.setVisible(false);
        //set up repair button 3
        repairButton3 = new JButton("Improper Dropper ($15000)");
        repairButton3.addActionListener(this::repair3);
        repairButton3.setFocusable(false);
        repairButton3.setBackground(Color.green);
        repairButton3.setVisible(false);
        //set up repair button 4
        repairButton4 = new JButton("Destined Death ($20000)");
        repairButton4.addActionListener(this::repair4);
        repairButton4.setFocusable(false);
        repairButton4.setBackground(Color.green);
        repairButton4.setVisible(false);


        // set up game timer
        gameTimer = new JLabel("");
        gameTimer.setHorizontalAlignment(SwingConstants.CENTER);
        gameTimer.setVerticalAlignment(SwingConstants.CENTER);
        Dimension timerSize = gameTimer.getPreferredSize();
        gameTimer.setBounds(300, 100, timerSize.width, timerSize.height);
        gameTimer.setForeground(Color.black);
        gameTimer.setBackground(new Color(255, 255, 255));
        gameTimer.setOpaque(true);
        gameTimer.setBorder(BorderFactory.createEtchedBorder());
        gameTimer.setVisible(false);
        // set up input text area
        inputField = new JTextArea("");
        inputField.setPreferredSize(new Dimension(440, 200));
        inputField.setBounds(50, 50, 150, 0);
        inputField.setVisible(false);
        inputField.setBackground(Color.black);
        inputField.setFocusable(false);
        //set up a button that toggles the text area on and off
        toggleTextArea = new JButton("Toggle terminal");
        toggleTextArea.addActionListener(this::toggleTyping);
        toggleTextArea.setFocusable(false);
        toggleTextArea.setBackground(Color.blue);
        toggleTextArea.setForeground(Color.white);
        toggleTextArea.setVisible(false);
        // add to frame
        frame.add(inputField);
        frame.add(gameTimer);
        frame.add(dialogLabel);
        frame.add(yesButton);
        frame.add(noButton);
        frame.add(gougeButton);
        frame.add(repairButton1);
        frame.add(repairButton2);
        frame.add(repairButton3);
        frame.add(repairButton4);
        frame.add(toggleTextArea);
        frame.add(moneyLabel);
        frame.getContentPane().setBackground(new Color(191, 231, 233));
        frame.addKeyListener(this);

        // GUI Layout
        layout.putConstraint(SpringLayout.WEST, moneyLabel, 800, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.WEST, dialogLabel, 50, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.WEST, inputField, 400, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, inputField, 300, SpringLayout.SOUTH, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, dialogLabel, 50, SpringLayout.SOUTH, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, yesButton, 50, SpringLayout.SOUTH, inputField);
        layout.putConstraint(SpringLayout.WEST, yesButton, 0, SpringLayout.WEST, inputField);
        layout.putConstraint(SpringLayout.WEST, noButton, 100, SpringLayout.WEST, yesButton);
        layout.putConstraint(SpringLayout.SOUTH, noButton, 0, SpringLayout.SOUTH, yesButton);
        layout.putConstraint(SpringLayout.WEST, gougeButton, 100, SpringLayout.WEST, noButton);
        layout.putConstraint(SpringLayout.SOUTH, gougeButton, 0, SpringLayout.SOUTH, yesButton);
        layout.putConstraint(SpringLayout.SOUTH, repairButton1, 150, SpringLayout.SOUTH, gameTimer);
        layout.putConstraint(SpringLayout.WEST, repairButton1, 10, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, repairButton2, 0, SpringLayout.SOUTH, repairButton1);
        layout.putConstraint(SpringLayout.WEST, repairButton2, 150, SpringLayout.WEST, repairButton1);
        layout.putConstraint(SpringLayout.SOUTH, repairButton3, 50, SpringLayout.SOUTH, repairButton1);
        layout.putConstraint(SpringLayout.WEST, repairButton3, 0, SpringLayout.WEST, repairButton1);
        layout.putConstraint(SpringLayout.SOUTH, repairButton4, 50, SpringLayout.SOUTH, repairButton1);
        layout.putConstraint(SpringLayout.WEST, repairButton4, 200, SpringLayout.WEST, repairButton1);
        layout.putConstraint(SpringLayout.SOUTH, toggleTextArea, -100, SpringLayout.SOUTH, inputField);
        layout.putConstraint(SpringLayout.WEST, toggleTextArea, 450, SpringLayout.WEST, inputField);

        // Display frame.
        frame.setVisible(true);

        //
    }

    private void checkTime(ActionEvent evt) {
         
        if (timeStart) {
            tikCounter++;
            if (tikCounter % 16 == 0) { // account for lag :\, should be 20 in a perfect world
                    int randBreak = (int)(Math.random()*300);
                    if(randBreak==1){
                        rideBroken1=true;
                        repairButton1.setBackground(Color.red);
                    }
                    else if (randBreak==2){
                        rideBroken2=true;
                        repairButton2.setBackground(Color.red);
                    }
                    else if (randBreak==3){
                        rideBroken3=true;
                        repairButton3.setBackground(Color.red);
                    }
                    else if (randBreak==4){
                        rideBroken4=true;
                        repairButton4.setBackground(Color.red);
                    }
                secondCounter++;
            }
            if (secondCounter>=60){
                secondCounter-=60; 
                minuteCounter++;
            }
        }
        dialogLabel.setText(currentDialog);

        if (minuteCounter<1){
        gameTimer.setText("Time: " + secondCounter + "s");
        }
        else{
        gameTimer.setText("Time: " + minuteCounter+ "m:" +secondCounter + "s");    
        }

        if (minuteCounter==10){
            LoseScreen app = new LoseScreen();
            frame.dispose();
            timer.stop(); // real important or the gui will keep being opened
        }

        moneyLabel.setText("Debt: "+money+" dollars");
        switch (dialogScrollNum) {
            case 1:
                currentDialog = dialog1;
                break;
            case 2:
                currentDialog = dialog2;
                break;
            case 3:
                currentDialog = dialog3;
                break;
            case 4:
                currentDialog = dialog4;
                break;
            case 5:
                currentDialog = dialog5;
                break;
            case 6:
                currentDialog = dialog6;
                break;
            case 7:
                currentDialog = dialog7;
                break;
            case 8:
                currentDialog = dialog8;
                break;
            case 9:
                currentDialog = dialog9;
                break;
            case 10:
                currentDialog = dialog10;
                break;
            case 11:
                currentDialog = dialog11;
                break;
            case 12:
                currentDialog = dialog12;
                break;
            case 13:
                currentDialog = dialog13;
                break;
            case 14:
                currentDialog = dialog14;
                moneyLabel.setVisible(true);
                break;
            case 15:
                currentDialog = dialog15;
                break;
            case 16:
                currentDialog = dialog16;
                break;
            case 17:
                currentDialog = dialog17;
                break;
            case 18:
                currentDialog = dialog18;
                break;
            case 19:
                currentDialog = dialog19;
                gougeButton.setVisible(true);
                break;
            case 20:
                currentDialog = dialog20;
                inputField.setVisible(true);
                yesButton.setVisible(true);
                noButton.setVisible(true);
                toggleTextArea.setVisible(true);
                break;
            case 21:
                currentDialog = dialog21;
                repairButton1.setVisible(true);
                repairButton2.setVisible(true);
                repairButton3.setVisible(true);
                repairButton4.setVisible(true);
                break;
            case 22:
                currentDialog = dialog22;
                break;
            case 23:
                currentDialog = dialog23;
                timeStart=true;
                gameTimer.setVisible(true);
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
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            dialogScrollNum++;
        }
    }

    private void acceptOffer(ActionEvent e){

    }

    private void toggleTyping (ActionEvent e){
        if (areaToggled){
            inputField.setBackground(Color.white);
            inputField.setFocusable(true);
            frame.setFocusable(false);
            inputField.requestFocus();
            areaToggled=false;
        } else{
            inputField.setBackground(Color.black);
            frame.setFocusable(true);
            inputField.setFocusable(false);
            frame.requestFocus();
            areaToggled=true;
        }
    }

    private void denyOffer(ActionEvent e){

    }

    private void gouge(ActionEvent e){

    }

    private void repair1(ActionEvent e){
        if (rideBroken1){
        repairButton1.setBackground(Color.green);
        money-=10000;
        rideBroken1=false;
        }
    }
    private void repair2(ActionEvent e){
        if (rideBroken2){
        repairButton2.setBackground(Color.green);
        money-=12000;
        rideBroken2=false;
        }
    }
    private void repair3(ActionEvent e){
        if (rideBroken3){
        repairButton3.setBackground(Color.green);
        money-=15000;
        rideBroken3=false;
        }
    }
    private void repair4(ActionEvent e){
        if (rideBroken4){
        repairButton4.setBackground(Color.green);
        money-=20000;
        rideBroken4=false;
        }
    }


}