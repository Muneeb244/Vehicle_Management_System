package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CarAddNewQuantityGUI {
    private  JFrame frame;
    private JPanel panel;
    private JLabel main_label;
    private JButton back_button;
    private JButton  update_button;
    private JLabel update_price_label;

    private JTextField update_quantity;
    public CarAddNewQuantityGUI() {
        frame = new JFrame("Update car  quantity");
        panel = new JPanel(null);
        main_label = new JLabel("Update car quantity");
        main_label.setFont(new Font("Serif", Font.BOLD, 45));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(350, 30, 700, 100);


        update_quantity = new JTextField();
        update_quantity.setBounds(310, 250, 450, 40);

        update_price_label = new JLabel("Add new quantity:");
        update_price_label.setFont(new Font("Aerial", Font.BOLD, 30));
        update_price_label.setForeground(Color.CYAN);
        update_price_label.setBounds(390, 160, 300, 100);

        back_button = new JButton("Back");
        back_button.setBounds(300, 590, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new CarAddNewQuantityGUI.Handler());

        update_button = new JButton("Update");
        update_button.setBounds(550, 590, 180, 60);
        update_button.setBackground(Color.CYAN);
        update_button.setFont(new Font("Aerial", Font.BOLD, 20));
        update_button.addActionListener(new CarAddNewQuantityGUI.Handler());

        panel.setBackground(new Color(21, 40, 51));
        panel.add(main_label);
        panel.add(update_quantity);
        panel.add(update_price_label);
        panel.add(update_button);
        panel.add(back_button);
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

            if(e.getSource() == update_button){

                try {
                    int temp = Integer.parseInt(update_quantity.getText());

                    if (update_quantity.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fields should not be empty!!!");
                        update_quantity.setText("");
                    } else {
                        try {
                            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Muneeb", "you");
                            Statement st = con.createStatement();

                            String query = "update cars set car_quantity = ? where car_id = ?";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setInt(1, Integer.parseInt(update_quantity.getText()));
                            pst.setInt(2, Admin_Update_Select_Car_Gui.car_id);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Quantity updated!!!");
                            frame.dispose();
                            Admin_Manage_Car_Board admin_manage_car_board = new Admin_Manage_Car_Board();
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                    }
                }
                catch (Exception v){
                    System.out.println("Enter valid Integer!!!");
                }

            }
            if (e.getSource() == back_button) {
                frame.dispose();
                Admin_Update_Car_GUI up = new Admin_Update_Car_GUI();
            }
        }
    }
}