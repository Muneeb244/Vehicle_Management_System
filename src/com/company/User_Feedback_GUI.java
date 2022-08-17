package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User_Feedback_GUI {

    JFrame frame;
    JPanel panel;
    JLabel admin_login_label;
    JLabel passcode_label;
    JTextField passcode_field;
    JButton login_button;
    JButton back_button;

    public User_Feedback_GUI() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        admin_login_label = new JLabel("Vehicle Showroom Management System");
        admin_login_label.setFont(new Font("Serif", Font.BOLD, 35));
        admin_login_label.setForeground(Color.CYAN);
        admin_login_label.setBounds(220, 60, 700, 100);


        panel.setBackground(new Color(21, 40, 51));

        passcode_field = new JTextField();
        passcode_field.setBounds(400, 300, 450, 40);

        passcode_label = new JLabel("Feedback:");
        passcode_label.setFont(new Font("Aerial", Font.BOLD, 30));
        passcode_label.setForeground(Color.CYAN);
        passcode_label.setBounds(200, 270, 300, 100);

        back_button = new JButton("Back");
        back_button.setBounds(600, 500, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        login_button = new JButton("Submit");
        login_button.setBounds(220, 500, 180, 60);
        login_button.setBackground(Color.CYAN);
        login_button.setFont(new Font("Aerial", Font.BOLD, 20));
        login_button.addActionListener(new Handler());

        panel.add(passcode_field);
        panel.add(passcode_label);
        panel.add(admin_login_label);
        panel.add(back_button);
        panel.add(login_button);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    class Handler implements ActionListener {

        private int id;
        private Random random;

        @Override
        public void actionPerformed(ActionEvent e) {

            random = new Random();
            id = random.nextInt(10000)+1;
            if(e.getSource() == login_button){

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);

                if(passcode_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field should not be empty!!!");
                }
                else {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Muneeb", "you");
                        String query = "insert into Feedbacks(feedback_id, description, F_DATE, customer_user_id) values(?, ?, ?, ?)";
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setInt(1, id);
                        pst.setString(2, passcode_field.getText());
                        pst.setString(3, date);
                        pst.setInt(4, User_Sign_In_GUI.customer_id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Feedback Submitted!!!");
                        con.close();
                        frame.dispose();
                        User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
                    } catch (SQLException ex) {
                        System.out.println(e.toString());
                    }
                }
            }
            if(e.getSource() == back_button){
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
        }
    }

}
