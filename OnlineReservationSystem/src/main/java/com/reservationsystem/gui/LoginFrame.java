package com.reservationsystem.gui;

import javax.swing.*;

public class LoginFrame extends JFrame {

    // Components
    JLabel lblTitle;
    JLabel lblUsername;
    JLabel lblPassword;

    JTextField txtUsername;
    JPasswordField txtPassword;

    JButton btnLogin;

    public LoginFrame() {

        // Frame Properties
        setTitle("Online Reservation System");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Title
        lblTitle = new JLabel("Login");
        lblTitle.setBounds(220, 20, 100, 30);
        add(lblTitle);

        // Username Label
        lblUsername = new JLabel("Username");
        lblUsername.setBounds(70, 80, 100, 30);
        add(lblUsername);

        // Username TextField
        txtUsername = new JTextField();
        txtUsername.setBounds(180, 80, 200, 30);
        add(txtUsername);

        // Password Label
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(70, 140, 100, 30);
        add(lblPassword);

        // Password Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 140, 200, 30);
        add(txtPassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(180, 210, 100, 35);
        add(btnLogin);

        setVisible(true);
    }
}