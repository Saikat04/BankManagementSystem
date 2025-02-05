import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;
    BigInteger cardno;
    Withdraw(BigInteger cardno) {
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

        JLabel heading = new JLabel("Please Enter the amount you want to Withdraw:");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(158, 350, 700, 35);
        imagLabel.add(heading);

        amount = new JTextField();
        amount.setBounds(230, 400, 200, 26);
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        imagLabel.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.gray);
        withdraw.setBounds(350, 450, 100, 26);
        withdraw.addActionListener(this);
        imagLabel.add(withdraw);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.gray);
        back.setBounds(200, 450, 100, 26);
        back.addActionListener(this);
        imagLabel.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String amountText = amount.getText().trim();
            if (amountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                long amount = 0;
                try { 
                    amount = Long.parseLong(amountText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid amount");
                    return;
                }
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select balance from customer_amount where card_no = " + cardno);
                    Double balance = 0.0;
                    if (rs.next()) {
                        balance = rs.getDouble("balance");
                    }
                    if(balance < amount) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }
                    String query = "update customer_amount set balance = balance - " + amount + " where card_no = " + cardno;
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Amount Withdrawed Successfully");

                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    String transactionQuery = "INSERT INTO account_statment (card_no, date_time, transaction_type, balance, current_balance) VALUES (" + cardno + ", '" + timestamp + "', 'WITHDRAW', " + amount + ", " + (balance - amount) + ")";
                    conn.s.executeUpdate(transactionQuery);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in depositing amount");
                    return;
                }
                this.setVisible(false);
                new Transaction(cardno).setVisible(true);
            }
        } else if (e.getSource() == back) {
            this.setVisible(false);
            new Transaction(cardno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw(new BigInteger("5040936073122933"));
    }
    
}
