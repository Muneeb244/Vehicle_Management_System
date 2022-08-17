package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class User_Book_TestDrive_GUI {

    private JFrame frame;
    private JPanel panel;

    private JLabel main_label;
    private TextArea info_area;
    private JLabel delete_label;
    private JTextField delete_field;

    private JButton delete_button;
    private JButton back_button;

    public User_Book_TestDrive_GUI() {

        frame = new JFrame("Vehicle Showroom Management System");
        panel = new JPanel(null);

        main_label = new JLabel("Book Test Drive");
        main_label.setFont(new Font("Serif", Font.BOLD, 35));
        main_label.setForeground(Color.CYAN);
        main_label.setBounds(430, 20, 700, 100);

        info_area = new TextArea();
        info_area.setBounds(0, 120, 1000, 470);
        info_area.setBackground(new Color(21, 40, 51));
        info_area.setForeground(Color.CYAN);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        delete_field = new JTextField();
        delete_field.setBounds(740, 628, 100, 30);

        delete_label = new JLabel("Enter Serial number of test drive you want to Book: ");
        delete_label.setFont(new Font("", Font.BOLD, 25));
        delete_label.setForeground(Color.CYAN);
        delete_label.setBounds(100, 590, 700, 100);

        back_button = new JButton("Back");
        back_button.setBounds(290, 685, 180, 60);
        back_button.setBackground(Color.CYAN);
        back_button.setFont(new Font("Aerial", Font.BOLD, 20));
        back_button.addActionListener(new Handler());

        delete_button = new JButton("Book");
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
        Admin_View_Car_GUI.Update(info_area);


    }

    private String dateUpdation(String date) throws ParseException {
        System.out.println(date + " date");

        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 2);  // number of days to add
        dt = sdf.format(c.getTime());
        return dt;

    }

    private int getID(){
        try{
            int temp = 0;
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select * from cars");
            while(result.next()){
                temp = result.getInt(1);
            }

            con.close();
            return temp;
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return 0;
    }

    class Handler implements ActionListener {
        private int id;
        private Random random;

        @Override
        public void actionPerformed(ActionEvent e) {
            random = new Random();
            id = random.nextInt(10000)+1;



            if(e.getSource() == back_button) {
                frame.dispose();
                User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();
            }
            if(e.getSource() == delete_button){

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String date_drive = dtf.format(now);

                if(delete_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fields should not be empty!!!");
                }
                else{

                    try {
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Muneeb","you");
                        String query = "insert into test_drive(TEST_ID, DRIVE_DATE, cars_car_id, customer_user_id, drive_deadline) values(?, ?, ?, ?, ?)";
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setInt(1, id);
                        pst.setString(2, date_drive);
                        pst.setInt(3, getID());
                        pst.setInt(4, 7061);
                        pst.setString(5, dateUpdation(date_drive));
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Test Drive added successful!!!\n");
                        con.close();
                            frame.dispose();
                            User_Dashboard_GUI user_dashboard_gui = new User_Dashboard_GUI();


                    } catch (Exception ex) {
                        System.out.println("masla");
                        System.out.println(ex.toString());
                    }
                }

            }
        }
    }

}
