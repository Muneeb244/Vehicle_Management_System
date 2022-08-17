package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Admin_Delete_Bike_GUI {
    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel delete_label;
    private JTextField delete_field;

    private JButton delete_button;
    private JButton back_button;

    public Admin_Delete_Bike_GUI(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Delete Bikes");
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

        delete_label = new JLabel("Enter Serial number of bike you want to delete: ");
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
    }
    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(e.getSource() == delete_button){
                int bike_id = 0;

                if(delete_field.getText().isEmpty()){
                    System.out.println("Field should be empty!!!");
                }
                else{
                    Connection con = null;
                    boolean chk = true;
                    try{
                        int serial = Integer.parseInt(delete_field.getText());
                        try {
                            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                            Statement st = con.createStatement();
                            ResultSet result = st.executeQuery("select * from bike");
                            while(result.next()){
                                arrayList.add(result.getInt(1));
                            }
                            if(serial <= arrayList.size()) {
                                bike_id = arrayList.get(serial - 1);
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
                    if(chk) {
                        try {
                            String query = "delete from bike where bike_id = ?";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1, String.valueOf(bike_id));
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Bike deleted!!!");
                            frame.dispose();
                            Admin_Manage_Car_Board admin_manage_car_board = new Admin_Manage_Car_Board();
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                }
            }

            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Bike_Board admin_manage_bike_board = new Admin_Manage_Bike_Board();

            }
        }
    }
}
