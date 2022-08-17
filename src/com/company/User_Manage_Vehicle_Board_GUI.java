package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Manage_Vehicle_Board_GUI {

    private JFrame frame;
    private JPanel panel;
    private JButton manage_cars;
    private JButton manage_motorbikes;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JButton  manage_test_drive;
    private JButton  sale_vehicles;
    private JLabel main_label;

    public User_Manage_Vehicle_Board_GUI() {
        frame = new JFrame("Manage Vehicles");
        panel = new JPanel(null);
        main_label = new JLabel("Manage Vehicles");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);

        //Manage cars
        manage_cars = new JButton("Book Cars");
        manage_cars.setBounds(300, 150, 400, 70);
        manage_cars.setBackground(Color.CYAN);
        manage_cars.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_cars.addActionListener(new Handler());

        //Manage_Motorbikes
        manage_motorbikes = new JButton("Book Motorbikes");
        manage_motorbikes.setBounds(300, 250, 400, 70);
        manage_motorbikes.setBackground(Color.CYAN);
        manage_motorbikes.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_motorbikes.addActionListener(new Handler());

        // Manage used
        manage_used_vehicles = new JButton("Book Used cars");
        manage_used_vehicles.setBounds(300, 350, 400, 70);
        manage_used_vehicles.setBackground(Color.CYAN);
        manage_used_vehicles.setFont(new Font("Aerial", Font.BOLD, 30));
        manage_used_vehicles.addActionListener(new Handler());

        sale_vehicles = new JButton("Book Cars on sale");
        sale_vehicles.setBounds(300, 450, 400, 70);
        sale_vehicles.setBackground(Color.CYAN);
        sale_vehicles.setFont(new Font("Aerial", Font.BOLD, 30));
        sale_vehicles.addActionListener(new Handler());




        // Manage Test Drive

        back_button = new JButton("Back");
        back_button.setBounds(400, 560, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(manage_cars);
        panel.add(manage_used_vehicles);
        panel.add(manage_motorbikes);
        panel.add(back_button);
        panel.add(manage_used_vehicles);
        panel.add(sale_vehicles);
        panel.add(main_label);
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
            if(e.getSource() == manage_cars){
                frame.dispose();
                User_Book_Car_GUI user_book_car_gui = new User_Book_Car_GUI();
            }
            if(e.getSource() == manage_motorbikes){
                frame.dispose();
                User_Book_Bike_GUI user_book_bike_gui = new User_Book_Bike_GUI();
            }
            if(e.getSource() == manage_used_vehicles){
                frame.dispose();
            }

            if(e.getSource() == sale_vehicles){
                frame.dispose();
                User_Vehicle_Sales_GUI user_vehicle_sales_gui = new User_Vehicle_Sales_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
        }
    }

}
