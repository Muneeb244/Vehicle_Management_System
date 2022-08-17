package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpadteMotorbikesGUI {

    private JFrame frame;
    private JPanel panel;
    private JButton update_price;
    private JButton update_quantity;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JLabel main_label;

    public UpadteMotorbikesGUI() {
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);
        main_label = new JLabel("Update Bike details");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);

        update_price = new JButton("Update  price");
        update_price.setBounds(300, 150, 450, 90);
        update_price.setBackground(Color.CYAN);
        update_price.setFont(new Font("Aerial", Font.BOLD, 30));
        update_price.addActionListener(new UpadteMotorbikesGUI.Handler());

        update_quantity = new JButton("Update quantity");
        update_quantity.setBounds(300, 300, 450, 90);
        update_quantity.setBackground(Color.CYAN);
        update_quantity.setFont(new Font("Aerial", Font.BOLD, 30));
        update_quantity.addActionListener(new UpadteMotorbikesGUI.Handler());

        back_button = new JButton("Back");
        back_button.setBounds(450, 590, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new UpadteMotorbikesGUI.Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(update_price);
        panel.add(update_quantity);
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

            if (e.getSource() == update_price) {
                frame.dispose();
                BikeAddNewPriceGUI carprice = new BikeAddNewPriceGUI();
            }
            if (e.getSource() == update_quantity) {
                frame.dispose();
                AddBikeQuantityGUI g = new AddBikeQuantityGUI();
            }
            if (e.getSource() == back_button) {
                frame.dispose();
                Admin_Manage_Bike_Board manage_bike_board = new Admin_Manage_Bike_Board();
            }
        }
    }
}


