// to compile : javac -cp ".;C:\Users\SAIKAT DUA\OneDrive\Documents\portfolioProject\AutomatedTellerMachine\src\jcalendar-1.4.jar" SignupOne.java
// to run : java -cp ".;C:\Users\SAIKAT DUA\OneDrive\Documents\portfolioProject\AutomatedTellerMachine\src\jcalendar-1.4.jar" SignupOne

// package src;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.sql.Date;
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
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, phoneTextField,addressTextField, stateTextField, cityTextField, pinCodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, othersGender;
    JButton next, cancel;
    JCheckBox declaration;
    SignupOne()  {
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        // Generating application no.
        Random ran = new Random();
        random = (Math.abs((ran.nextInt() % 9000)) + Math.abs((ran.nextInt() % 9000))) % 9000 + 1000;
        JLabel fromno = new JLabel("APPLICATION FROM NO. " + random);
        fromno.setFont(new Font("Raleway", Font.BOLD, 38));
        fromno.setBounds(140, 20, 600, 40);
        add(fromno); 

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        nameTextField.setBounds(280, 140, 400, 30);
        add(nameTextField);

        JLabel fatherName = new JLabel("Father's Name: ");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameTextField.setBounds(280, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(280, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(280, 290, 125, 30);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(415, 290, 125, 30);
        add(female);
        othersGender = new JRadioButton("Others");
        othersGender.setBounds(550, 290, 125, 30);
        add(othersGender);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);
        gendeGroup.add(othersGender); // to select only one radio button

        JLabel phone = new JLabel("Phone No: ");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(100, 340, 200, 30);
        add(phone);
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        phoneTextField.setBounds(280, 340, 400, 30);
        add(phoneTextField);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 390, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailTextField.setBounds(280, 390, 400, 30);
        add(emailTextField);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        addressTextField.setBounds(280, 440, 400, 30);
        add(addressTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 490, 100, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        stateTextField.setBounds(280, 490, 400, 30);
        add(stateTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 540, 100, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        cityTextField.setBounds(280, 540, 400, 30);
        add(cityTextField);

        JLabel pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 100, 30);
        add(pinCode);
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        pinCodeTextField.setBounds(280, 590, 400, 30);
        add(pinCodeTextField);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge and belief.");
        declaration.setFont(new Font("Raleway", Font.BOLD, 15));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(60, 640, 800, 30);
        add(declaration);
        
        next = new JButton("Next");
        next.setBounds(470, 690, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 690, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next) {
            int formno = (int) random;
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            java.util.Date utilDate = dateChooser.getDate();        
            if (utilDate == null) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
                return;
            }            
            java.sql.Date dob = new java.sql.Date(utilDate.getTime()); // Convert java.util.Date to java.sql.Date
            String gender = null;
            if(male.isSelected()) {
                gender = "Male";
            } else if(female.isSelected()) {
                gender = "Female";
            } else if(othersGender.isSelected()) {
                gender = "Others";
            }
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String address = addressTextField.getText();
            String state = stateTextField.getText();
            String city = cityTextField.getText();
            String pinCode = pinCodeTextField.getText();
            try {
                if(name.equals("") || fname.equals("") || gender.equals("") || email.equals("")
                  || address.equals("") || state.equals("") || city.equals("")
                   || pinCode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    return;
                } else {
                    if(declaration.isSelected()) {
                        setVisible(false);
                        new SignupTwo(formno, name, fname, dob, gender, phone, email, address, state, city, pinCode).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select the declaration.");
                        return;
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
        new SignupOne();
    }
}
