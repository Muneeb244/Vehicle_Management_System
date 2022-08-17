package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Car_Board {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton addcar_button;
    private JButton updatecar_button;
    private JButton viewcar_button;
    private JButton deletecar_button;
    private JButton back_button;

    public Admin_Manage_Car_Board(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Manage Cars");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 30, 700, 100);


        addcar_button = new JButton("Add cars");
        addcar_button.setBounds(300, 130, 450, 90);
        addcar_button.setBackground(Color.CYAN);
        addcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        addcar_button.addActionListener(new Handler());

        updatecar_button = new JButton("Update cars");
        updatecar_button.setBounds(300, 270, 450, 90);
        updatecar_button.setBackground(Color.CYAN);
        updatecar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        updatecar_button.addActionListener(new Handler());

        viewcar_button = new JButton("View Cars");
        viewcar_button.setBounds(300, 420, 450, 90);
        viewcar_button.setBackground(Color.CYAN);
        viewcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        viewcar_button.addActionListener(new Handler());

        deletecar_button = new JButton("Delete Cars");
        deletecar_button.setBounds(300, 565, 450, 90);
        deletecar_button.setBackground(Color.CYAN);
        deletecar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        deletecar_button.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(435, 690, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(addcar_button);
        panel.add(updatecar_button);
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
                Admin_Add_Car_GUI admin_add_car_gui = new Admin_Add_Car_GUI();
            }
            if(e.getSource() == updatecar_button){
                frame.dispose();
                Admin_Update_Select_Car_Gui admin_update_select_car_gui = new Admin_Update_Select_Car_Gui();
            }
            if (e.getSource() == viewcar_button) {
                frame.dispose();
                Admin_View_Car_GUI admin_view_car_gui = new Admin_View_Car_GUI();
            }
            if(e.getSource() == deletecar_button){
                frame.dispose();
                Admin_Delete_Car_GUI admin_delete_car_gui = new Admin_Delete_Car_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Vehicles admin_manage_vehicles = new Admin_Manage_Vehicles();
            }
        }
    }
}
