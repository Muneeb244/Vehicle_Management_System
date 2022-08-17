package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Manage_Customer_Board {
    private JFrame frame;
    private JPanel panel;
    private JButton view_customer;
    private JButton delete_customer;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JLabel main_label;

    public Admin_Manage_Customer_Board() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);
        main_label = new JLabel("Manage Customers");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);

        view_customer = new JButton("View Customers");
        view_customer.setBounds(300, 150, 450, 90);
        view_customer.setBackground(Color.CYAN);
        view_customer.setFont(new Font("Aerial", Font.BOLD, 30));
        view_customer.addActionListener(new Admin_Manage_Customer_Board.Handler());

        delete_customer = new JButton("Delete Customers");
        delete_customer.setBounds(300, 300, 450, 90);
        delete_customer.setBackground(Color.CYAN);
        delete_customer.setFont(new Font("Aerial", Font.BOLD, 30));
        delete_customer.addActionListener(new Admin_Manage_Customer_Board.Handler());

        back_button = new JButton("Back");
        back_button.setBounds(440, 590, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Admin_Manage_Customer_Board.Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(view_customer);
        panel.add(delete_customer);
        panel.add(back_button);
        panel.add(main_label);
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
            if (e.getSource() == view_customer) {
                frame.dispose();
                Admin_View_Customer_GUI admin_view_customer_gui = new Admin_View_Customer_GUI();
            }
            if (e.getSource() == delete_customer) {
                frame.dispose();
                Admin_Delete_Customer_GUI admin_delete_customer_gui = new Admin_Delete_Customer_GUI();
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Dashboard admin_dashboard = new Admin_Dashboard();
            }

        }
    }
}


