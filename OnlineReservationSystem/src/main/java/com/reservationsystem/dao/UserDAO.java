package com.reservationsystem.dao;

import com.reservationsystem.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean login(String username, String password) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("Username = " + username);
            System.out.println("Password = " + password);

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("User Found");
                return true;
            }

            System.out.println("User Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}