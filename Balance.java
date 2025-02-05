import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener{
<<<<<<< HEAD
    BigInteger cardno;
    JButton back;
=======
    JButton back;
    BigInteger cardno;
>>>>>>> d972bc7 (Initial commit)
    Balance(BigInteger cardno) {
        this.cardno = cardno;
        setLayout(null);
        setSize(900, 900);
<<<<<<< HEAD
        setLocation(300, 0);
=======
        setLocation(300, 0);        
>>>>>>> d972bc7 (Initial commit)
        setUndecorated(true);
        setVisible(true);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image);
        JLabel imagLabel = new JLabel(newIcon);
        imagLabel.setBounds(0, 0, 900, 900);
        add(imagLabel);

        JLabel heading = new JLabel("Balance Enquiry:");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 16));
        heading.setBounds(178, 300, 700, 35);
        imagLabel.add(heading);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.gray);
<<<<<<< HEAD
        back.setBounds(290, 510, 100, 26);
=======
        back.setBounds(290, 490, 100, 26);
>>>>>>> d972bc7 (Initial commit)
        back.addActionListener(this);
        imagLabel.add(back);

        try {
            Conn conn = new Conn();
<<<<<<< HEAD
            ResultSet rs = conn.s.executeQuery("select balance from customer_amount where card_no = " + cardno );
            if(rs.next()) {
                JLabel label = new JLabel("Your Account Balance is Rs.: "+rs.getString("balance"));
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Raleway", Font.BOLD, 16));
                label.setBounds(178, 350, 700, 35);
                imagLabel.add(label);
            }
        } catch (Exception e) {
=======
            ResultSet rs = conn.s.executeQuery("select balance from customer_amount where card_no = " + cardno);
            while(rs.next()) {
                JLabel label1 = new JLabel("Your Account Balance is Rs. "+rs.getString("balance"));
                label1.setForeground(Color.WHITE);
                label1.setFont(new Font("Raleway", Font.BOLD, 16));
                label1.setBounds(178, 350, 700, 35);
                imagLabel.add(label1);
            }
        } catch(Exception e) {
>>>>>>> d972bc7 (Initial commit)
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
<<<<<<< HEAD
            this.setVisible(false);
            new Transaction(cardno).setVisible(true);
=======
            new Transaction(cardno).setVisible(true);
            setVisible(false);
>>>>>>> d972bc7 (Initial commit)
        }
    }
    public static void main(String[] args) {
        new Balance(new BigInteger("5040936058658165"));
    }
<<<<<<< HEAD
=======
    
>>>>>>> d972bc7 (Initial commit)
}
