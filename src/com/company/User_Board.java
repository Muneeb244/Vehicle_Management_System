package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class User_Board {
    private JFrame frame;
    private JPanel panel;

    private JButton signIn_button;
    private JButton signUp_button;
    private JButton back_button;
    private JLabel main_label;
    public User_Board(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Vehicle Showroom Management System");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(180, 60, 700, 100);

        signIn_button = new JButton("Sign In");
        signIn_button.setBounds(300, 200, 400, 100);
        signIn_button.setBackground(Color.CYAN);
        signIn_button.setFont(new Font("Aerial", Font.BOLD, 30));
        signIn_button.addActionListener(new Handler());

        signUp_button = new JButton("Sign Up");
        signUp_button.setBounds(300, 400, 400, 100);
        signUp_button.setBackground(Color.CYAN);
        signUp_button.setFont(new Font("Aerial", Font.BOLD, 30));
        signUp_button.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(410, 600, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());



        panel.setBackground(new Color(21, 40, 51));

        panel.add(main_label);
        panel.add(signIn_button);
        panel.add(signUp_button);
        panel.add(back_button);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

//    static void id_saver(){
//        try{
//            ArrayList<Integer> bookings_ids = new ArrayList<>();
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
//            Statement st = con.createStatement();
//            ResultSet result = st.executeQuery("select booking_booking_id from booking");
//            int i = 1;
//            while(result.next()){
//
//                User_Sign_In_GUI
//
//                info_area.append(i + "  Booked: " + result.getString(2) +  "  At: " + result.getString(1) +
//                        "  Model: " + result.getString(3) + "  Mileage: " + result.getString(4) + "  Engine: " + result.getString(5) +
//                        "  Price: " + result.getString(6) + "  Quantity: " + result.getInt(7)  + "  Booked by: " + result.getString(8) + "\n");
//                i++;
//            }
//            con.close();
//        }catch (Exception ex){
//            System.out.println(ex.toString());
//        }
//    }

    static void car_Shower(TextArea info_area) {
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            String query = "select booking_date, booking_type, car_model, car_mileage, car_engine, car_price, quantity, customer.user_name from cars natural join booking  join creates_booking on creates_booking.booking_booking_id = booking.booking_id AND creates_booking.customer_user_id = ? join customer on creates_booking.customer_user_id = customer.user_id";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, User_Sign_In_GUI.customer_id);
            ResultSet result = pst.executeQuery(query);
            int i = 1;
            while(result.next()){
                info_area.append(i + "  Booked: " + result.getString(2) +  "  At: " + result.getString(1) +
                        "  Model: " + result.getString(3) + "  Mileage: " + result.getString(4) + "  Engine: " + result.getString(5) +
                        "  Price: " + result.getString(6) + "  Quantity: " + result.getInt(7)  + "  Booked by: " + result.getString(8) + "\n");
                i++;
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
                Main_DashBoard main_dashBoard = new Main_DashBoard();
            }
            if(e.getSource() == signIn_button){
                frame.dispose();
                User_Sign_In_GUI userSign_in_gui = new User_Sign_In_GUI();
            }
            if (e.getSource() == signUp_button) {
                frame.dispose();
                User_Sign_Up_GUI user_sign_up_gui = new User_Sign_Up_GUI();
            }
        }
    }
}
