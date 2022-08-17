package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class User_Booking_Board_GUI {

    private JFrame frame;
    private JPanel panel;

    private JButton view_booking_button;
    private JButton delete_booking_button;
    private JButton counter_button;
    private JButton back_button;
    private JLabel main_label;

    public User_Booking_Board_GUI() {

        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Vehicle Showroom Management System");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(180, 60, 700, 100);

        view_booking_button = new JButton("View Bookings");
        view_booking_button.setBounds(300, 200, 400, 100);
        view_booking_button.setBackground(Color.CYAN);
        view_booking_button.setFont(new Font("Aerial", Font.BOLD, 30));
        view_booking_button.addActionListener(new Handler());

        delete_booking_button = new JButton("Delete Bookings");
        delete_booking_button.setBounds(300, 300, 400, 100);
        delete_booking_button.setBackground(Color.CYAN);
        delete_booking_button.setFont(new Font("Aerial", Font.BOLD, 30));
        delete_booking_button.addActionListener(new Handler());



        back_button = new JButton("Back");
        back_button.setBounds(410, 600, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());



        panel.setBackground(new Color(21, 40, 51));

        panel.add(main_label);
        panel.add(view_booking_button);
        panel.add(delete_booking_button);
        panel.add(back_button);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

    static void car_Shower(TextArea info_area) {
        int i = 1;
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            String query = "select booking_date, booking_type, car_model, car_mileage, car_engine, car_price, quantity, customer.user_name from cars natural join booking  join creates_booking on creates_booking.booking_booking_id = booking.booking_id AND creates_booking.customer_user_id = ? join customer on creates_booking.customer_user_id = customer.user_id";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, User_Sign_In_GUI.customer_id);
            ResultSet result = pst.executeQuery();

            while(result.next()){
                if(User_Sign_In_GUI.customer_id == result.getInt(9)) {
                    info_area.append(i + "  Booked: " + result.getString(2) + "  At: " + result.getString(1) +
                            "  Model: " + result.getString(3) + "  Mileage: " + result.getString(4) + "  Engine: " + result.getString(5) +
                            "  Price: " + result.getString(6) + "  Quantity: " + result.getInt(7) + "  Booked by: " + result.getString(8) + "\n");
                    i++;
                }
            }
            con.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            String query = "select booking_date, booking_type, car_model, car_mileage, car_engine, car_price, quantity, customer.user_name, customer.user_id from cars natural join booking  join creates_booking on creates_booking.booking_booking_id = booking.booking_id AND creates_booking.customer_user_id = ? join customer on creates_booking.customer_user_id = customer.user_id";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, User_Sign_In_GUI.customer_id);
            ResultSet result = pst.executeQuery();
//            int i = 1;
            while(result.next()){
                if(User_Sign_In_GUI.customer_id == result.getInt(9)) {
                    info_area.append(i + "  Booked: " + result.getString(2) + "  At: " + result.getString(1) +
                            "  Model: " + result.getString(3) + "  Mileage: " + result.getString(4) + "  Engine: " + result.getString(5) +
                            "  Price: " + result.getString(6) + "  Quantity: " + result.getInt(7) + "  Booked by: " + result.getString(8) + "\n");
                    i++;
                }
            }
            con.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == back_button){
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
            if(e.getSource() == view_booking_button){
                frame.dispose();
                User_View_Bookings_GUI user_view_bookings_gui = new User_View_Bookings_GUI();
            }
            if(e.getSource() == counter_button){
                frame.dispose();
                User_Vehicle_Counter user_vehicle_counter = new User_Vehicle_Counter();
            }
            if (e.getSource() == delete_booking_button) {
                System.out.println("User deleting booking");
                frame.dispose();
                User_Delete_Booking_GUI user_delete_booking_gui = new User_Delete_Booking_GUI();
            }
        }
    }

}
