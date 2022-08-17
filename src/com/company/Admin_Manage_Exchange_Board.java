package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Exchange_Board {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton addcar_button;

    private JButton viewcar_button;
    private JButton deletecar_button;
    private JButton back_button;
    public Admin_Manage_Exchange_Board(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Manage Exchange Vehicles");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(320, 30, 700, 100);


        addcar_button = new JButton("Add cars");
        addcar_button.setBounds(300, 190, 450, 90);
        addcar_button.setBackground(Color.CYAN);
        addcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        addcar_button.addActionListener(new Admin_Manage_Exchange_Board.Handler());

        viewcar_button = new JButton("View Cars");
        viewcar_button.setBounds(300, 480, 450, 90);
        viewcar_button.setBackground(Color.CYAN);
        viewcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        viewcar_button.addActionListener(new Admin_Manage_Exchange_Board.Handler());

        deletecar_button = new JButton("Delete cars");
        deletecar_button.setBounds(300, 330, 450, 90);
        deletecar_button.setBackground(Color.CYAN);
        deletecar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        deletecar_button.addActionListener(new Admin_Manage_Exchange_Board.Handler());

        back_button = new JButton("Back");
        back_button.setBounds(435, 640, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Admin_Manage_Exchange_Board.Handler());

        panel.add(main_label);
        panel.add(addcar_button);
        panel.add(viewcar_button);
        panel.add(deletecar_button);
        panel.add(back_button);
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
            if(e.getSource() == addcar_button){
                frame.dispose();
                Admin_Add_Exchange_Vehicle n = new Admin_Add_Exchange_Vehicle();
            }
            if (e.getSource() == viewcar_button) {
                frame.dispose();
                Admin_View_Exchange_Car admin_view_exchange_car = new Admin_View_Exchange_Car();
            }
            if(e.getSource() == deletecar_button){
                frame.dispose();
                Admin_Delete_Exchange_Vehicle admin_delete_exchange_vehicle = new Admin_Delete_Exchange_Vehicle();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Vehicles admin_manage_vehicles = new Admin_Manage_Vehicles();
            }
        }
    }
}

