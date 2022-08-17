package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Admin_Deliver_Car_GUI {
    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel deliver_label;
    private JTextField delete_field;

    private JButton deliver_button;
    private JButton back_button;

    public Admin_Deliver_Car_GUI() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Deliver Cars");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 470);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        delete_field = new JTextField();
        delete_field.setBounds(700, 628, 100, 30);

        deliver_label = new JLabel("Enter Serial number of car you want to Deliver: ");
        deliver_label.setFont(new Font("", Font.BOLD, 25));
        deliver_label.setForeground(Color.CYAN);
        deliver_label.setBounds(130, 590, 700, 100);

        back_button = new JButton("Back");
        back_button.setBounds(290, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        deliver_button = new JButton("Deliver");
        deliver_button.setBounds(530, 685, 180, 60);
        deliver_button.setBackground(Color.CYAN);
        deliver_button.setFont(new Font("Aerial", Font.BOLD, 20));
        deliver_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(info_area);
        panel.add(back_button);
        panel.add(deliver_button);
        panel.add(delete_field);
        panel.add(deliver_label);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Admin_View_Bookings_GUI.car_Shower(info_area);
    }

    private int getQuantity(){
        try{
            int temp = 0;
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from sales_record");
            while(result.next()){
                temp = result.getInt(4);
            }
            con.close();
            System.out.println("From MEthod " + temp);
            return temp;
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return 0;
    }

    private int getPrice(){
        try{
            int temp = 0;
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from sales_record");
            while(result.next()){
                temp = result.getInt(6);
            }

            con.close();
            System.out.println("From MEthod " + temp);
            return temp;
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return 0;
    }

    public void sales_record(int car_id, String sales_date, int cost, int quantity, int new_cost, int new_quantity){

        System.out.println(new_cost + " new cost");
        System.out.println(new_quantity + " quantity");
        System.out.println("Before updation\n");
        new_cost += cost;
        new_quantity += quantity;

        System.out.println(cost + " old cost");
        System.out.println(quantity + " quantity");

        System.out.println(new_quantity);
        System.out.println(new_cost);


        Random random = new Random();
        int id = random.nextInt(10000)+1;

        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            String query = "insert into sales_record(PRODUCT_ID, SALES_DATE, COST_OF_PRODUCT, TOTAL_SOLD, ADMIN_ADMIN_ID, TOTAL_AMOUNT, QUANTITY_OF_PRODUCT, RECORD_ID) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, car_id);
            pst.setString(2, sales_date);
            pst.setInt(3, cost);
            pst.setInt(4, new_quantity);
            pst.setInt(5, 12);
            pst.setInt(6, new_cost);
            pst.setInt(7, quantity);
            pst.setInt(8, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record added successful!!!");
            con.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }


    public void record(int booking_id){
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from booking");
            while(result.next() && result.getInt(1) != booking_id){
            }
            sales_record(result.getInt(5), result.getString(2), result.getInt(8), result.getInt(4), getPrice(), getQuantity());
            con.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            if(e.getSource() == deliver_button){
                int car_id = 0;

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
                            ResultSet result = st.executeQuery("select * from booking");
                            while(result.next()){
                                arrayList.add(result.getInt(1));
                            }
                            if(serial <= arrayList.size()) {
                                car_id = arrayList.get(serial - 1);
                                record(car_id);
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
                            pst.setString(1, String.valueOf(car_id));
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
                                pst.setString(1, String.valueOf(car_id));
                                pst.executeUpdate();

                                frame.dispose();
                                Admin_Dashboard admin_dashboard = new Admin_Dashboard();
                            } catch (Exception ex) {
                                System.out.println(ex.toString());
                            }
                        }
                    }
                }

            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Booking_GUI admin_manage_booking_gui = new Admin_Manage_Booking_GUI();
            }
        }
    }
}
