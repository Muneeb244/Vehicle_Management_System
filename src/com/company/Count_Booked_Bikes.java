package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Count_Booked_Bikes {

    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;

    private JButton back_button;
    public Count_Booked_Bikes(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Booked motorbikes");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 550);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));


        back_button = new JButton("Back");
        back_button.setBounds(410, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Count_Booked_Bikes.Handler());

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
            ResultSet result = st.executeQuery("select * from cars");
            int i = 1;
            while(result.next()){
                info_area.append(i +".Model: " + result.getString(2) + "  Mileage: " + result.getString(3) + "  Engine: " + result.getString(4)
                        + "  Price: " + result.getInt(6) + "  Quantity: " + result.getInt(7) + "\n");
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
                User_Vehicle_Counter user_vehicle_counter = new User_Vehicle_Counter();
            }
        }
    }
}
