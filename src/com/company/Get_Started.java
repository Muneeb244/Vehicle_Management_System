package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Get_Started {
    private static JFrame frame;
    private static JPanel panel;
    private static JButton starting_button;

    public Get_Started(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        JLabel main_label = new JLabel("Welcome to");
        JLabel main_label2 = new JLabel("Vehicle Showroom Management System");
        main_label.setFont(new Font("Arial", Font.BOLD, 35));
        main_label2.setFont(new Font("Serif", Font.BOLD, 40));
        main_label.setForeground(Color.CYAN);
        main_label2.setForeground(Color.CYAN);

        main_label.setBounds(400, 60, 500, 100);
        main_label2.setBounds(140, 100, 800, 100);

        starting_button = new JButton("Get Started");
        starting_button.setBounds(300, 500, 400, 100);
        starting_button.setBackground(Color.CYAN);
        starting_button.setFont(new Font("Aerial", Font.BOLD, 30));

        starting_button.addActionListener(new Handler());

        panel.add(starting_button);
        panel.add(main_label);
        panel.add(main_label2);
        panel.setBackground(new Color(21, 40, 51));


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
            if(e.getSource() == starting_button){
                frame.dispose();
                Main_DashBoard main_dashBoard = new Main_DashBoard();
            }
        }
    }
}
