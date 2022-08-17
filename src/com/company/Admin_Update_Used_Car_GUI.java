package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Update_Used_Car_GUI{private JFrame frame;
    private JPanel panel;
    private JButton update_price;
    private JButton update_quantity;
    private JButton back_button;
    private JButton manage_used_vehicles;
    private JLabel main_label;

    public Admin_Update_Used_Car_GUI(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);
        main_label = new JLabel("Update Used Car Details");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(330, 30, 700, 100);

        update_price = new JButton("Update price");
        update_price.setBounds(300, 150, 450, 90);
        update_price.setBackground(Color.CYAN);
        update_price.setFont(new Font("Aerial", Font.BOLD, 30));
        update_price.addActionListener(new Handler());

        update_quantity = new JButton("Update quantity");
        update_quantity.setBounds(300, 300, 450, 90);
        update_quantity.setBackground(Color.CYAN);
        update_quantity.setFont(new Font("Aerial", Font.BOLD, 30));
        update_quantity.addActionListener(new Handler());

        back_button = new JButton("Back");
        back_button.setBounds(440, 590, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

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

            }
            if (e.getSource() == update_quantity) {
                frame.dispose();

            }
            if(e.getSource() == back_button){
                frame.dispose();

            }
        }
    }
}
