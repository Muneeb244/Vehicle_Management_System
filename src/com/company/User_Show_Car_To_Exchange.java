package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class User_Show_Car_To_Exchange {

    private static int car_id = 0;

    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel delete_label;
    private JTextField delete_field;

    private JButton select_button;
    private JButton back_button;
    public User_Show_Car_To_Exchange() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Cars to Exchange");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(400, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 470);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        delete_field = new JTextField();
        delete_field.setBounds(700, 628, 100, 30);

        delete_label = new JLabel("Enter Serial number of car you want to Exchange: ");
        delete_label.setFont(new Font("", Font.BOLD, 25));
        delete_label.setForeground(Color.CYAN);
        delete_label.setBounds(100, 590, 700, 100);

        back_button = new JButton("Back");
        back_button.setBounds(290, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        select_button = new JButton("Select");
        select_button.setBounds(530, 685, 180, 60);
        select_button.setBackground(Color.CYAN);
        select_button.setFont(new Font("Aerial", Font.BOLD, 20));
        select_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(info_area);
        panel.add(back_button);
        panel.add(select_button);
        panel.add(delete_field);
        panel.add(delete_label);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Admin_View_Exchange_Car.Update(info_area);
    }

    public static int getCar_id() {
        return car_id;
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            if(e.getSource() == select_button){
                car_id = 0;

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
                            ResultSet result = st.executeQuery("select * from admin_vehicles");
                            while(result.next()){
                                arrayList.add(result.getInt(1));
                            }
                            if(serial <= arrayList.size()) {
                                car_id = arrayList.get(serial - 1);
                                frame.dispose();
                                User_Exchange_Car_Gui user_exchange_car_gui = new User_Exchange_Car_Gui();
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
                }
            }

            if(e.getSource() == back_button){
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
        }
    }

}
