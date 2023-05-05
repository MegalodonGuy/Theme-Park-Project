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

/**
 * JFrame where the main game will take place, does all gameplay gui elements, gameplay variables and uses Customer class when creating its random infinite gameplay loop
 */
public class GamePlay implements KeyListener {
    private JFrame frame;
    private String userName;
    private Timer timer = new Timer(50, this::checkTime);
    private JTextField inputField;
    private JLabel dialogLabel;
    private JLabel gameTimer;
    private JLabel moneyLabel;
    private JLabel deathLabel;
    private JButton toggleTextField;
    private JButton checkInfo;

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

    private boolean fieldToggled = true;
    private int tikCounter = 0;
    private int secondCounter = 0;
    private int minuteCounter = 0;
    private boolean timeStart = false;
    private boolean rideBroken1 = false;
    private boolean rideBroken2 = false;
    private boolean rideBroken3 = false;
    private boolean rideBroken4 = false;
    private boolean startDialogOver = false;
    private boolean createNewCustomer = false;
    private String currentDialog;
    private int money = -1000000;
    private int deaths = 0;
    private boolean currentOfferChose = false;
    private int customersInPark = 0;
    private double safteyFactor = 15000; // goes up when theme park is less safe, used to vary probability of death, higher is better
    // current customer info
    private String currentFirstName;
    private String currentLastName;
    private String currentIDNum;
    private int currentAge;
    private int currentMoneyCharged;
    private String currentLie;
    // 100% real customer info
    private String realFirstName;
    private String realLastName;
    private String realIDNum;
    private int realAge;
    private int realMoneyCharged;

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
        dialog14 = "Ona: 1 million dollars ... and 42 pending lawsuits. I got about 10 minutes to pay the debt.";
        dialog15 = userName + ": How are you getting out of that?";
        dialog16 = "Ona: By using you of course, you're going to have to cut some corners for me.";
        dialog17 = userName + ": What corners?";
        dialog18 = "Ona: Safty, ethics and the law. Do what you can to get as much money as possible.";
        dialog19 = "Ona: When customers come in, charge an extra fee, when rides are unsafe, run them anyway. Evaluate risk and price gouge.";
        dialog20 = "Ona: Use the text field to enter a customers full name or ID to make sure their ticket matches. You can deny or accept their entrance";
        dialog21 = "Ona: Use the buttons on the side to repair rides when they turn red, it will still run unrepaired but have an increase chance of a minor fatal oopsie";
        dialog22 = "Ona: Also use the toggle terminal button to use or stop using the text field, don't have it on when accepting tickets, its rude. Thats it, Have fun!";
        dialog23 = userName + ": I need to learn how to start saying no. Welp here comes my first customer...";
        // initiate customer
        Liar customer = new Liar();

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

        // set up money label
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
        // set up money label
        deathLabel = new JLabel("");
        deathLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deathLabel.setVerticalAlignment(SwingConstants.CENTER);
        deathLabel.setVisible(false);
        Dimension deathLabelSize = deathLabel.getPreferredSize();
        deathLabel.setBounds(300, 100, deathLabelSize.width, deathLabelSize.height);
        deathLabel.setForeground(Color.black);
        deathLabel.setBackground(new Color(255, 255, 255));
        deathLabel.setOpaque(true);
        deathLabel.setBorder(BorderFactory.createEtchedBorder());

        // set up "yes" button
        yesButton = new JButton("Accept");
        yesButton.addActionListener(this::acceptOffer);
        yesButton.setFocusable(false);
        yesButton.setContentAreaFilled(false);
        yesButton.setVisible(false);

        // set up "no" button
        noButton = new JButton("Deny");
        noButton.addActionListener(this::denyOffer);
        noButton.setFocusable(false);
        noButton.setContentAreaFilled(false);
        noButton.setVisible(false);

        // set up "gouge" button
        gougeButton = new JButton("Rip em off!");
        gougeButton.addActionListener(this::gouge);
        gougeButton.setFocusable(false);
        gougeButton.setContentAreaFilled(false);
        gougeButton.setVisible(false);

        // set up check info button
        checkInfo = new JButton("Check");
        checkInfo.addActionListener(this::getTrueInfo);
        checkInfo.setFocusable(false);
        checkInfo.setBackground(Color.green);
        checkInfo.setVisible(false);

        // set up repair button 1
        repairButton1 = new JButton("Carousel ($10000)");
        repairButton1.addActionListener(this::repair1);
        repairButton1.setFocusable(false);
        repairButton1.setBackground(Color.green);
        repairButton1.setVisible(false);
        // set up repair button 2
        repairButton2 = new JButton("Whirly Gig ($12000)");
        repairButton2.addActionListener(this::repair2);
        repairButton2.setFocusable(false);
        repairButton2.setBackground(Color.green);
        repairButton2.setVisible(false);
        // set up repair button 3
        repairButton3 = new JButton("Improper Dropper ($15000)");
        repairButton3.addActionListener(this::repair3);
        repairButton3.setFocusable(false);
        repairButton3.setBackground(Color.green);
        repairButton3.setVisible(false);
        // set up repair button 4
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
        // set up input text field
        inputField = new JTextField("");
        inputField.setPreferredSize(new Dimension(440, 200));
        inputField.setBounds(50, 50, 150, 0);
        inputField.setVisible(false);
        inputField.setBackground(Color.black);
        inputField.setFocusable(false);
        inputField.setHorizontalAlignment(SwingConstants.LEFT);

        // set up a button that toggles the text field on and off
        toggleTextField = new JButton("Toggle terminal");
        toggleTextField.addActionListener(this::toggleTyping);
        toggleTextField.setFocusable(false);
        toggleTextField.setBackground(Color.blue);
        toggleTextField.setForeground(Color.white);
        toggleTextField.setVisible(false);
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
        frame.add(toggleTextField);
        frame.add(moneyLabel);
        frame.add(deathLabel);
        frame.add(checkInfo);
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
        layout.putConstraint(SpringLayout.SOUTH, toggleTextField, -100, SpringLayout.SOUTH, inputField);
        layout.putConstraint(SpringLayout.WEST, toggleTextField, 450, SpringLayout.WEST, inputField);
        layout.putConstraint(SpringLayout.SOUTH, deathLabel, 20, SpringLayout.SOUTH, moneyLabel);
        layout.putConstraint(SpringLayout.WEST, deathLabel, 0, SpringLayout.WEST, moneyLabel);
        layout.putConstraint(SpringLayout.SOUTH, checkInfo, 30, SpringLayout.SOUTH, toggleTextField);
        layout.putConstraint(SpringLayout.WEST, checkInfo, 0, SpringLayout.WEST, toggleTextField);

        // Display frame.
        frame.setVisible(true);
    }

        /**
         * runs every 50 ms, used as a "act" method
         * @param evt
         */
    private void checkTime(ActionEvent evt) {

        if (timeStart) {
            tikCounter++;
            if (tikCounter % 16 == 0) { // account for lag :\, should be 20 in a perfect world but 50 ms refresh rate is
                                        // pretty fast
                int randBreak = (int) (Math.random() * 300);
                if (randBreak == 1 && !rideBroken1) {
                    rideBroken1 = true;
                    safteyFactor *= 0.9;
                    repairButton1.setBackground(Color.red);
                } else if (randBreak == 2 && !rideBroken2) {
                    rideBroken2 = true;
                    safteyFactor *= 0.8;
                    repairButton2.setBackground(Color.red);
                } else if (randBreak == 3 && !rideBroken3) {
                    rideBroken3 = true;
                    safteyFactor *= 0.6;
                    repairButton3.setBackground(Color.red);
                } else if (randBreak == 4 && !rideBroken4) {
                    rideBroken4 = true;
                    safteyFactor *= 0.3;
                    repairButton4.setBackground(Color.red);
                }
                if (customersInPark > 30) {
                    safteyFactor *= 1.001; // simulates reduced risk of peiple leaving the park
                }

                int randDeath = (int) (Math.random() * safteyFactor);

                if (randDeath == 0) {
                    deaths++;
                }
                secondCounter++;
            }
            if (secondCounter >= 60) {
                secondCounter -= 60;
                minuteCounter++;
            }
        }
        dialogLabel.setText(currentDialog);

        if (minuteCounter < 1) {
            gameTimer.setText("Time: " + secondCounter + "s");
        } else {
            gameTimer.setText("Time: " + minuteCounter + "m:" + secondCounter + "s");
        }

        if (minuteCounter == 10 || deaths == 3) {
            LoseScreen app = new LoseScreen();
            frame.dispose();
            timer.stop(); // real important or the gui will keep being opened
        }

        moneyLabel.setText("Debt: " + money * -1 + " dollars");
        deathLabel.setText("Deaths: " + deaths);

        if (!startDialogOver) { // starting dialog
            switch (dialogScrollNum) { // scroll through dialog with increasing dialog scroll number
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
                    deathLabel.setVisible(true);
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
                    toggleTextField.setVisible(true);
                    checkInfo.setVisible(true);
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
                    timeStart = true;
                    gameTimer.setVisible(true);
                    break;
                case 24:
                    startDialogOver = true;
                    dialogScrollNum = 1;
                    break;
            }
        } else {

            switch (dialogScrollNum) {
                case 1:
                    createNewCustomer = true;
                    currentDialog = userName + ": Tickets Please!";
                    break;
                case 2:
                    if (createNewCustomer) {
                        int ranLiar = (int)(Math.random()*6);
                        if (ranLiar==0){
                        Liar customer = new Liar();
                        currentDialog = customer.customerInfo();
                        currentLie = customer.getLie();
                        currentAge = customer.getAge();
                        currentFirstName = customer.getFirstName();
                        currentLastName = customer.getLastName();
                        currentIDNum = customer.getIDNum();
                        currentMoneyCharged = customer.getMoneyCharged();

                        realAge = currentAge;
                        realFirstName = currentFirstName;
                        realLastName = currentLastName;
                        realIDNum = currentIDNum;
                        realMoneyCharged = currentMoneyCharged;

                        if (currentLie.equals("First Name")) {
                            currentFirstName = customer.getFakeFirstName();
                        } else if (currentLie.equals("Last Name")) {
                            currentLastName = customer.getFakeLastName();
                        } else if (currentLie.equals("Age")) {
                            currentAge = customer.getFakeAge();
                        } else if (currentLie.equals("ID")) {
                            currentIDNum = customer.getFakeIDNum();
                        } else if (currentLie.equals("Money")) {
                            currentMoneyCharged = 100;
                        }
                        }
                        else {
                        TruthCustomer customer = new TruthCustomer();
                        currentDialog = customer.customerInfo();
                        currentAge = customer.getAge();
                        currentFirstName = customer.getFirstName();
                        currentLastName = customer.getLastName();
                        currentIDNum = customer.getIDNum();
                        currentMoneyCharged = customer.getMoneyCharged();

                        System.out.println(currentFirstName);
                        System.out.println(currentLastName);
                        System.out.println(currentIDNum);

                        realAge = currentAge;
                        realFirstName = currentFirstName;
                        realLastName = currentLastName;
                        realIDNum = currentIDNum;
                        realMoneyCharged = currentMoneyCharged;
                        }
                        createNewCustomer = false;
                    }
                    break;
            }
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * if enter is pressed dialog will scroll to next line
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            dialogScrollNum++;
        }
    }

    /**
     * when accept button is pressed
     * @param e
     */
    private void acceptOffer(ActionEvent e) {
        if (startDialogOver && dialogScrollNum >= 2) {
            dialogScrollNum = 1;
            customersInPark++;
            safteyFactor *= 0.99;
            inputField.setText("");

            if(realFirstName!=currentFirstName || realLastName!=currentLastName){
                safteyFactor *= 0.94; // if they have fake name, park is less safe
                System.out.println("park got less safe");
            }
            if (realIDNum==currentIDNum){
                money += currentMoneyCharged; // get the money if ticket isn't faked
            }
            else {
                System.out.println("you got scammed");
            }
        }
    }

    /**
     * when person is looked up in terminal
     * @param e
     */
    private void getTrueInfo(ActionEvent e) {
        if (!fieldToggled) {
            System.out.println(realFirstName);
            System.out.println(realLastName);
            System.out.println(realIDNum);

            if (inputField.getText().equals(realFirstName + " " + realLastName)) {
                inputField.setText("Name: " + realFirstName + " " + realLastName + " Age: " + realAge + " Ticket ID: "
                        + realIDNum + " Initial Charge: " + realMoneyCharged);
            } else if (inputField.getText().equals(realIDNum)) {
                inputField.setText("Name: " + realFirstName + " " + realLastName + " Age: " + realAge + " Ticket ID: "
                        + realIDNum + " Initial Charge: " + realMoneyCharged);
            } else {
                inputField.setText("Inputed ID or name is not in data base.");
            }
        }
    }

    /**
     * when toggle text button is pressed, important to change focus between field and frame
     * @param e
     */
    private void toggleTyping(ActionEvent e) {
        if (fieldToggled) {
            inputField.setBackground(Color.white);
            inputField.setFocusable(true);
            frame.setFocusable(false);
            inputField.requestFocus();
            fieldToggled = false;
        } else {
            inputField.setBackground(Color.black);
            frame.setFocusable(true);
            inputField.setFocusable(false);
            frame.requestFocus();
            fieldToggled = true;
        }
    }

    /**
     * when deny button is pressed
     * @param e
     */
    private void denyOffer(ActionEvent e) {
        if (startDialogOver && dialogScrollNum >= 2) {
            dialogScrollNum = 1;
            inputField.setText("");
        }
    }

    /**
     * when gouge button is pressed
     * @param e
     */
    private void gouge(ActionEvent e) {

    }

    /**
     * when repair button 1 is pressed
     * @param e
     */
    private void repair1(ActionEvent e) {
        if (rideBroken1) {
            repairButton1.setBackground(Color.green);
            money -= 10000;
            safteyFactor /= 0.9;
            rideBroken1 = false;
        }
    }

    /**
     * when repair button 2 is pressed
     * @param e
     */
    private void repair2(ActionEvent e) {
        if (rideBroken2) {
            repairButton2.setBackground(Color.green);
            money -= 12000;
            safteyFactor /= 0.8;
            rideBroken2 = false;
        }
    }

    /**
     * when repair button 3 is pressed
     * @param e
     */
    private void repair3(ActionEvent e) {
        if (rideBroken3) {
            repairButton3.setBackground(Color.green);
            money -= 15000;
            safteyFactor /= 0.6;
            rideBroken3 = false;
        }
    }

    /**
     * when repair button 4 is pressed
     * @param e
     */
    private void repair4(ActionEvent e) {
        if (rideBroken4) {
            repairButton4.setBackground(Color.green);
            money -= 20000;
            safteyFactor /= 0.4;
            rideBroken4 = false;
        }
    }

}