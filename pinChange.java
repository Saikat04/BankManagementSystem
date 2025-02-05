import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.ResultSet;

public class pinChange extends JFrame implements ActionListener {
    JButton change, back;
    JTextField confirmPin;
    JPasswordField oldPin, newPin;
    BigInteger cardno;

    pinChange(BigInteger cardno) {
        this.cardno = cardno;
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image);
        JLabel imagLabel = new JLabel(newIcon);
        imagLabel.setBounds(0, 0, 900, 900);
        add(imagLabel);

        JLabel heading = new JLabel("Enter old pin:");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(178, 350, 150, 35);
        imagLabel.add(heading);

        oldPin = new JPasswordField();
        oldPin.setBounds(320, 355, 150, 26);
        oldPin.setForeground(Color.BLACK);
        oldPin.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(oldPin);

        JLabel heading2 = new JLabel("Enter new pin:");
        heading2.setForeground(Color.WHITE);
        heading2.setFont(new Font("Raleway", Font.BOLD, 16));
        heading2.setBounds(178, 400, 150, 35);
        imagLabel.add(heading2);

        newPin = new JPasswordField();
        newPin.setBounds(320, 405, 150, 26);
        newPin.setForeground(Color.BLACK);
        newPin.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(newPin);

        JLabel heading3 = new JLabel("Confirm new pin:");
        heading3.setForeground(Color.WHITE);
        heading3.setFont(new Font("Raleway", Font.BOLD, 16));
        heading3.setBounds(178, 450, 150, 35);
        imagLabel.add(heading3);

        confirmPin = new JTextField();
        confirmPin.setBounds(320, 455, 150, 26);
        confirmPin.setForeground(Color.BLACK);
        confirmPin.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(confirmPin);

        change = new JButton("CHANGE");
        change.setBackground(Color.white);
        change.setForeground(Color.gray);
        change.setBounds(350, 510, 100, 26);
        imagLabel.add(change);
        change.addActionListener(this);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.gray);
        back.setBounds(200, 510, 100, 26);
        imagLabel.add(back);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            String oldPin = this.oldPin.getText();
            int oldPinno;
            try {
                oldPinno = Integer.parseInt(oldPin);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid pin");
                return;
            }
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s
                        .executeQuery("select * from login where pin = " + oldPinno + " and card_no = " + cardno);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Incorrect old pin");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error while matching pin");
                return;
            }
            String newPin = this.newPin.getText();
            String confirmPin = this.confirmPin.getText();

            if (newPin.equals("") || confirmPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter all the fields");
            } else if (!newPin.equals(confirmPin) || newPin.length() != 4) {
                JOptionPane.showMessageDialog(null, "New pin and confirm pin should be same and of 4 digits");
            } else {
                int newPinNo;
                try {
                    newPinNo = Integer.parseInt(newPin);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid pin");
                    return;
                }
                try {
                    Conn c1 = new Conn();
                    String q1 = "update account_services set pin = " + newPinNo + " where pin = " + oldPinno;
                    String q2 = "update login set pin = " + newPinNo + " where pin = " + oldPinno;
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    new Transaction(cardno).setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == back) {
            new Transaction(cardno).setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new pinChange(new BigInteger("5040936073122933"));
    }

}
