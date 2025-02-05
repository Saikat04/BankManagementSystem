import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit, withdraw, fastCash, balanceEnquiry, pinChange, miniStatement, cashTransfer, exit;
    BigInteger cardno;
    Transaction(BigInteger cardno) {
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

        JLabel heading = new JLabel("Please select your Transaction");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(215, 300, 700, 35);
        imagLabel.add(heading);

        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.gray);
        deposit.setBounds(160, 417, 100, 26);
        deposit.addActionListener(this);
        imagLabel.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.gray);
        withdraw.setBounds(160, 450, 100, 26);
        withdraw.addActionListener(this);
        imagLabel.add(withdraw);

        fastCash = new JButton("FAST CASH");
        fastCash.setBackground(Color.white);
        fastCash.setForeground(Color.gray);
        fastCash.setBounds(160, 483, 100, 26);
        imagLabel.add(fastCash);

        exit = new JButton("EXIT");
        exit.setBackground(Color.white);
        exit.setForeground(Color.gray);
        exit.setBounds(160, 516, 100, 26);
        exit.addActionListener(this);
        imagLabel.add(exit);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBackground(Color.white);
        pinChange.setForeground(Color.gray);
        pinChange.setBounds(400, 417, 115, 26);
        pinChange.addActionListener(this);
        imagLabel.add(pinChange);

        miniStatement = new JButton("STATEMENT");
        miniStatement.setBackground(Color.white);
        miniStatement.setForeground(Color.gray);
        miniStatement.setBounds(400, 450, 115, 26);
        miniStatement.addActionListener(this);
        imagLabel.add(miniStatement);

        balanceEnquiry = new JButton("BALANCE");
        balanceEnquiry.setBackground(Color.white);
        balanceEnquiry.setForeground(Color.gray);
        balanceEnquiry.setBounds(400, 483, 115, 26);
        balanceEnquiry.addActionListener(this);
        imagLabel.add(balanceEnquiry);

        cashTransfer = new JButton("TRANSFER");
        cashTransfer.setBackground(Color.white);
        cashTransfer.setForeground(Color.gray);
        cashTransfer.setBounds(400, 516, 115, 26);
        cashTransfer.addActionListener(this);
        imagLabel.add(cashTransfer);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = ae.getActionCommand();
        if (a.equals("DEPOSIT")) {
            new Deposite(cardno).setVisible(true);
            setVisible(false);
        } else if (a.equals("WITHDRAW")) {
            new Withdraw(cardno).setVisible(true);
            setVisible(false);
        } else if (a.equals("FAST CASH")) {
            // new FastCash().setVisible(true);
            // setVisible(false);
        } else if (a.equals("EXIT")) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (a.equals("PIN CHANGE")) {
            new pinChange(cardno).setVisible(true);
            setVisible(false);
        } else if (a.equals("STATEMENT")) {
            new statment(cardno).setVisible(true);
            setVisible(false);
        } else if (a.equals("BALANCE")) {
            new Balance(cardno).setVisible(true);
            setVisible(false);
        } else if (a.equals("TRANSFER")) {
            new Transfer(cardno).setVisible(true);
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new Transaction(new BigInteger("5040936058658165"));
    }
}