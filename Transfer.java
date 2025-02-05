import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.*;

public class Transfer extends JFrame implements ActionListener {
    JButton transfer, back;
    JTextField amount, recipentAccount;
    BigInteger cardno;

    Transfer(BigInteger cardno) {
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

        JLabel heading = new JLabel("Please Enter recipent's account number:");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(178, 350, 700, 35);
        imagLabel.add(heading);

        recipentAccount = new JTextField();
        recipentAccount.setBounds(240, 400, 200, 26);
        recipentAccount.setForeground(Color.BLACK);
        recipentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(recipentAccount);

        JLabel heading2 = new JLabel("Amount:");
        heading2.setForeground(Color.WHITE);
        heading2.setFont(new Font("Raleway", Font.BOLD, 16));
        heading2.setBounds(162, 436, 100, 35);
        imagLabel.add(heading2);

        amount = new JTextField();
        amount.setBounds(240, 440, 200, 26);
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(amount);

        transfer = new JButton("TRANSFER");
        transfer.setBackground(Color.white);
        transfer.setForeground(Color.gray);
        transfer.setBounds(350, 490, 100, 26);
        transfer.addActionListener(this);
        imagLabel.add(transfer);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.gray);
        back.setBounds(200, 490, 100, 26);
        back.addActionListener(this);
        imagLabel.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transfer) {
            String recipentAccountText = recipentAccount.getText().trim();
            if (recipentAccountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter recipent's account number");
                return;
            } else {
                BigInteger recipentAccountNo;
                try {
                    recipentAccountNo = new BigInteger(recipentAccountText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid account number");
                    return;
                }
                if(cardno.equals(recipentAccountNo)) {
                    JOptionPane.showMessageDialog(null, "You cannot transfer to your own account");
                    return;
                }
                long sendingAmount = 0;
                try {
                    sendingAmount = Long.parseLong(amount.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount");
                    return;
                }
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from login where card_no = " + recipentAccountNo);
                    // System.out.print(recipentAccountNo);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Recipent's account number does not exist");
                        return;
                    }
                    rs = conn.s.executeQuery("select balance from customer_amount where card_no = " + cardno);
                    Double balanceSender = 0.0;
                    if (rs.next()) {
                        balanceSender = rs.getDouble("balance");
                    }
                    if (balanceSender < sendingAmount) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }
                    rs = conn.s
                            .executeQuery("select balance from customer_amount where card_no = " + recipentAccountNo);
                    Double balanceRecipent = 0.0;
                    if (rs.next()) {
                        balanceRecipent = rs.getDouble("balance");
                    }
                    try {
                        conn.s.executeUpdate("update customer_amount set balance = balance + " + sendingAmount
                                + " where card_no = " + recipentAccountNo);
                        conn.s.executeUpdate("update customer_amount set balance = balance - " + sendingAmount
                                + " where card_no = " + cardno);
                        JOptionPane.showMessageDialog(null, "Amount Transfered Successfully to " + recipentAccountNo);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error in updating balance");
                        return;
                    }

                    try {
                        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                        String transactionType = "Transfer to " + recipentAccountNo;
                        String transactionQuery = "INSERT INTO account_statment (card_no, date_time, transaction_type, balance, current_balance) VALUES ("
                                + cardno + ", '" + timestamp + "', '" + transactionType + "', " + sendingAmount + ", "
                                + (balanceSender - sendingAmount) + ")";
                        conn.s.executeUpdate(transactionQuery);
                        transactionType = "Recive from " + cardno;
                        transactionQuery = "INSERT INTO account_statment (card_no, date_time, transaction_type, balance, current_balance) VALUES ("
                                + recipentAccountNo + ", '" + timestamp + "', '" + transactionType + "', "
                                + sendingAmount + ", " + (balanceRecipent + sendingAmount) + ")";
                        conn.s.executeUpdate(transactionQuery);
                        new Transaction(cardno).setVisible(true);
                        setVisible(false);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error in updating transaction");
                        return;
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        } else if (e.getSource() == back) {
            this.setVisible(false);
            new Transaction(cardno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transfer(new BigInteger("5040936073122933"));
    }

}
