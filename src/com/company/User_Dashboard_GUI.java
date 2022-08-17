package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Dashboard_GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton vehicle_button;
    private JButton customer_button;
    private JButton sales_button;
    private JButton bookings_button;
    private JButton feedback_button;

    private JButton exchange_button;
    private JButton logout_button;

    public User_Dashboard_GUI(){

        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Vehicle Showroom Management System");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(220, 30, 700, 100);


        vehicle_button = new JButton("Book Vehicles");
        vehicle_button.setBounds(300, 130, 400, 70);
        vehicle_button.setBackground(Color.CYAN);
        vehicle_button.setFont(new Font("Aerial", Font.BOLD, 25));
        vehicle_button.addActionListener(new Handler());

        customer_button = new JButton("Exchange Cars");
        customer_button.setBounds(300, 238, 400, 70);
        customer_button.setBackground(Color.CYAN);
        customer_button.setFont(new Font("Aerial", Font.BOLD, 25));
        customer_button.addActionListener(new Handler());

        sales_button = new JButton("Manage test drive");
        sales_button.setBounds(300, 346, 400, 70);
        sales_button.setBackground(Color.CYAN);
        sales_button.setFont(new Font("Aerial", Font.BOLD, 25));
        sales_button.addActionListener(new Handler());

        bookings_button = new JButton("Manage Bookings");
        bookings_button.setBounds(300, 454, 400, 70);
        bookings_button.setBackground(Color.CYAN);
        bookings_button.setFont(new Font("Aerial", Font.BOLD, 25));
        bookings_button.addActionListener(new Handler());

        feedback_button = new JButton("Feedback");
        feedback_button.setBounds(300, 562, 400, 70);
        feedback_button.setBackground(Color.CYAN);
        feedback_button.setFont(new Font("Aerial", Font.BOLD, 25));
        feedback_button.addActionListener(new Handler());


        logout_button = new JButton("Sign Out");
        logout_button.setBounds(410, 670, 180, 60);
        logout_button.setBackground(Color.CYAN);
        logout_button.setFont(new Font("Aerial", Font.BOLD, 20));
        logout_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(customer_button);
        panel.add(vehicle_button);
        panel.add(sales_button);
        panel.add(bookings_button);
        panel.add(feedback_button);
        panel.add(logout_button);
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
            if(e.getSource() == vehicle_button){
                frame.dispose();
                User_Manage_Vehicle_Board_GUI user_manage_vehicle_board_gui = new User_Manage_Vehicle_Board_GUI();
            }
            if(e.getSource() == customer_button){
                frame.dispose();
                User_Show_Car_To_Exchange user_show_car_to_exchange = new User_Show_Car_To_Exchange();
            }
            if (e.getSource() == sales_button) {
                frame.dispose();
                User_Book_TestDrive_GUI user_book_testDrive_gui = new User_Book_TestDrive_GUI();
            }
            if(e.getSource() == bookings_button){
                frame.dispose();
                User_Booking_Board_GUI user_booking_board_gui = new User_Booking_Board_GUI();
            }

            if(e.getSource() == feedback_button){
                frame.dispose();
                User_Feedback_GUI user_feedback_gui = new User_Feedback_GUI();
            }

            if(e.getSource() == logout_button){
                JOptionPane.showMessageDialog(null, "You are signed out successfully!!!");
                frame.dispose();
                Main_DashBoard main_dashBoard = new Main_DashBoard();
            }
        }
    }

}
