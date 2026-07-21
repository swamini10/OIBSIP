package com.reservationsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/reservation_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root@123";

    public static Connection getConnection() {
        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database Connected Successfully");
            return con;

        } catch (SQLException e) {

            System.out.println("❌ Connection Failed");
            e.printStackTrace();
            return null;

        }

    }

}

/*
 private ka use kele -> encapulation it use only with in class we can not access it outside the class
 final key word ka use kele -> one time assign and aslo we cannot change it value  if value fix
 method static ka banvali ahe -> object creat karychi garj padnar nahi apn direct class name ne call karu shakato
 (localhost:3306/reservation_db) ya made localhost kay ahe ni 3306 kay ahe  ->  localhost meas local machine ani 3306 he mysql cha port no ahe
Why JFrame?	Window
Why JLabel?	Display Text
Why JTextField?	User Input
Why JPasswordField?	Hide Password
Why JButton?	Click Action
Why add()?	Display Component
Why setBounds()?	Position & Size
Why DAO?	Database Operations
Why PreparedStatement?	Secure Query
Why ResultSet?	Read Data
Why static?	Without Object
Why DriverManager?	Connect Database
Why Connection?	Connect DB
Why executeQuery()?	Fetch Data
Why rs.next()?	Check Record

*/