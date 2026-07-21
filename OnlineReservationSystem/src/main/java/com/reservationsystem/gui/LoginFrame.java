package com.reservationsystem.gui;

import com.reservationsystem.dao.UserDAO;
import com.reservationsystem.gui.DashboardFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel lblPassword;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnLogin;

    public LoginFrame() {

        // Frame Properties
        setTitle("Online Reservation System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        // Title
        lblTitle = new JLabel("ONLINE RESERVATION SYSTEM");
        lblTitle.setBounds(110, 20, 300, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
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

        // Button Click Event
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword());

                // Validation
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Please enter username and password!");
                    return;
                }

                UserDAO userDAO = new UserDAO();

                if (userDAO.login(username, password)) {

                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login Successful!");

                    dispose();
                    new DashboardFrame();

                } else {

                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Invalid Username or Password!");

                }

            }
        });

        setVisible(true);
    }
}

/*
    Why dispose()  =>close login window
    new DashboardFrame()?  => help to open Dashboard window
        */