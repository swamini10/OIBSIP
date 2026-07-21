package com.reservationsystem.dao;
import java.sql.ResultSet;
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

            con.close();
            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // Cancel Reservation
    public boolean cancelReservation(long pnr) {

        boolean result = false;

        String sql = "DELETE FROM reservations WHERE pnr=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, pnr);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                result = true;
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;
    }

    // Search Reservation using PNR
    public Reservation getReservationByPNR(long pnr) {

        Reservation reservation = null;

        String sql = "SELECT * FROM reservations WHERE pnr=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, pnr);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                reservation = new Reservation();

                reservation.setPnr(rs.getLong("pnr"));
                reservation.setPassengerName(rs.getString("passenger_name"));
                reservation.setTrainNumber(rs.getInt("train_number"));
                reservation.setClassType(rs.getString("class_type"));
                reservation.setJourneyDate(rs.getString("journey_date"));
                reservation.setSourceStation(rs.getString("source_station"));
                reservation.setDestinationStation(rs.getString("destination_station"));

            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return reservation;
    }
}