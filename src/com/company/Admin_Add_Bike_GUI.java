package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.Random;

public class Admin_Add_Bike_GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel main_label;

    private JLabel bike_model_label;
    private JLabel bike_mileage_label;
    private JLabel bike_price_label;
    private JLabel bike_company_label;
    private JLabel bike_engine_label;
    private JLabel bike_quantity_label;

    private JTextField bike_model_field;
    private JTextField bike_mileage_field;
    private JTextField bike_price_field;
    private JTextField bike_weight_field;
    private JTextField bike_engine_field;
    private JTextField bike_quantity_field;
    private JComboBox manufacturer_combo;


    private JButton add_button;
    private JButton clear_button;
    private JButton back_button;
    private String combo_default = "man1";
    private int man_id = 0;
    public Admin_Add_Bike_GUI(){
        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);
        main_label = new JLabel("Add Bike");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 30, 700, 100);

        bike_model_label = new JLabel("Model:");
        bike_model_label.setFont(new Font("", Font.BOLD, 25));
        bike_model_label.setForeground(Color.CYAN);
        bike_model_label.setBounds(230, 110, 700, 100);

        bike_model_field = new JTextField();
        bike_model_field.setBounds(400, 140, 350, 40);

        bike_company_label = new JLabel("Company:");
        bike_company_label.setFont(new Font("", Font.BOLD, 25));
        bike_company_label.setForeground(Color.CYAN);
        bike_company_label.setBounds(230, 180, 700, 100);

        bike_weight_field = new JTextField();
        bike_weight_field.setBounds(400, 210, 350, 40);

        bike_mileage_label = new JLabel("Mileage:");
        bike_mileage_label.setFont(new Font("", Font.BOLD, 25));
        bike_mileage_label.setForeground(Color.CYAN);
        bike_mileage_label.setBounds(230, 250, 700, 100);

        bike_mileage_field = new JTextField();
        bike_mileage_field.setBounds(400, 280, 350, 40);

        bike_engine_label = new JLabel("Engine:");
        bike_engine_label.setFont(new Font("", Font.BOLD, 25));
        bike_engine_label.setForeground(Color.CYAN);
        bike_engine_label.setBounds(230, 320, 700, 100);

        bike_engine_field = new JTextField();
        bike_engine_field.setBounds(400, 350, 350, 40);

        bike_price_label = new JLabel("Price:");
        bike_price_label.setFont(new Font("", Font.BOLD, 25));
        bike_price_label.setForeground(Color.CYAN);
        bike_price_label.setBounds(230, 390, 700, 100);

        bike_price_field = new JTextField();
        bike_price_field.setBounds(400, 420, 350, 40);

        bike_quantity_label = new JLabel("Quantity:");
        bike_quantity_label.setFont(new Font("", Font.BOLD, 25));
        bike_quantity_label.setForeground(Color.CYAN);
        bike_quantity_label.setBounds(230, 460, 700, 100);

        bike_quantity_field = new JTextField();
        bike_quantity_field.setBounds(400, 490, 350, 40);




        back_button = new JButton("Back");
        back_button.setBounds(100, 630, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        clear_button = new JButton("Clear");
        clear_button.setBounds(400, 630, 180, 60);
        clear_button.setBackground(Color.CYAN);
        clear_button.setFont(new Font("Aerial", Font.BOLD, 20));
        clear_button.addActionListener(new Handler());

        add_button = new JButton("Add");
        add_button.setBounds(700, 630, 180, 60);
        add_button.setBackground(Color.CYAN);
        add_button.setFont(new Font("Aerial", Font.BOLD, 20));
        add_button.addActionListener(new Handler());

        String[] manu = {"man1", "man2", "man3", "man4"};
        manufacturer_combo = new JComboBox<>(manu);
        manufacturer_combo.setBounds(800, 494, 120, 35);
        manufacturer_combo.addItemListener(e -> {
            if(e.getStateChange()== ItemEvent.SELECTED){
                combo_default = (String)e.getItem();


            }
        });

        panel.add(main_label);

        panel.add(bike_model_label);
        panel.add(bike_model_field);
        panel.add(bike_weight_field);
        panel.add(bike_company_label);
        panel.add(bike_mileage_field);
        panel.add(bike_mileage_label);
        panel.add(bike_engine_field);
        panel.add(bike_engine_label);

        panel.add(bike_price_field);
        panel.add(bike_price_label);
        panel.add(bike_quantity_field);
        panel.add(bike_quantity_label);
        panel.add(manufacturer_combo);
        panel.add(back_button);
        panel.add(clear_button);
        panel.add(add_button);
        panel.setBackground(new Color(21, 40, 51));
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    class Handler implements ActionListener {
        private int id;
        private Random random;

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean chk = true;

            String model =  bike_model_field  .getText();
            int weight = Integer.parseInt(bike_weight_field.getText());
            int mileage = Integer.parseInt(bike_mileage_field.getText());
            String engine = bike_engine_field.getText();
            int price = Integer.parseInt(bike_price_field.getText());
            int quantity = Integer.parseInt(bike_quantity_field.getText());
            random = new Random();
            id = random.nextInt(10000)+1;
            if(e.getSource() == add_button){
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                    Statement st = con.createStatement();
                    int num = 0;
                    ResultSet result = st.executeQuery("select * from manufacturer");
                    while(result.next() && !combo_default.equals(result.getString(2))){
                        num = result.getInt(1);
                    }
                    man_id = num;
                    con.close();
                }catch (Exception ex){
                }
                if(bike_model_field.getText().isEmpty() || bike_mileage_field.getText().isEmpty() || bike_price_field.getText().isEmpty() ||
                        bike_weight_field.getText().isEmpty() || bike_engine_field.getText().isEmpty() || bike_quantity_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fields should not be empty!!!");
                }
                else{
                    int ad_id = 12;

                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");

//                        Check for already added car
                        Statement st = con.createStatement();
                        ResultSet result = st.executeQuery("select * from bike");
                        while(result.next()){
                            if (id == result.getInt(1)) {
                                JOptionPane.showMessageDialog(null, "Bike already exists!!!");
                                frame.dispose();
                                Admin_Manage_Bike_Board admin_manage_bike_board = new Admin_Manage_Bike_Board();
                                chk = false;
                            }
                        }
                        if(chk){
                            String query = "insert into bike(bike_id, bike_model, weight, mileage, engine, price, quantity, manufacturer_manufacturer_id, admin_admin_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setInt(1, id);
                            pst.setString(2, model);
                            pst.setInt(3, weight);
                            pst.setInt(4, mileage);
                            pst.setString(5, engine);
                            pst.setInt(6, man_id);
                            pst.setInt(7, price);
                            pst.setInt(8, quantity);
                            pst.setInt(9, ad_id);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Bike added successful!!!");
                            con.close();
                            frame.dispose();
                            Admin_Manage_Bike_Board admin_manage_bike_board = new Admin_Manage_Bike_Board();
                        }


                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
                if(e.getSource() == clear_button){
                bike_model_field.setText("");
                bike_weight_field.setText("");
                bike_engine_field.setText("");
                bike_price_field.setText("");
                bike_mileage_field.setText("");
                bike_quantity_field.setText("");
            }
            if(e.getSource() == back_button){
                frame.dispose();
                Admin_Manage_Bike_Board admin_manage_car_board = new Admin_Manage_Bike_Board();
            }
        }
                }
}
