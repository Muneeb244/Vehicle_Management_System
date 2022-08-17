package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin_View_Used_Car_GUI {
    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;

    private JButton back_button;

    public Admin_View_Used_Car_GUI(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("View Used Cars");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(400, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 550);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));


        back_button = new JButton("Back");
        back_button.setBounds(410, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        panel.add(main_label);
        panel.add(info_area);
        panel.add(back_button);
        panel.add(back_button);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        show();
    }
    public void show(){
        Update(info_area);
    }

    static void Update(TextArea info_area) {
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from used_vehicles");
            int i = 1;
            while(result.next()){
                info_area.append(i +"Model: " + result.getString(2) + "  Seats: " + result.getInt(3) + "  Mileage: " + result.getInt(4)
                            + "  Engine: " + result.getString(5) + "  Price: " + result.getInt(7) + "\n");
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
                Admin_Manage_Used_Vehicle_Board admin_manage_car_board = new Admin_Manage_Used_Vehicle_Board();
            }
        }
    }
}
