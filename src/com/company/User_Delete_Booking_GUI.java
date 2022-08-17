package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class User_Delete_Booking_GUI {

    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel delete_label;
    private JTextField delete_field;

    private JButton delete_button;
    private JButton back_button;

    public User_Delete_Booking_GUI() {

        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Delete Booking");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 470);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        delete_field = new JTextField();
        delete_field.setBounds(730, 628, 100, 30);

        delete_label = new JLabel("Enter Serial number of booking you want to delete: ");
        delete_label.setFont(new Font("", Font.BOLD, 25));
        delete_label.setForeground(Color.CYAN);
        delete_label.setBounds(130, 590, 700, 100);

        back_button = new JButton("Back");
        back_button.setBounds(290, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        delete_button = new JButton("Delete");
        delete_button.setBounds(530, 685, 180, 60);
        delete_button.setBackground(Color.CYAN);
        delete_button.setFont(new Font("Aerial", Font.BOLD, 20));
        delete_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(info_area);
        panel.add(back_button);
        panel.add(delete_button);
        panel.add(delete_field);
        panel.add(delete_label);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        User_Booking_Board_GUI.car_Shower(info_area);

    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            if(e.getSource() == delete_button){
                int booking_id = 0;

                if(delete_field.getText().isEmpty()){
                    System.out.println("Field should not be empty!!!");
                }
                else{
                    Connection con = null;
                    boolean chk = true;
                    try{
                        int serial = Integer.parseInt(delete_field.getText());
                        try {
                            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                            Statement st = con.createStatement();
//                            ResultSet result = st.executeQuery("select * from booking");
                            String query = "select customer.user_id, booking.booking_id from cars natural join booking  join creates_booking on creates_booking.booking_booking_id = booking.booking_id AND creates_booking.customer_user_id = ? join customer on creates_booking.customer_user_id = customer.user_id";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setInt(1, User_Sign_In_GUI.customer_id);
                            ResultSet result = pst.executeQuery();
                            while(result.next()){
                                if(User_Sign_In_GUI.customer_id == result.getInt(1)){
                                    arrayList.add(result.getInt(2));
                                }
                            }
                            if(serial <= arrayList.size()) {
                                booking_id = arrayList.get(serial - 1);
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                        if(serial > arrayList.size()){
                            JOptionPane.showMessageDialog(null, "Booking not found!!!");
                            chk = false;
                            delete_field.setText("");
                        }
                    }catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Enter valid Integer!!!");
                        delete_field.setText("");
                    }

                    boolean child = false;

                    if(chk) {


                        try{
                            String query = "delete from creates_booking where booking_booking_id = ?";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1, String.valueOf(booking_id));
                            pst.executeUpdate();
                            child = true;
                        }
                        catch (Exception p){
                            System.out.println(p.toString());
                        }




                        if(child) {
                            try {
                                String query = "delete from booking where booking_id = ?";
                                PreparedStatement pst = con.prepareStatement(query);
                                pst.setString(1, String.valueOf(booking_id));
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Booking deleted!!!");
                                child = true;
                                frame.dispose();
                                User_Booking_Board_GUI user_booking_board_gui = new User_Booking_Board_GUI();
                            } catch (Exception ex) {
                                System.out.println(ex.toString());
                            }
                        }
                    }
                }
            }
            if(e.getSource() == back_button){
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
        }
    }

}
