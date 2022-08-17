package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Test_Drive {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton view_test;

    private JButton delete_test;
    private JButton back_button;
    public Admin_Manage_Test_Drive(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Manage Test Drive");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(370, 71, 700, 100);


        view_test = new JButton("View Booked  drives");
        view_test.setBounds(300, 210, 400, 70);
        view_test.setBackground(Color.CYAN);
        view_test.setFont(new Font("Aerial", Font.BOLD, 25));
        view_test.addActionListener(new Admin_Manage_Test_Drive.Handler());

        delete_test = new JButton("Delete booked drives");
        delete_test.setBounds(300, 350, 400, 70);
        delete_test.setBackground(Color.CYAN);
        delete_test.setFont(new Font("Aerial", Font.BOLD, 25));
        delete_test.addActionListener(new Admin_Manage_Test_Drive.Handler());


        back_button = new JButton("Back");
        back_button.setBounds(410, 520, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Admin_Manage_Test_Drive.Handler());

        panel.add(main_label);
        panel.add(view_test);
        panel.add(delete_test);
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
            if(e.getSource() == view_test){
                frame.dispose();
                Admin_View_Test_Drive admin_view_test_drive = new Admin_View_Test_Drive();
            }
            if (e.getSource() == delete_test) {
                frame.dispose();
                Admin_Delete_Test_Drive admin_delete_test_drive = new Admin_Delete_Test_Drive();
            }
            if (e.getSource() == back_button) {
                frame.dispose();
                Admin_Manage_Vehicles admin_manage_vehicles = new Admin_Manage_Vehicles();
            }


        }
    }
}
