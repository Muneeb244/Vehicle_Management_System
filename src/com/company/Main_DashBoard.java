package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_DashBoard {
    private JFrame frame;
    private JPanel panel;

    private JButton user_button;
    private JButton admin_button;
    private JButton back_button;
    private JLabel main_label;

    public Main_DashBoard(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Vehicle Showroom Management System");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(180, 60, 700, 100);

        user_button = new JButton("User");
        user_button.setBounds(300, 200, 400, 100);
        user_button.setBackground(Color.CYAN);
        user_button.setFont(new Font("Aerial", Font.BOLD, 30));
        user_button.addActionListener(new Handler());

        admin_button = new JButton("Admin");
        admin_button.setBounds(300, 400, 400, 100);
        admin_button.setBackground(Color.CYAN);
        admin_button.setFont(new Font("Aerial", Font.BOLD, 30));
        admin_button.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(410, 600, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());



        panel.setBackground(new Color(21, 40, 51));

        panel.add(main_label);
        panel.add(user_button);
        panel.add(admin_button);
        panel.add(back_button);
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
            if(e.getSource() == back_button){
                frame.dispose();
                Get_Started get_started = new Get_Started();
            }
            if(e.getSource() == user_button){
                frame.dispose();
                User_Board user_board = new User_Board();
            }
            if(e.getSource() == admin_button){
                frame.dispose();
                Admin_Login admin_login = new Admin_Login();
            }
        }
    }
}
