package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class User_Sign_In_GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JLabel email_label;
    private JLabel password_label;
    private JTextField email_field;
    private JTextField password_field;
    private JButton back_button;
    private JButton signin_button;
    private JButton clear_button;

    static int customer_id = 0;
    static int user_id = 0;
    public User_Sign_In_GUI() {
        frame = new JFrame("Vehicle Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Sign In");
        main_label.setFont(new Font("Serif", Font.BOLD, 50));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(410, 60, 700, 100);

        email_field = new JTextField();
        email_field.setBounds(400, 250, 450, 40);

        email_label = new JLabel("Email:");
        email_label.setFont(new Font("Aerial", Font.BOLD, 30));
        email_label.setForeground(Color.CYAN);
        email_label.setBounds(200, 220, 300, 100);


        password_field = new JTextField();
        password_field.setBounds(400, 390, 450, 40);

        password_label = new JLabel("Password:");
        password_label.setFont(new Font("Aerial", Font.BOLD, 30));
        password_label.setForeground(Color.CYAN);
        password_label.setBounds(200, 358, 300, 100);


        back_button = new JButton("Back");
        back_button.setBounds(110, 600, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        signin_button = new JButton("Sign In");
        signin_button.setBounds(410, 600, 180, 60);
        signin_button.setBackground(Color.CYAN);
        signin_button.setFont(new Font("Aerial", Font.BOLD, 20));
        signin_button.addActionListener(new Handler());


        clear_button = new JButton("Clear");
        clear_button.setBounds(710, 600, 180, 60);
        clear_button.setBackground(Color.CYAN);
        clear_button.setFont(new Font("Aerial", Font.BOLD, 20));
        clear_button.addActionListener(new Handler());


        panel.setBackground(new Color(21, 40, 51));
        panel.add(main_label);
        panel.add(email_field);
        panel.add(email_label);
        panel.add(password_field);
        panel.add(password_label);
        panel.add(back_button);
        panel.add(signin_button);
        panel.add(clear_button);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == back_button){
                frame.dispose();
                User_Board user_board = new User_Board();
            }
            if(e.getSource() == signin_button){
                boolean chk = true;
                if(email_field.getText().isEmpty() || password_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fields should not be empty!!!");
                }
                else{
                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                        Statement st = con.createStatement();
                        ResultSet result = st.executeQuery("select * from customer");
                        while(result.next()) {
                            if (email_field.getText().equals(result.getString(3)) &&
                                    password_field.getText().equals(result.getString(1))) {
                                customer_id = result.getInt(2);
                                user_id = result.getInt(2);
                                JOptionPane.showMessageDialog(null, "You are Logged In successfully!!!");
                                chk = false;
                                frame.dispose();
                                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(e.toString());
                    }
                    if(chk){
                        JOptionPane.showMessageDialog(null, "Invalid Credentials!!!");
                        password_field.setText("");
                        email_field.setText("");

                    }
                }
            }
            if(e.getSource() == clear_button){
                email_field.setText("");
                password_field.setText("");
            }
        }
    }
}