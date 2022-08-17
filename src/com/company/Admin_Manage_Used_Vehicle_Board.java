package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Used_Vehicle_Board {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton addusedcar_button;
    private JButton updateusedcar_button;
    private JButton viewusedcar_button;
    private JButton deleteusedcar_button;
    private JButton back_button;
    public Admin_Manage_Used_Vehicle_Board(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Manage Used Cars");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(400, 30, 700, 100);


        addusedcar_button = new JButton("Add Cars");
        addusedcar_button.setBounds(300, 130, 450, 90);
        addusedcar_button.setBackground(Color.CYAN);
        addusedcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        addusedcar_button.addActionListener(new Handler());

        updateusedcar_button = new JButton("Update Cars");
        updateusedcar_button.setBounds(300, 270, 450, 90);
        updateusedcar_button.setBackground(Color.CYAN);
        updateusedcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        updateusedcar_button.addActionListener(new Handler());

        viewusedcar_button = new JButton("View Cars");
        viewusedcar_button.setBounds(300, 420, 450, 90);
        viewusedcar_button.setBackground(Color.CYAN);
        viewusedcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        viewusedcar_button.addActionListener(new Handler());

        deleteusedcar_button = new JButton("Delete Cars");
        deleteusedcar_button.setBounds(300, 565, 450, 90);
        deleteusedcar_button.setBackground(Color.CYAN);
        deleteusedcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        deleteusedcar_button.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(435, 690, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(addusedcar_button);
        panel.add(updateusedcar_button);
        panel.add(viewusedcar_button);
        panel.add(deleteusedcar_button);
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
            if(e.getSource() == addusedcar_button){
                frame.dispose();
                Admin_Add_Used_Car_GUI admin_add_used_car_gui = new Admin_Add_Used_Car_GUI();
            }
            if(e.getSource() == updateusedcar_button){
                frame.dispose();
                UpdateUsedGUI updateUsedGUI = new UpdateUsedGUI();
            }
            if (e.getSource() == viewusedcar_button) {
                frame.dispose();
                Admin_View_Used_Car_GUI admin_view_used_car_gui = new Admin_View_Used_Car_GUI();
            }
            if(e.getSource() == deleteusedcar_button){
                frame.dispose();
                Admin_Delete_Used_Car_GUI admin_delete_used_car_gui = new Admin_Delete_Used_Car_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Vehicles admin_manage_vehicles = new Admin_Manage_Vehicles();
            }
        }
    }
}
