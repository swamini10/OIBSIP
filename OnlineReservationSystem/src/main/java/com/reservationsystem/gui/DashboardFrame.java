package com.reservationsystem.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DashboardFrame extends JFrame {

    JLabel lblTitle;
    JButton btnReservation;
    JButton btnCancel;
    JButton btnLogout;

    public DashboardFrame() {

        // Frame Properties
        setTitle("Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Title
        lblTitle = new JLabel("ONLINE RESERVATION SYSTEM");
        lblTitle.setBounds(110, 30, 300, 30);
        add(lblTitle);

        // Reservation Button
        btnReservation = new JButton("Reservation");
        btnReservation.setBounds(150, 100, 180, 35);
        add(btnReservation);
       

        // Cancel Button
        btnCancel = new JButton("Cancel Reservation");
        btnCancel.setBounds(150, 160, 180, 35);
        add(btnCancel);

        // Logout Button
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(150, 220, 180, 35);
        add(btnLogout);

        setVisible(true);
    }
}