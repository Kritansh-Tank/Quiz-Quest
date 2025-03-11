package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Leaderboard extends JFrame implements ActionListener {
    JTextArea leaderboardArea;
    JButton back, viewHistory;
    JTextField nameField;
    
    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/quizdb";
    static final String USER = "root";
    static final String PASSWORD = "";
    
    Leaderboard() {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Leaderboard");
        heading.setBounds(250, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 255));
        add(heading);
        
        leaderboardArea = new JTextArea();
        leaderboardArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        leaderboardArea.setEditable(false);
        leaderboardArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JScrollPane scrollPane = new JScrollPane(leaderboardArea);
        scrollPane.setBounds(50, 80, 650, 300);
        add(scrollPane);
        
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(50, 400, 120, 30);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(180, 400, 200, 30);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameField);
        
        viewHistory = new JButton("View Quiz History");
        viewHistory.setBounds(400, 400, 200, 40);
        viewHistory.setBackground(new Color(30, 144, 255));
        viewHistory.setForeground(Color.WHITE);
        viewHistory.setFont(new Font("Tahoma", Font.BOLD, 16));
        viewHistory.addActionListener(this);
        add(viewHistory);
        
        back = new JButton("Back");
        back.setBounds(300, 460, 150, 40);
        back.setBackground(new Color(255, 69, 0));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);
        
        loadLeaderboard();
        
        setVisible(true);
    }
    
    private void loadLeaderboard() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, score FROM leaderboard ORDER BY score DESC LIMIT 10")) {
            
            StringBuilder sb = new StringBuilder("Top Scores:\n\n");
            while (rs.next()) {
                sb.append(rs.getString("name")).append(" - ").append(rs.getInt("score")).append("\n");
            }
            leaderboardArea.setText(sb.length() > 0 ? sb.toString() : "No scores available yet.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            leaderboardArea.setText("Error loading leaderboard.\n" + e.getMessage());
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewHistory) {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a name to view history.");
            } else {
                new QuizHistory(name);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
    
    public static void saveScore(String name, int score) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO leaderboard (name, score) VALUES (?, ?)");) {
            
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving score: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Leaderboard();
    }
}
