package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Profile extends JFrame implements ActionListener {
    JTextField ageField, emailField, contactField;
    JButton save, cancel;
    String name;

    Profile(String name) {
        this.name = name;

        setBounds(400, 150, 750, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("User Profile");
        heading.setBounds(250, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 255));
        add(heading);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(150, 100, 100, 30);
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(250, 100, 300, 30);
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ageField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(150, 150, 100, 30);
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(250, 150, 300, 30);
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(emailField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(150, 200, 100, 30);
        contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(250, 200, 300, 30);
        contactField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(contactField);

        save = new JButton("Save");
        save.setBounds(250, 270, 120, 40);
        save.setBackground(new Color(30, 144, 255));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Tahoma", Font.BOLD, 18));
        save.addActionListener(this);
        add(save);

        cancel = new JButton("Cancel");
        cancel.setBounds(430, 270, 120, 40);
        cancel.setBackground(new Color(255, 69, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            String age = ageField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();

            if (age.isEmpty() || email.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "");
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, age, email, contact) VALUES (?, ?, ?, ?)") ) {
                
                pstmt.setString(1, name);
                pstmt.setInt(2, Integer.parseInt(age));
                pstmt.setString(3, email);
                pstmt.setString(4, contact);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Profile Saved Successfully!");
                setVisible(false);
                new Rules(name);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error Saving Profile");
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Profile("Test User");
    }
}
