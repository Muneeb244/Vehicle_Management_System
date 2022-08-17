package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin_Manage_Bike_Board {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton addbike_button;
    private JButton updatebike_button;
    private JButton viewbike_button;
    private JButton deletebike_button;
    private JButton back_button;

    public Admin_Manage_Bike_Board(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Manage bikes");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 30, 700, 100);


        addbike_button = new JButton("Add bikes");
        addbike_button.setBounds(300, 130, 450, 90);
        addbike_button.setBackground(Color.CYAN);
        addbike_button.setFont(new Font("Aerial", Font.BOLD, 25));
        addbike_button.addActionListener(new Handler());

        updatebike_button = new JButton("Update bikes");
        updatebike_button.setBounds(300, 270, 450, 90);
        updatebike_button.setBackground(Color.CYAN);
        updatebike_button.setFont(new Font("Aerial", Font.BOLD, 25));
        updatebike_button.addActionListener(new Handler());

        viewbike_button = new JButton("View bikes");
        viewbike_button.setBounds(300, 420, 450, 90);
        viewbike_button.setBackground(Color.CYAN);
        viewbike_button.setFont(new Font("Aerial", Font.BOLD, 25));
        viewbike_button.addActionListener(new Handler());

        deletebike_button = new JButton("Delete bikes");
        deletebike_button.setBounds(300, 565, 450, 90);
        deletebike_button.setBackground(Color.CYAN);
        deletebike_button.setFont(new Font("Aerial", Font.BOLD, 25));
        deletebike_button.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(435, 690, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(addbike_button);
        panel.add(updatebike_button);
        panel.add(viewbike_button);
        panel.add(deletebike_button);
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
            if(e.getSource() == addbike_button){
                frame.dispose();
                Admin_Add_Bike_GUI admin_add_bike_gui = new Admin_Add_Bike_GUI();
            }
            if(e.getSource() == updatebike_button){
                frame.dispose();
                Admin_Update_Bike_GUI admin_update_bike_gui = new Admin_Update_Bike_GUI();
            }
            if (e.getSource() == viewbike_button) {
                frame.dispose();
                Admin_View_Bike_GUI admin_view_bike_gui = new Admin_View_Bike_GUI();
            }
            if(e.getSource() == deletebike_button){
                frame.dispose();
                Admin_Delete_Bike_GUI admin_delete_bike_gui = new Admin_Delete_Bike_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Vehicles admin_manage_vehicles = new Admin_Manage_Vehicles();
            }
        }
    }
}

