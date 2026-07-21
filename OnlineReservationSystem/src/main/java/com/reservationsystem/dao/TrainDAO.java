package com.reservationsystem.dao;

import com.reservationsystem.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainDAO {

    public String getTrainName(int trainNumber) {

        String trainName = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT train_name FROM trains WHERE train_number=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, trainNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                trainName = rs.getString("train_name");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return trainName;
    }
}

/*
Why TrainDAO  to fetch train information from datbase

        */