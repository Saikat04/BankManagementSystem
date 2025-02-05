import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    ButtonGroup accountTypeGroup;
    JRadioButton saving, current, fixed, recurring;
    JCheckBox checkBook, internetBanking, mobileBanking, emailAlerts, estatement, declaration;
    JButton clear, submit;
    int formNumber;
    SignupThree(int formNumber) {
        this.formNumber = formNumber;
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
        
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(290, 80, 400, 30);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type: ");
        accountType.setFont(new Font("Raleway", Font.BOLD, 20));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);
        accountTypeGroup = new ButtonGroup();
        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(300, 140, 200, 30);
        add(saving);
        accountTypeGroup.add(saving);
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        current.setBounds(520, 140, 200, 30);
        add(current);
        accountTypeGroup.add(current);
        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16)); 
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(300, 180, 200, 30);
        add(fixed);
        accountTypeGroup.add(fixed);
        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(520, 180, 250, 30);
        add(recurring);
        accountTypeGroup.add(recurring);

        JLabel card = new JLabel("ATM Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 240, 200, 30);
        add(card);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(300, 240, 250, 30);
        add(number);

        JLabel pin = new JLabel("PIN Number: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 290, 200, 30);
        add(pin);
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pinNumber.setBounds(300, 290, 200, 30);
        add(pinNumber);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 340, 200, 30);
        add(services);
        checkBook = new JCheckBox("Check Book");
        checkBook.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBook.setBackground(Color.WHITE);
        checkBook.setBounds(300, 340, 200, 30);
        add(checkBook);
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(500, 340, 200, 30);
        add(internetBanking);
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(300, 380, 200, 30);
        add(mobileBanking);
        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setFont(new Font("Raleway", Font.BOLD, 16));
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setBounds(500, 380, 200, 30);
        add(emailAlerts);
        estatement = new JCheckBox("E-Statement");
        estatement.setFont(new Font("Raleway", Font.BOLD, 16));
        estatement.setBackground(Color.WHITE);
        estatement.setBounds(300, 420, 200, 30);
        add(estatement);

        declaration = new JCheckBox("I hereby declare that I accept terms & conditions the above entered services.");
        declaration.setFont(new Font("Raleway", Font.BOLD, 16));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(100, 470, 800, 30);
        add(declaration);

        clear = new JButton("Clear");
        clear.setFont(new Font("Raleway", Font.BOLD, 16));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(320, 520, 100, 30);
        add(clear);
        clear.addActionListener(this);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(470, 520, 100, 30);
        add(submit);
        submit.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if(declaration.isSelected()) {
                if(accountTypeGroup == null) {
                    JOptionPane.showMessageDialog(null, "Please select an account type.");
                } else {
                    try {
                        String accountType = null;
                        if(saving.isSelected()) {
                            accountType = "Saving Account";
                        } else if(current.isSelected()) {
                            accountType = "Current Account";
                        } else if(fixed.isSelected()) {
                            accountType = "Fixed Deposit Account";
                        } else if(recurring.isSelected()) {
                            accountType = "Recurring Deposit Account";
                        }
                        String CheckBook = "No";
                        if(checkBook.isSelected()) {
                            CheckBook = "Yes";
                        }
                        String InternetBanking = "No";
                        if(internetBanking.isSelected()) {
                            InternetBanking = "Yes";
                        }
                        String MobileBanking = "No";
                        if(mobileBanking.isSelected()) {
                            MobileBanking = "Yes";
                        }
                        String EmailAlerts = "No";
                        if(emailAlerts.isSelected()) {
                            EmailAlerts = "Yes";
                        }
                        String EStatement = "No";
                        if(estatement.isSelected()) {
                            EStatement = "Yes";
                        }
                        Random random = new Random();   
                        long cardNumber = (Math.abs(random.nextLong()) % 90000000L + Math.abs(random.nextLong()) % 90000000L) % 90000000L + 5040936000000000L;
                        int pinNumber = Math.abs(random.nextInt() % 9000) + 1000;
                        Conn c1 = new Conn();
                        String query1 = "insert into account_services (formno, account_type, card_no, pin, check_book, internet_banking, mobile_banking, email_alerts, e_statement) values('"+formNumber+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+CheckBook+"', '"+InternetBanking+"', '"+MobileBanking+"', '"+EmailAlerts+"', '"+EStatement+"')";
                        c1.s.executeUpdate(query1);
                        String query2 = "insert into login (card_no, pin) values('"+cardNumber+"', '"+pinNumber+"')";
                        c1.s.executeUpdate(query2);
                        String query3 = "insert into customer_amount (card_no) values('"+cardNumber+"')";
                        c1.s.executeUpdate(query3);

                        JOptionPane.showMessageDialog(null, "Your Application has been successfully submitted. Please note your details"+"\nCard Number: " + cardNumber + "\nPIN: " + pinNumber);
                        JOptionPane.showMessageDialog(null, "We are redirecting you to Log In page. Thank you for choosing us.");
                        setVisible(false);
                        new Login().setVisible(true);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please check the declaration box to proceed.");
            }
        } else if(e.getSource() == clear) {
            checkBook.setSelected(false);
            internetBanking.setSelected(false);
            mobileBanking.setSelected(false);
            emailAlerts.setSelected(false);
            estatement.setSelected(false);
            declaration.setSelected(false);
            accountTypeGroup.clearSelection();
        }
    }
    public static void main(String[] args) {
        new SignupThree(1234);
    }
    
}
