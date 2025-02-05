// package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.ResultSet;

// ActionListener interface is used to perform action by button
public class Login extends JFrame implements ActionListener {
    JButton signin, signup, clear, exit;
    JTextField cardnoTextField;
    JPasswordField pinnoTextField;
    
    Login() {
        // to disable all predefined layout
        setLayout(null);

        // set window
        setTitle("Automated Teller Machine"); // to set title of the window
        setSize(800, 480); // to set size of the window
        setUndecorated(true);
        setVisible(true); // to see the window
        setLocation(350, 200); // to set starting position of the windoow

        // to add icon on the window
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // to scale the icon on the frame
        ImageIcon scaledIcon1 = new ImageIcon(i1);
        JLabel label1 = new JLabel(scaledIcon1);
        label1.setBounds(70, 10, 100, 100);
        add(label1);

        getContentPane().setBackground(Color.WHITE); // to set background color

        // to add heding
        JLabel heading = new JLabel("Welcome to ATM");
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        heading.setBounds(200, 40, 400, 40);
        add(heading);

        // to add card no
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 24));
        cardno.setBounds(170, 150, 200, 30);
        add(cardno);
        // to add text field
        cardnoTextField = new JTextField();
        cardnoTextField.setBounds(310, 150, 250, 30);
        cardnoTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cardnoTextField);

        // to add pin no
        JLabel pinno = new JLabel("PIN:");
        pinno.setFont(new Font("Raleway", Font.BOLD, 24));
        pinno.setBounds(170, 210, 200, 30);
        add(pinno);
        pinnoTextField = new JPasswordField();
        pinnoTextField.setBounds(310, 210, 250, 30);
        pinnoTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(pinnoTextField);

        // to add buttons
        signin = new JButton("SIGN IN");
        signin.setBounds(290, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this); // perform specific action by button
        add(signin);

        signup = new JButton("SIGN UP");
        signup.setBounds(420, 300, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(290, 350, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        exit = new JButton("EXIT");
        exit.setBounds(420, 350, 100, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        } else if (ae.getSource() == clear) {
            cardnoTextField.setText("");
            pinnoTextField.setText("");
        } else if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == signin) {
            BigInteger cardno;
            int pinno;
            try {
                cardno = new BigInteger(cardnoTextField.getText());
                pinno = Integer.parseInt(pinnoTextField.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid card no or pin no");
                return;
            }
            try {
                Conn conn = new Conn();
                String query = "select * from login where card_no = '" + cardno + "' and pin = '" + pinno + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    new Transaction(cardno).setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid card no or pin no");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

// 5040936073122933	4209
// 5040936058658165
