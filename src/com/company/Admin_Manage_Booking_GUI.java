package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Booking_GUI {
    private JFrame frame;
    private JPanel panel;
    private JButton view_bookings;
    private JButton deliver_car;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JLabel main_label;

    public Admin_Manage_Booking_GUI() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);
        main_label = new JLabel("Manage Bookings");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);

        view_bookings = new JButton("View Bookings");
        view_bookings.setBounds(300, 150, 450, 90);
        view_bookings.setBackground(Color.CYAN);
        view_bookings.setFont(new Font("Aerial", Font.BOLD, 30));
        view_bookings.addActionListener(new Handler());

        deliver_car = new JButton("Deliver Cars");
        deliver_car.setBounds(300, 300, 450, 90);
        deliver_car.setBackground(Color.CYAN);
        deliver_car.setFont(new Font("Aerial", Font.BOLD, 30));
        deliver_car.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(440, 590, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(view_bookings);
        panel.add(deliver_car);
        panel.add(back_button);
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
            if (e.getSource() == view_bookings) {
                frame.dispose();
                Admin_View_Bookings_GUI admin_view_bookings_gui = new Admin_View_Bookings_GUI();
            }
            if (e.getSource() == deliver_car) {
                frame.dispose();
                Admin_Deliver_Car_GUI admin_deliver_car_gui = new Admin_Deliver_Car_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Dashboard admin_dashboard = new Admin_Dashboard();
            }
        }
    }
}
