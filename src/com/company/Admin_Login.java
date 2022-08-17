package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin_Login {
    JFrame frame;
    JPanel panel;
    JLabel admin_login_label;
    JLabel passcode_label;
    JTextField passcode_field;
    JButton login_button;
    JButton back_button;


    public Admin_Login(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        admin_login_label = new JLabel("Vehicle Showroom Management System");
        admin_login_label.setFont(new Font("Serif", Font.BOLD, 35));
        admin_login_label.setForeground(Color.CYAN);
        admin_login_label.setBounds(220, 60, 700, 100);


        panel.setBackground(new Color(21, 40, 51));

        passcode_field = new JTextField();
        passcode_field.setBounds(400, 300, 450, 40);

        passcode_label = new JLabel("Passcode:");
        passcode_label.setFont(new Font("Aerial", Font.BOLD, 30));
        passcode_label.setForeground(Color.CYAN);
        passcode_label.setBounds(200, 270, 300, 100);

        back_button = new JButton("Back");
        back_button.setBounds(600, 500, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        login_button = new JButton("Sign In");
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

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == login_button){
                boolean chk = true;
                try{
                    Integer.parseInt(passcode_field.getText());
                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                        Statement st = con.createStatement();
                        ResultSet result = st.executeQuery("select * from Admin");
                        while(result.next()){
                            if(result.getInt(2) == Integer.parseInt(passcode_field.getText())){
                                JOptionPane.showMessageDialog(null, "You are Logged In successfully!!!");
                                frame.dispose();
                                chk = false;
                                Admin_Dashboard admin_dashboard = new Admin_Dashboard();
                            }
                        }
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println(e.toString());
                    }
                    if(chk){
                        JOptionPane.showMessageDialog(null, "Invalid Credentials!!!");
                        frame.dispose();
                        Main_DashBoard main_dashBoard = new Main_DashBoard();
                    }

                }catch (Exception z){
                    JOptionPane.showMessageDialog(null, "Enter valid Integer!!!");
                    passcode_field.setText("");
                }
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Main_DashBoard main_dashBoard = new Main_DashBoard();
            }
        }
    }
}
