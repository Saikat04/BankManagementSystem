import java.util.Random;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Color;
import java.sql.Date;

public class SignupTwo extends JFrame implements ActionListener{    
    JTextField panNumberTextField, aadharNumberTextField;
    JComboBox incomeComboBox, relegionComboBox, educationalComboBox, categoryComboBox, occupationComboBox;
    JRadioButton yes, no, saving, current, noAccount, fixed, recurring, married, unmarried, othersMaratial; 
    JButton next, cancel;
    int formNo;
    JCheckBox declaration;
    String name, fatherName, gender, mobile, email, address, city, pincode, state;
    Date dob;
    SignupTwo(int formNo, String name, String fatherName, Date dob, String gender, String mobile, String email, String address, String state, String city, String pincode) {
        this.formNo = formNo;
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pincode = pincode;

        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel relegion = new JLabel("Relegion: ");
        relegion.setFont(new Font("Raleway", Font.BOLD, 20));
        relegion.setBounds(100, 140, 200, 30);
        add(relegion);
        relegionComboBox = new JComboBox(new String[] {"select", "Hindu", "Muslim", "Sikh", "Christian", "Other"});
        relegionComboBox.setBounds(280, 140, 400, 30);
        relegionComboBox.setBackground(Color.WHITE);
        add(relegionComboBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        categoryComboBox = new JComboBox(new String[] {"select", "General", "OBC", "SC", "ST", "Other"});
        categoryComboBox.setBounds(280, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        incomeComboBox = new JComboBox(new String[] {"select", "Null", "Below 2,50,000", "2,50,000 - 5,00,000", "5,00,000 - 10,00,000", "10,00,000 - 50,00,000", "50,00,000 - 1,00,00,000", "Above 1,00,00,000"});
        incomeComboBox.setBounds(280, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educationalLabel = new JLabel("Education: ");
        educationalLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationalLabel.setBounds(100, 290, 200, 30);
        add(educationalLabel);
        educationalComboBox = new JComboBox(new String[] {"select", "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"});
        educationalComboBox.setBounds(280, 290, 400, 30);
        educationalComboBox.setBackground(Color.WHITE);
        add(educationalComboBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);
        occupationComboBox = new JComboBox(new String[] {"select", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"});
        occupationComboBox.setBounds(280, 340, 400, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        JLabel panNumber = new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100, 390, 200, 30);
        add(panNumber);
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        panNumberTextField.setBounds(280, 390, 400, 30);
        add(panNumberTextField);

        JLabel aadharNumber = new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumber.setBounds(100, 440, 200, 30);
        add(aadharNumber);
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        aadharNumberTextField.setBounds(280, 440, 400, 30);
        add(aadharNumberTextField);

        JLabel maratial = new JLabel("Marital Status: ");
        maratial.setFont(new Font("Raleway", Font.BOLD, 20));
        maratial.setBounds(100, 490, 200, 30);
        add(maratial);
        married = new JRadioButton("Married");
        married.setBounds(280, 490, 125, 30);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(415, 490, 125, 30);
        add(unmarried);
        othersMaratial = new JRadioButton("Others");
        othersMaratial.setBounds(550, 490, 125, 30);
        add(othersMaratial);
        ButtonGroup maratialGroup = new ButtonGroup();
        maratialGroup.add(married);
        maratialGroup.add(unmarried);
        maratialGroup.add(othersMaratial); // to select only one radio button

        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);
        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Raleway", Font.BOLD, 15));
        yes.setBackground(Color.WHITE);
        yes.setBounds(280, 540, 60, 30);
        add(yes);
        no = new JRadioButton("No");
        no.setFont(new Font("Raleway", Font.BOLD, 15));
        no.setBackground(Color.WHITE);
        no.setBounds(350, 540, 60, 30);
        add(no);
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes);
        seniorCitizenGroup.add(no);        

        JLabel exisitingAccount = new JLabel("Exisiting Account: ");
        exisitingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        exisitingAccount.setBounds(100, 590, 200, 30);
        add(exisitingAccount);
        saving = new JRadioButton("Savings");
        saving.setFont(new Font("Raleway", Font.BOLD, 15));
        saving.setBackground(Color.WHITE);
        saving.setBounds(280, 590, 100, 30);
        add(saving);
        current = new JRadioButton("Current");
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBackground(Color.WHITE);
        current.setBounds(400, 590, 100, 30);
        add(current);
        recurring = new JRadioButton("Recurring");
        recurring.setFont(new Font("Raleway", Font.BOLD, 15));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(520, 590, 100, 30);
        add(recurring);
        noAccount = new JRadioButton("No Account");
        noAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        noAccount.setBackground(Color.WHITE);
        noAccount.setBounds(640, 590, 120, 30);
        add(noAccount);
        ButtonGroup exisitingAccountGroup = new ButtonGroup();
        exisitingAccountGroup.add(saving);
        exisitingAccountGroup.add(current);
        exisitingAccountGroup.add(noAccount);
        
        
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge and belief.");
        declaration.setFont(new Font("Raleway", Font.BOLD, 15));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(60, 640, 800, 30);
        add(declaration);
        
        next = new JButton("Next");
        next.setBounds(470, 700, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 700, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next) {
            String relegion = (String)relegionComboBox.getSelectedItem();
            String category = (String)categoryComboBox.getSelectedItem();
            String income = (String)incomeComboBox.getSelectedItem();
            String educational = (String)educationalComboBox.getSelectedItem();
            String occupation = (String)occupationComboBox.getSelectedItem();
            String panNumber = panNumberTextField.getText();
            String aadharNumber = aadharNumberTextField.getText();
            String maratialStatus = null;
            if(married.isSelected()) {
                maratialStatus = "Married";
            } else if(unmarried.isSelected()) {
                maratialStatus = "Unmarried";
            } else if(othersMaratial.isSelected()) {
                maratialStatus = "Others";
            }
            String seniorCitizen = null;
            if(yes.isSelected()) {
                seniorCitizen = "Yes";
            } else if(no.isSelected()) {
                seniorCitizen = "No";
            }
            String exisitingAccount = null;
            if(saving.isSelected()) {
                exisitingAccount = "Savings";
            } else if(current.isSelected()) {
                exisitingAccount = "Current";
            } else if(recurring.isSelected()) {
                exisitingAccount = "Recurring";
            } else if(noAccount.isSelected()) {
                exisitingAccount = "No Account";
            }
            
            try {
                if(panNumber.equals("") || aadharNumber.equals("") || maratialStatus == null ||
                 seniorCitizen == null || exisitingAccount == null || income.equals("") || income.equals("select")
                  || educational.equals("") || educational.equals("select") || occupation.equals("") || occupation.equals("select") ||
                   relegion.equals("") || relegion.equals("select") || category.equals("") || category.equals("select")
                   ) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    if(declaration.isSelected()) {
                        Conn c = new Conn();
                        String query = "INSERT INTO customer_personal_information (formno, name, fname, dob, gender, mobile_no, email, address, state, city, pincode, relegion, category, income, educational, occupation, pannumber, aadharnumber, maratial, seniorcitizen, exisitingaccount) VALUES ('"+formNo+"', '"+name+"', '"+fatherName+"', '"+dob+"', '"+gender+"', '"+mobile+"', '"+email+"', '"+address+"', '"+state+"', '"+city+"', '"+pincode+"', '"+relegion+"', '"+category+"', '"+income+"', '"+educational+"', '"+occupation+"', '"+panNumber+"', '"+aadharNumber+"', '"+maratialStatus+"', '"+seniorCitizen+"', '"+exisitingAccount+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Form 2 Submitted Successfully");
                        setVisible(false);
                        new SignupThree(formNo).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select the declaration.");
                    }                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupTwo(1, "name", "fatherName", new Date(202), "male", "mobile", "email", "address", "state", "city", "pincode");
    }
}
