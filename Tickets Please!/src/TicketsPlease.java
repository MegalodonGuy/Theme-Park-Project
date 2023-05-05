import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**
 * Initial frame that starts the game, you input your user name and get a little exposition.
 */
public class TicketsPlease{
    private JFrame frame;
    private JButton button;
    private JButton denyButton;
    private JButton acceptButton;
    private JLabel label;
    private JLabel titleLabel;
    private JLabel topLeft;
    private JLabel dialog2; 
    private JLabel dialog3; 
    private JLabel dialog4;
    private String userName;
    private boolean textAppear1=false; 
    private JTextField nameField;
    public TicketsPlease() {
        // Set up frame.
        frame = new JFrame("Start Screen");
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
        titleLabel= new JLabel("Tickets Please!"); 
        Dimension titleSize = titleLabel.getPreferredSize();
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
        titleLabel.setBounds(300, 100, titleSize.width, titleSize.height);
        titleLabel.setForeground(Color.black);
        titleLabel.setBackground(new Color(255,255,255));
        titleLabel.setOpaque(true);

        //set up empty label for positioning purposes
        topLeft= new JLabel("");
        topLeft.setVisible(false);
        // Set up dialog label.
        label = new JLabel("Ona: Hi I am Ona Park, the owner of Rickety Rollers Theme Park, and will be conducting your Interveiw for today! Would you please state your name?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        Dimension size = label.getPreferredSize();
        label.setBounds(300, 100, size.width, size.height);
        label.setForeground(Color.black);
        label.setBackground(new Color(255,255,255));
        label.setOpaque(true);
        label.setBorder(BorderFactory.createEtchedBorder());
        //Set up 2nd dialog label
        dialog2 = new JLabel("");
            Dimension dialog2Size = label.getPreferredSize();
            dialog2.setBounds(300, 100, dialog2Size.width, dialog2Size.height);
            dialog2.setForeground(Color.black);
            dialog2.setBackground(new Color(255,255,255));
            dialog2.setOpaque(true);
            dialog2.setBorder(BorderFactory.createEtchedBorder());
            dialog2.setVisible(false);

        //Set up 3rd dialog label
        dialog3 = new JLabel("");
        Dimension  dialog3Size = label.getPreferredSize();
        dialog3.setBounds(300, 100, dialog3Size.width, dialog3Size.height);
        dialog3.setForeground(Color.black);
        dialog3.setBackground(new Color(255,255,255));
        dialog3.setOpaque(true);
        dialog3.setBorder(BorderFactory.createEtchedBorder());
        dialog3.setVisible(false);
        //Set up 4th dialog label
        dialog4 = new JLabel("");
        Dimension  dialog4Size = label.getPreferredSize();
        dialog4.setBounds(300, 100, dialog4Size.width, dialog4Size.height);
        dialog4.setForeground(Color.black);
        dialog4.setBackground(new Color(255,255,255));
        dialog4.setOpaque(true);
        dialog4.setBorder(BorderFactory.createEtchedBorder());
        dialog4.setVisible(false);

        //label.setIcon(icon);

        
        // Set up button.
        button = new JButton("Submit");
        button.addActionListener(this::submitName);
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        //Set up deny button
        denyButton = new JButton("No Way");
        denyButton.addActionListener(this::deny);
        denyButton.setFocusable(false);
        denyButton.setContentAreaFilled(false);
        denyButton.setVisible(false);
        //Set up accept button
        acceptButton = new JButton("Whats the worst that can happen? Sure!");
        acceptButton.addActionListener(this::accept);
        acceptButton.setFocusable(false);
        acceptButton.setContentAreaFilled(false);
        acceptButton.setVisible(false);
        //set up name entering text field
        nameField = new JTextField("");
        nameField.setPreferredSize(new Dimension(140,20));
        nameField.setBounds(50, 50, 150, 0);

        //set up layout
        layout.putConstraint(SpringLayout.WEST, label,100,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, label,100,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, titleLabel,400,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, titleLabel,50,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, nameField,40,SpringLayout.SOUTH,label);
        layout.putConstraint(SpringLayout.WEST, nameField,340,SpringLayout.WEST,label);
        layout.putConstraint(SpringLayout.SOUTH, button,0,SpringLayout.SOUTH,nameField);
        layout.putConstraint(SpringLayout.WEST, button,-80,SpringLayout.WEST,nameField);
        layout.putConstraint(SpringLayout.SOUTH, dialog2,200,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, dialog2,100,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, dialog3,230,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, dialog3,100,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, dialog4,260,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, dialog4,100,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, acceptButton,300,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, acceptButton,100,SpringLayout.WEST,topLeft);
        layout.putConstraint(SpringLayout.SOUTH, denyButton,300,SpringLayout.SOUTH,topLeft);
        layout.putConstraint(SpringLayout.WEST, denyButton,400,SpringLayout.WEST,topLeft);

        // Add components to frame.
        frame.add(titleLabel);
        frame.add(label);
        frame.add(nameField);
        frame.add(button);
        frame.add(dialog2);
        frame.add(dialog3);
        frame.add(dialog4);
        frame.add(acceptButton);
        frame.add(denyButton);
        frame.getContentPane().setBackground(new Color(191,231,233));

        // Display frame.
        frame.setVisible(true);
    }

    private void submitName (ActionEvent event) {
        if (event.getSource()==button){
            userName=nameField.getText(); 
            dialog2.setText("Ona: Hi "+ userName+", you're hired!");
            dialog2.setVisible(true);
            dialog3.setText(userName+": It's that easy?");
            dialog3.setVisible(true);
            dialog4.setText("Ona: Oh ya we're severly understaffed, We will see you tomorrow! You will be covering the role of the receptionist, mechanic and ride operator!");
            dialog4.setVisible(true);
            denyButton.setVisible(true);
            acceptButton.setVisible(true);
        }
        
    }

    private void deny (ActionEvent event){
        if (event.getSource()==denyButton){
            LoseScreen app = new LoseScreen();
            frame.setVisible(false);
        }
    }
    private void accept (ActionEvent event){
        if (event.getSource()==acceptButton){
            GamePlay app= new GamePlay(userName);
            frame.setVisible(false);
        }
    }

    
    
    }