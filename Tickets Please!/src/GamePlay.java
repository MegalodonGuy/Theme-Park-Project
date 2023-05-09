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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * JFrame where the main game will take place, does all gameplay gui elements,
 * gameplay variables and uses Customer class when creating its random infinite
 * gameplay loop
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
    private JWindow park;

    private JWindow fire1JWindow;
    private JWindow fire2JWindow;
    private JWindow fire3JWindow;
    private JWindow fire4JWindow;

    private JLabel fire1;
    private JLabel fire2;
    private JLabel fire3;
    private JLabel fire4;

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
    private int money = -150000;
    private int deaths = 0;
    private static int maxDeaths = 3;
    private int customersInPark = 0;
    private double safteyFactor = 150000; // goes down when theme park is less safe, used to vary probability of death,
                                          // higher is better
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

    private Audio explosion;
    private Audio music;
    private Audio saulIntro;
    private Audio jorjiIntro;
    private int maxScam; // max number of scams a person can take before leaving

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
        dialog14 = "Ona: 150,000 dollars ... and 22 pending lawsuits. I got about 10 minutes to pay the debt.";
        dialog15 = userName + ": How are you getting out of that?";
        dialog16 = "Ona: By using you of course, you're going to have to cut some corners for me.";
        dialog17 = userName + ": What corners?";
        dialog18 = "Ona: Safty, ethics and the law. Do what you can to get as much money as possible.";
        dialog19 = "Ona: When customers come in, charge an extra fee, when rides are unsafe, run them anyway. Evaluate risk and price gouge.";
        dialog20 = "Ona: Use the text field to enter a customers full name or ID to make sure their ticket matches. You can deny or accept their entrance";
        dialog21 = "Ona: Use the buttons on the side to repair rides when they turn red, it will still run unrepaired but have an increase chance of a minor fatal oopsie";
        dialog22 = "Ona: Also use the toggle terminal button to use or stop using the text field, don't have it on when accepting tickets, it's rude. Thats it, Have fun!";
        dialog23 = userName + ": I need to learn how to start saying no. Welp here comes my first customer...";

        timer.start();
        // Set up frame.
        frame = new JFrame("Tickets Please!");
        frame.setSize(1050, 700);
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

        // set up window that displays the park
        ImageIcon parkImage = new ImageIcon("Tickets Please!/src/themePark.jpg");
        JLabel image = new JLabel(parkImage);

        park = new JWindow(frame);
        park.setSize(390, 360);
        park.add(image);
        park.setLocation(frame.getX() + 10, frame.getY() + 310);
        park.setVisible(true);

        // set up window that displays the first fire
        fire1JWindow = new JWindow(park);
        ImageIcon fire = new ImageIcon("Tickets Please!/src/SmalFire.png");
        fire1 = new JLabel(fire);
        fire1JWindow.add(fire1);
        fire1JWindow.setBackground(new Color(0, 0, 0, 0)); // set to transparent
        fire1JWindow.setLocation(park.getX() + 60, park.getY() - 40);
        fire1JWindow.pack();
        fire1JWindow.setVisible(false);
        // set up window that displays the second fire
        fire2JWindow = new JWindow(park);
        fire2 = new JLabel(fire);
        fire2JWindow.add(fire2);
        fire2JWindow.setBackground(new Color(0, 0, 0, 0)); // set to transparent
        fire2JWindow.setLocation(park.getX() + 260, park.getY() - 20);
        fire2JWindow.pack();
        fire2JWindow.setVisible(false);
        // set up window that displays the third fire
        fire3JWindow = new JWindow(park);
        fire3 = new JLabel(fire);
        fire3JWindow.add(fire3);
        fire3JWindow.setBackground(new Color(0, 0, 0, 0)); // set to transparent
        fire3JWindow.setLocation(park.getX() + 50, park.getY() + 250);
        fire3JWindow.pack();
        fire3JWindow.setVisible(false);
        // set up window that displays the fourth fire
        fire4JWindow = new JWindow(park);
        fire4 = new JLabel(fire);
        fire4JWindow.add(fire4);
        fire4JWindow.setBackground(new Color(0, 0, 0, 0)); // set to transparent
        fire4JWindow.setLocation(park.getX() + 200, park.getY() + 120);
        fire4JWindow.pack();
        fire4JWindow.setVisible(false);
        // set up music
        music = new Audio();
        music.setFile("Tickets Please!/src/fsm-team-escp-patchwork.wav");
        music.play();
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
        layout.putConstraint(SpringLayout.WEST, moneyLabel, 900, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.WEST, dialogLabel, 10, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.WEST, inputField, 400, SpringLayout.WEST, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, inputField, 300, SpringLayout.SOUTH, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, dialogLabel, 50, SpringLayout.SOUTH, gameTimer);
        layout.putConstraint(SpringLayout.SOUTH, yesButton, 50, SpringLayout.SOUTH, inputField);
        layout.putConstraint(SpringLayout.WEST, yesButton, 10, SpringLayout.WEST, inputField);
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
     * 
     * @param evt
     */
    private void checkTime(ActionEvent evt) {
        park.setLocation(frame.getX() + 10, frame.getY() + 290);
        fire1JWindow.setLocation(park.getX() + 60, park.getY() - 40);
        fire2JWindow.setLocation(park.getX() + 260, park.getY() - 20);
        fire3JWindow.setLocation(park.getX() + 50, park.getY() + 250);
        fire4JWindow.setLocation(park.getX() + 200, park.getY() + 120);
        if (timeStart) {
            tikCounter++;
            if (tikCounter % 3600 == 0) {// length of song, loops it
                music = new Audio();
                music.setFile("Tickets Please!/src/fsm-team-escp-patchwork.wav");
                music.play();
            }
            if (tikCounter % 16 == 0) { // account for lag :\, should be 20 in a perfect world.

                int randBreak = (int) (Math.random() * 300);
                if (randBreak == 1 && !rideBroken1) {
                    destroyRide(1);
                } else if (randBreak == 2 && !rideBroken2) {
                    destroyRide(2);
                } else if (randBreak == 3 && !rideBroken3) {
                    destroyRide(3);
                } else if (randBreak == 4 && !rideBroken4) {
                    destroyRide(4);
                }
                if (customersInPark > 30) {
                    safteyFactor *= 1.001; // simulates reduced risk of peiple leaving the park
                }

                int randDeath = (int) (Math.random() * safteyFactor);

                money += (int) (customersInPark / 2);

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

        if (minuteCounter >= 10 || deaths >= maxDeaths) {
            music.stop();
            new EndScreen(false);
            frame.dispose();
            timer.stop(); // real important or the gui will keep being opened...
        }

        if (money >= 0) {
            music.stop();
            new EndScreen(true);
            frame.dispose();
            timer.stop();
        }

        moneyLabel.setText("Debt: " + money * -1 + " dollars");
        deathLabel.setText("Deaths: " + deaths + "/" + maxDeaths);

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
                case -1:
                    currentDialog = currentFirstName + ": Screw you theif!";
                    break;
                case 0:
                    dialogScrollNum = 1;
                    break;
                case 1:
                    createNewCustomer = true;
                    currentDialog = userName + ": Ticket Please!";
                    break;
                case 2:
                    if (createNewCustomer) {
                        int ranCharacterType = (int) (Math.random() * 20);
                        if (ranCharacterType <= 5) {
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

                            if (realAge < 30) {
                                maxScam = 0;
                            } else if (realAge < 60) {
                                maxScam = 1;
                            } else if (realAge < 90) {
                                maxScam = 2;
                            } else {
                                maxScam = 3;
                            }
                        } else if (ranCharacterType > 5 && ranCharacterType < 17) {
                            TruthCustomer customer = new TruthCustomer();
                            // uses inheritance to use all these methods, polymorphism for customer info.
                            currentDialog = customer.customerInfo();
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

                            if (realAge < 30) {
                                maxScam = 0;
                            } else if (realAge < 60) {
                                maxScam = 1;
                            } else if (realAge < 90) {
                                maxScam = 2;
                            } else {
                                maxScam = 3;
                            }
                        } else {
                            SpecialCharacters customer = new SpecialCharacters();

                            currentDialog = customer.customerInfo();

                            currentAge = customer.getFakeAge();
                            currentFirstName = customer.getFakeFirstName();
                            currentLastName = customer.getFakeLastName();
                            currentIDNum = customer.getFakeIDNum();
                            currentMoneyCharged = customer.getFakeMoneyCharged();

                            realAge = customer.getAge();
                            realFirstName = customer.getFirstName();
                            realLastName = customer.getLastName();
                            realIDNum = customer.getIDNum();
                            realMoneyCharged = customer.getMoneyCharged();

                            maxScam = customer.getScamNumber();

                            if (realFirstName == "James") {
                                saulIntro = new Audio();
                                saulIntro.setFile("Tickets Please!/src/BCS.wav");
                                saulIntro.play();
                            }
                            if (realFirstName == "Jorji") {
                                jorjiIntro = new Audio();
                                jorjiIntro.setFile("Tickets Please!/src/speech-announce.wav");
                                jorjiIntro.play();
                            }
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
     * 
     * @param e
     */
    private void acceptOffer(ActionEvent e) {
        if (startDialogOver && dialogScrollNum >= 2) {
            dialogScrollNum = 1;
            customersInPark++;
            safteyFactor *= 0.99;
            inputField.setText("");

            if (realFirstName != currentFirstName || realLastName != currentLastName) {
                if (currentIDNum != "7777" && currentIDNum != "3467+1") {
                    safteyFactor *= 0.85; // if they have fake name, park is less safe
                }
            }
            if (realIDNum == currentIDNum) {
                money += realMoneyCharged; // get the money if ticket isn't faked
            }

            if (realFirstName == "James" && realLastName == "Mcguill") {
                maxDeaths += 2;
                System.out.println("You got some legal help");
            } else if (realFirstName == "Jorji" && realLastName == "Costava") {
                safteyFactor += 3000;
                System.out.println("Potato man gave his protection");
            } else if (realFirstName == "I" && realLastName == "Bomb") {
                destroyRide(1);
                destroyRide(2);
                destroyRide(3);
                destroyRide(4);
                deaths++;
            }
            money += currentMoneyCharged - realMoneyCharged; // if you scam them still get that money
        }
    }

    /**
     * when person is looked up in terminal
     * 
     * @param e
     */
    private void getTrueInfo(ActionEvent e) {
        if (!fieldToggled) {
            if (inputField.getText().equals(realFirstName + " " + realLastName)) {
                inputField.setText("Name: " + realFirstName + " " + realLastName + " Age: " + realAge + " Ticket ID: "
                        + realIDNum + " Charge: " + realMoneyCharged);
            } else if (inputField.getText().equals(realIDNum)) {
                inputField.setText("Name: " + realFirstName + " " + realLastName + " Age: " + realAge + " Ticket ID: "
                        + realIDNum + " Initial Charge: " + realMoneyCharged);
            } else {
                inputField.setText("Inputed ID or name is not in data base.");
            }
        }
    }

    /**
     * when toggle text button is pressed, important to change focus between field
     * and frame
     * 
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
     * 
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
     * 
     * @param e
     */
    private void gouge(ActionEvent e) {
        if (startDialogOver && dialogScrollNum >= 2) {
            if (maxScam > 0) {
                currentMoneyCharged += 1000;
                currentDialog = "Name: " + currentFirstName + " " + currentLastName + " Age: " + currentAge
                        + " Ticket ID: " + currentIDNum + " Charge: " + currentMoneyCharged;
                maxScam--;
            } else {
                dialogScrollNum = -1;
            }
        }
    }

    /**
     * when repair button 1 is pressed
     * 
     * @param e
     */
    private void repair1(ActionEvent e) {
        if (rideBroken1) {
            repairButton1.setBackground(Color.green);
            money -= 10000;
            safteyFactor /= 0.9;
            rideBroken1 = false;
            fire1JWindow.setVisible(false);
        }
    }

    /**
     * when repair button 2 is pressed
     * 
     * @param e
     */
    private void repair2(ActionEvent e) {
        if (rideBroken2) {
            repairButton2.setBackground(Color.green);
            money -= 12000;
            safteyFactor /= 0.8;
            rideBroken2 = false;
            fire2JWindow.setVisible(false);
        }
    }

    /**
     * when repair button 3 is pressed
     * 
     * @param e
     */
    private void repair3(ActionEvent e) {
        if (rideBroken3) {
            repairButton3.setBackground(Color.green);
            money -= 15000;
            safteyFactor /= 0.6;
            rideBroken3 = false;
            fire3JWindow.setVisible(false);
        }
    }

    /**
     * when repair button 4 is pressed
     * 
     * @param e
     */
    private void repair4(ActionEvent e) {
        if (rideBroken4) {
            repairButton4.setBackground(Color.green);
            money -= 20000;
            safteyFactor /= 0.4;
            rideBroken4 = false;
            fire4JWindow.setVisible(false);
        }
    }

    /**
     * the ride you want to break
     * @param rideNum
     */
    private void destroyRide (int rideNum){
        if (rideNum==1){
            rideBroken1 = true;
            fire1JWindow.setVisible(true);
            repairButton1.setBackground(Color.red);
        }
        else if(rideNum==2){
            rideBroken2 = true;
            fire2JWindow.setVisible(true);
            repairButton2.setBackground(Color.red);
        }
        else if (rideNum==3){
            rideBroken3 = true;
            fire3JWindow.setVisible(true);
            repairButton3.setBackground(Color.red);
        }
        else if (rideNum==4){
            rideBroken4 = true;
            fire4JWindow.setVisible(true);
            repairButton4.setBackground(Color.red);
        }
        explosion = new Audio();
        explosion.setFile("Tickets Please!/src/Explosion+3.wav");
        explosion.play();
    }

}
