package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class User_Sign_Up_GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JLabel name_label;
    private JLabel email_label;
    private JLabel password_label;
    private JTextField email_field;
    private JTextField name_field;
    private JTextField password_field;
    private JButton back_button;
    private JButton signup_button;
    private JButton clear_button;

    private Random random;

    public User_Sign_Up_GUI() {
        frame = new JFrame("Vehicle Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Sign UP");
        main_label.setFont(new Font("Serif", Font.BOLD, 50));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(410, 60, 700, 100);

        email_field = new JTextField();
        email_field.setBounds(400, 210, 450, 40);

        email_label = new JLabel("Email:");
        email_label.setFont(new Font("Aerial", Font.BOLD, 30));
        email_label.setForeground(Color.CYAN);
        email_label.setBounds(200, 180, 300, 100);

        name_field = new JTextField();
        name_field.setBounds(400, 350, 450, 40);

        name_label = new JLabel("Name:");
        name_label.setFont(new Font("Aerial", Font.BOLD, 30));
        name_label.setForeground(Color.CYAN);
        name_label.setBounds(200, 320, 300, 100);


        password_field = new JTextField();
        password_field.setBounds(400, 490, 450, 40);

        password_label = new JLabel("Password:");
        password_label.setFont(new Font("Aerial", Font.BOLD, 30));
        password_label.setForeground(Color.CYAN);
        password_label.setBounds(200, 458, 300, 100);


        back_button = new JButton("Back");
        back_button.setBounds(110, 600, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        signup_button = new JButton("Sign Up");
        signup_button.setBounds(410, 600, 180, 60);
        signup_button.setBackground(Color.CYAN);
        signup_button.setFont(new Font("Aerial", Font.BOLD, 20));
        signup_button.addActionListener(new Handler());


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
        panel.add(signup_button);
        panel.add(clear_button);
        panel.add(name_field);
        panel.add(name_label);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    class Handler implements ActionListener{
        private int id;
        public PreparedStatement st;

        @Override
        public void actionPerformed(ActionEvent e) {

            random = new Random();
            id = random.nextInt(10000)+1;

            if(e.getSource() == back_button){
                frame.dispose();
                User_Board user_board = new User_Board();
            }

            if(e.getSource() == signup_button){
                boolean chk = true;
                if(name_field.getText().isEmpty() || email_field.getText().isEmpty() || password_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fields should not be empty!!!");
                }
                else{
                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");

//                        Check for already signed up users
                        Statement st = con.createStatement();
                        ResultSet result = st.executeQuery("select * from customer");
                        while(result.next()){
                            if (email_field.getText().equals(result.getString(3))) {
                                JOptionPane.showMessageDialog(null, "User already exists!!!");
                                frame.dispose();
                                User_Board user_board = new User_Board();
                                chk = false;
                            }
                        }
                        if(chk){
                            PreparedStatement pst = con.prepareStatement("insert into customer(password, user_id, user_mail, user_name) values(?, ?, ?, ?)");
                            pst.setString(1, password_field.getText());
                            pst.setInt(2, id);
                            pst.setString(3, email_field.getText());
                            pst.setString(4, name_field.getText());
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Sign up Successful!!!");
                            con.close();
                            frame.dispose();
                            User_Board user_board = new User_Board();
                        }
                    } catch (Exception ex) {
                        System.out.println(e.toString());
                    }
                }

            }
            if(e.getSource() == clear_button){
                email_field.setText("");
                name_field.setText("");
                password_field.setText("");
            }
        }
    }
}
