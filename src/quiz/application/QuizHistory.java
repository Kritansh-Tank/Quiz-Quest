package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QuizHistory extends JFrame implements ActionListener {
    JTextArea historyArea;
    JButton back;
    
    QuizHistory(String playerName) {
        setBounds(400, 150, 750, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Quiz History for " + playerName);
        heading.setBounds(200, 30, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);
        
        historyArea = new JTextArea();
        historyArea.setBounds(50, 80, 650, 300);
        historyArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        historyArea.setEditable(false);
        add(historyArea);
        
        back = new JButton("Back");
        back.setBounds(300, 400, 120, 30);
        back.setBackground(new Color(30, 144, 255));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        loadQuizHistory(playerName);
        
        setVisible(true);
    }
    
    private void loadQuizHistory(String playerName) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "");
             PreparedStatement pstmt = conn.prepareStatement("SELECT score, DATE_FORMAT(timestamp, '%Y-%m-%d %H:%i') AS date FROM leaderboard WHERE name = ? ORDER BY timestamp DESC");) {
            
            pstmt.setString(1, playerName);
            ResultSet rs = pstmt.executeQuery();
            
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Score: ").append(rs.getInt("score"))
                  .append(" | Date: ").append(rs.getString("date"))
                  .append("\n");
            }
            historyArea.setText(sb.length() > 0 ? sb.toString() : "No history available.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            historyArea.setText("Error loading history.");
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new QuizHistory("User");
    }
}