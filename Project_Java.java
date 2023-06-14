package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Project_Java {
    public static void main(String[] args) {
        JFrame j = new JFrame("Admission Form");
        JPanel p = new JPanel();
        JLabel name = new JLabel("Name of Student");
        JTextField t = new JTextField();
        JLabel Father = new JLabel("Father Name");
        JTextField t1 = new JTextField();
        JLabel mother = new JLabel("Mother Name");
        JTextField t2 = new JTextField();
        JLabel cl = new JLabel("Which class you want to take admission");
        JTextField t3 = new JTextField();
        JLabel percentage = new JLabel("Percentage in Rounded Figures");
        JTextField t4 = new JTextField();
        JLabel l5 = new JLabel("Do you want to choose Boarding Yes/No");
        JTextField t5 = new JTextField();
        Button b = new Button("Submit");
        name.setBounds(20,40,100,30);
        Father.setBounds(20,80,100,30);
        mother.setBounds(20,120,100,30);
        cl.setBounds(20,160,140,30);
        percentage.setBounds(20,200,140,30);
        l5.setBounds(20,240,140,30);
        t.setBounds(200,40,90,30);
        t1.setBounds(200,80,90,30);
        t2.setBounds(200,120,90,30);
        t3.setBounds(200,160,90,30);
        t4.setBounds(200,200,90,30);
        t5.setBounds(200,240,90,30);
        b.setBounds(120,280,90,30);
        p.add(b);
        p.add(name);
        p.add(Father);
        p.add(mother);
        p.add(cl);
        p.add(percentage);
        p.add(l5);
        p.add(t);
        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);
        p.add(t5);

        p.setSize(600,600);
        p.setLayout(null);
        p.setVisible(true);
        j.add(p);
        j.setSize(600,600);
        j.setLayout(null);
        j.setVisible(true);
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "Sparsh@VIT2020";

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection(url,username,password);
                    String name = t.getText().toString();
                    String father = t1.getText().toString();
                    String mother = t2.getText().toString();
                    int cl = Integer.parseInt(t3.getText().toString());
                    int per = Integer.parseInt(t4.getText().toString());
                    String boarding = t5.getText().toString();
                    String query = "INSERT INTO info (name, father, mother, class, percentage, boarding) values (?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = c.prepareStatement(query);
                    st.setString(1, name);
                    st.setString(2,father);
                    st.setString(3,mother);
                    st.setInt(4,cl);
                    st.setInt(5,per);
                    st.setString(6,boarding);
                    st.executeUpdate();
                    System.out.println(query);
                }catch (Exception t){
                    System.out.println(t);
                }
            }
        });
    }
}
