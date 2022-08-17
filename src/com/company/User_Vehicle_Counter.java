package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Vehicle_Counter {

    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton addcar_button;
    private JButton updatecar_button;
    private JButton viewcar_button;
    private JButton deletecar_button;
    private JButton back_button;

    public User_Vehicle_Counter(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Count Vehicles");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 30, 700, 100);


        addcar_button = new JButton("Count booked cars");
        addcar_button.setBounds(300, 130, 450, 90);
        addcar_button.setBackground(Color.CYAN);
        addcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        addcar_button.addActionListener(new User_Vehicle_Counter.Handler());

        updatecar_button = new JButton("Count booked bikes");
        updatecar_button.setBounds(300, 270, 450, 90);
        updatecar_button.setBackground(Color.CYAN);
        updatecar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        updatecar_button.addActionListener(new User_Vehicle_Counter.Handler());

        viewcar_button = new JButton("Count booked used_cars");
        viewcar_button.setBounds(300, 420, 450, 90);
        viewcar_button.setBackground(Color.CYAN);
        viewcar_button.setFont(new Font("Aerial", Font.BOLD, 25));
        viewcar_button.addActionListener(new User_Vehicle_Counter.Handler());


        back_button = new JButton("Back");
        back_button.setBounds(435, 575, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new User_Vehicle_Counter.Handler());

        panel.add(main_label);
        panel.add(addcar_button);
        panel.add(updatecar_button);
        panel.add(viewcar_button);
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
                Count_booked_cars count_booked_cars = new Count_booked_cars();
            }
            if(e.getSource() == updatecar_button){
                frame.dispose();
                Count_Booked_Bikes count_booked_bikes = new Count_Booked_Bikes();
            }
            if (e.getSource() == viewcar_button) {
                frame.dispose();
                User_Vehicle_Counter user_vehicle_counter = new User_Vehicle_Counter();
            }

            if(e.getSource() == back_button){
                frame.dispose();
                User_Booking_Board_GUI user_booking_board_gui = new User_Booking_Board_GUI();

            }
        }
    }
}
