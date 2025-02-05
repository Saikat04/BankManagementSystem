import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.ResultSet;

public class statment extends JFrame implements ActionListener{
    BigInteger cardno;
    JButton back;
    statment(BigInteger cardno) {
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

        JLabel heading = new JLabel("Mini Statement:");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(178, 300, 700, 35);
        imagLabel.add(heading);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.gray);
        back.setBounds(290, 510, 100, 26);
        back.addActionListener(this);
        imagLabel.add(back);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from account_statment where card_no = " + cardno + " order by date_time desc limit 1");
            while(rs.next()) {
                JLabel label1 = new JLabel("Card No: "+rs.getString("card_no"));
                label1.setForeground(Color.WHITE);
                label1.setFont(new Font("Raleway", Font.BOLD, 16));
                label1.setBounds(178, 350, 700, 35);
                imagLabel.add(label1);

                JLabel label2 = new JLabel("Date: "+rs.getString("date_time"));
                label2.setForeground(Color.WHITE);
                label2.setFont(new Font("Raleway", Font.BOLD, 16));
                label2.setBounds(178, 380, 700, 35);
                imagLabel.add(label2);

                JLabel label3 = new JLabel("Type: "+rs.getString("transaction_type"));
                label3.setForeground(Color.WHITE);
                label3.setFont(new Font("Raleway", Font.BOLD, 16));
                label3.setBounds(178, 410, 700, 35);
                imagLabel.add(label3);

                JLabel label4 = new JLabel("Amount: "+rs.getString("balance"));
                label4.setForeground(Color.WHITE);
                label4.setFont(new Font("Raleway", Font.BOLD, 16));
                label4.setBounds(178, 440, 700, 35);
                imagLabel.add(label4);

                JLabel label5 = new JLabel("Current Balance: "+rs.getString("current_balance"));
                label5.setForeground(Color.WHITE);
                label5.setFont(new Font("Raleway", Font.BOLD, 16));
                label5.setBounds(178, 470, 700, 35);
                imagLabel.add(label5);


            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            new Transaction(cardno).setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new statment(new BigInteger("5040936058658165"));
    }
    
}
