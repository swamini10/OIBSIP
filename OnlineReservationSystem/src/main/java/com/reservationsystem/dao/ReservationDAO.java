package com.reservationsystem.dao;

import com.reservationsystem.db.DBConnection;
import com.reservationsystem.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ReservationDAO {

    // Generate Random PNR
    public long generatePNR() {

        Random random = new Random();

        return 10000000L + random.nextInt(90000000);

    }

    // Book Ticket
    public boolean bookTicket(Reservation reservation) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO reservations VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, reservation.getPnr());
            ps.setString(2, reservation.getPassengerName());
            ps.setInt(3, reservation.getTrainNumber());
            ps.setString(4, reservation.getClassType());
            ps.setString(5, reservation.getJourneyDate());
            ps.setString(6, reservation.getSourceStation());
            ps.setString(7, reservation.getDestinationStation());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }
}