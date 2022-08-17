package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Admin_Manage_Vehicles {
    private JFrame frame;
    private JPanel panel;
    private JButton manage_cars;
    private JButton manage_motorbikes;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JButton  manage_test_drive;
    private JLabel main_label;

    public Admin_Manage_Vehicles() {
        frame = new JFrame("Manage Vehicles");
        panel = new JPanel(null);
        main_label = new JLabel("Manage Vehicles");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);

        //Manage cars
        manage_cars = new JButton("Manage Cars");
        manage_cars.setBounds(300, 150, 400, 70);
        manage_cars.setBackground(Color.CYAN);
        manage_cars.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_cars.addActionListener(new Handler());

        //Manage_Motorbikes
        manage_motorbikes = new JButton("Manage Motorbikes");
        manage_motorbikes.setBounds(300, 250, 400, 70);
        manage_motorbikes.setBackground(Color.CYAN);
        manage_motorbikes.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_motorbikes.addActionListener(new Handler());

        // Manage used
        manage_used_vehicles = new JButton("Manage Used Vehicles");
        manage_used_vehicles.setBounds(300, 350, 400, 70);
        manage_used_vehicles.setBackground(Color.CYAN);
        manage_used_vehicles.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_used_vehicles.addActionListener(new Handler());

        // Manage Test Drive

        manage_test_drive = new JButton("Manage Test Drive");
        manage_test_drive.setBounds(300, 450, 400, 70);
        manage_test_drive.setBackground(Color.CYAN);
        manage_test_drive.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_test_drive.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(400, 560, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(manage_cars);
        panel.add(manage_used_vehicles);
        panel.add(manage_motorbikes);
        panel.add(manage_test_drive);
        panel.add(back_button);
        panel.add(main_label);
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
            if(e.getSource() == manage_cars){
                frame.dispose();
                Admin_Manage_Car_Board admin_manage_car_board = new Admin_Manage_Car_Board();
            }
            if(e.getSource() == manage_motorbikes){
                frame.dispose();
                Admin_Manage_Bike_Board admin_manage_bike_board = new Admin_Manage_Bike_Board();
            }
            if(e.getSource() == manage_used_vehicles){
                frame.dispose();
                Admin_Manage_Used_Vehicle_Board admin_manage_used_vehicle_board = new Admin_Manage_Used_Vehicle_Board();
            }
            if(e.getSource() == manage_test_drive){
                frame.dispose();
              Admin_Manage_Test_Drive admin_manage_test_drive = new Admin_Manage_Test_Drive();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Dashboard admin_dashboard = new Admin_Dashboard();
            }
        }
    }
}

