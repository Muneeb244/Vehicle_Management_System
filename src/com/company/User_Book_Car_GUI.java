package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class User_Book_Car_GUI {

    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel delete_label;
    private JTextField delete_field;

    private JButton book_button;
    private JButton back_button;

    private JComboBox quantity_combo;
    private String combo_default = "1";
    static int book_id = 0;
    static int price = 0;

    public User_Book_Car_GUI() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Book Cars");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 470);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        delete_field = new JTextField();
        delete_field.setBounds(630, 628, 100, 30);

        delete_label = new JLabel("Enter Serial number of car you want to Book: ");
        delete_label.setFont(new Font("", Font.BOLD, 25));
        delete_label.setForeground(Color.CYAN);
        delete_label.setBounds(80, 590, 700, 100);

        back_button = new JButton("Back");
        back_button.setBounds(290, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        book_button = new JButton("Book");
        book_button.setBounds(530, 685, 180, 60);
        book_button.setBackground(Color.CYAN);
        book_button.setFont(new Font("Aerial", Font.BOLD, 20));
        book_button.addActionListener(new Handler());

        String[] manu = {"1", "2", "3"};
        quantity_combo = new JComboBox<>(manu);
        quantity_combo.setBounds(800, 628, 100, 35);
        quantity_combo.addItemListener(e -> {
            if(e.getStateChange()== ItemEvent.SELECTED){
                combo_default = (String)e.getItem();
            }
        });

        panel.add(quantity_combo);
        panel.add(main_label);
        panel.add(info_area);
        panel.add(back_button);
        panel.add(book_button);
        panel.add(delete_field);
        panel.add(delete_label);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        quantity_car();
    }

    public void quantity_car(){

        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from cars");
            int i = 1;
            while(result.next() && result.getInt(7) > 0){
                info_area.append(i +". Model: " + result.getString(2) + "  Mileage: " + result.getString(3) + "  Engine: " + result.getString(4)
                        + "  Seater: " + result.getInt(9) + "  Price: " + result.getInt(6) + "  Quantity: " + result.getInt(7) + "\n");
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

            ArrayList<Integer> arrayList = new ArrayList<>();
            if(e.getSource() == book_button){

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);

                int car_id = 0;

                if(delete_field.getText().isEmpty()){
                    System.out.println("Field should not be empty!!!");
                }
                else{
                    Connection con;
                    boolean chk = true;
                    try{
                        int serial = Integer.parseInt(delete_field.getText());
                        try {
                            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                            Statement st = con.createStatement();
                            ResultSet result = st.executeQuery("select * from cars");
                            while(result.next()){
                                arrayList.add(result.getInt(1));
                            }
                            if(serial <= arrayList.size()) {
                                car_id = arrayList.get(serial - 1);
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                        if(serial > arrayList.size()){
                            JOptionPane.showMessageDialog(null, "Car not found!!!");
                            chk = false;
                            delete_field.setText("");
                        }
                    }catch (Exception z){
                        JOptionPane.showMessageDialog(null, "Enter valid Integer!!!");
                        delete_field.setText("");
                    }


                    if(chk){
                        Random random = new Random();
                        book_id = random.nextInt(10000)+1;
                        price = 0;

                        boolean quan = true;
                        boolean q = true;
                        Connection con1 = null;
                        try {
                            con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Muneeb", "you");
                            Statement st = con1.createStatement();
                            ResultSet result = st.executeQuery("select * from cars");
                            int i = 1;
                            while (result.next() && result.getInt(1) != car_id) {
                            }
                            int quantity = result.getInt(7);
                            int quan_selected = Integer.parseInt(combo_default);
                            int quan_result = quantity-quan_selected;
                            price = result.getInt(6);


                            if(quan_selected > quantity){
                                JOptionPane.showMessageDialog(null, "Quantity not available!!!");
                            }
                            else {
                                String query = "update cars set car_quantity = ? where car_id = ?";
                                PreparedStatement pst = con1.prepareStatement(query);
                                pst.setInt(1, quan_result);
                                pst.setString(2, String.valueOf(car_id));
                                quan = false;
                                pst.executeUpdate();
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }



                        if(quan){
                            JOptionPane.showMessageDialog(null, "Error booking car!!!");
                        }
                        else{
                            try {
                                String query = "insert into booking(BOOKING_ID, BOOKING_DATE, BOOKING_TYPE, quantity, CAR_ID, price) values(?, ?, ?, ?, ?, ?)";
                                PreparedStatement pst = con1.prepareStatement(query);
                                pst.setInt(1, book_id);
                                pst.setString(2, date);
                                pst.setString(3, "car");
                                pst.setInt(4, Integer.parseInt(combo_default));
                                pst.setInt(5, car_id);
                                pst.setInt(6, price*Integer.parseInt(combo_default));
                                pst.executeUpdate();

                                String relation_query = "insert into creates_booking(customer_user_id, booking_booking_id) values(?, ?)";
                                PreparedStatement pst1 = con1.prepareStatement(relation_query);
                                pst1.setInt(1, User_Sign_In_GUI.user_id);
                                pst1.setInt(2, book_id);
                                pst1.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Car Booked!!! Your Bill is: " + price*Integer.parseInt(combo_default));
                                con1.close();
                                frame.dispose();
                                User_Payment_GUI user_payment_gui = new User_Payment_GUI();
                            }
                            catch (Exception o){
                                System.out.println(o.toString());
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
