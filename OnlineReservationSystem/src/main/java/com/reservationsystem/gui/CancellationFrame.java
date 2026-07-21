package com.reservationsystem.gui;

import com.reservationsystem.dao.ReservationDAO;
import com.reservationsystem.model.Reservation;

import javax.swing.*;
import java.awt.*;

public class CancellationFrame extends JFrame {

    JTextField txtPNR;

    JLabel lblName;
    JLabel lblTrain;
    JLabel lblDate;
    JLabel lblClass;

    JButton btnSearch;
    JButton btnCancel;
    JButton btnBack;
    JButton btnLogout;

    ReservationDAO reservationDAO = new ReservationDAO();


    public CancellationFrame() {

        System.out.println("Cancellation Frame Started");

        setTitle("Cancellation Form");
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);



        JLabel title = new JLabel("Cancel Reservation");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(200,30,250,40);
        panel.add(title);



        JLabel pnr = new JLabel("Enter PNR:");
        pnr.setBounds(80,100,100,30);
        panel.add(pnr);


        txtPNR = new JTextField();
        txtPNR.setBounds(200,100,200,30);
        panel.add(txtPNR);



        btnSearch = new JButton("Search");
        btnSearch.setBounds(220,150,100,30);
        panel.add(btnSearch);



        lblName = new JLabel("Passenger Name : ");
        lblName.setBounds(80,220,350,30);
        panel.add(lblName);


        lblTrain = new JLabel("Train Number : ");
        lblTrain.setBounds(80,260,350,30);
        panel.add(lblTrain);


        lblDate = new JLabel("Journey Date : ");
        lblDate.setBounds(80,300,350,30);
        panel.add(lblDate);


        lblClass = new JLabel("Class Type : ");
        lblClass.setBounds(80,340,350,30);
        panel.add(lblClass);



        // Search Button Action

        btnSearch.addActionListener(e -> {

            try {

                long pnrNumber = Long.parseLong(txtPNR.getText());

                Reservation reservation =
                        reservationDAO.getReservationByPNR(pnrNumber);


                if(reservation != null) {

                    lblName.setText(
                            "Passenger Name : "
                                    + reservation.getPassengerName()
                    );

                    lblTrain.setText(
                            "Train Number : "
                                    + reservation.getTrainNumber()
                    );

                    lblDate.setText(
                            "Journey Date : "
                                    + reservation.getJourneyDate()
                    );

                    lblClass.setText(
                            "Class Type : "
                                    + reservation.getClassType()
                    );

                }
                else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Reservation Not Found"
                    );

                }


            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter Valid PNR"
                );

            }

        });



        btnCancel = new JButton("Cancel Ticket");
        btnCancel.setBounds(120,400,140,35);
        panel.add(btnCancel);



        // Cancel Button Action

        btnCancel.addActionListener(e -> {

            try {

                long pnrNumber =
                        Long.parseLong(txtPNR.getText());


                boolean status =
                        reservationDAO.cancelReservation(pnrNumber);


                if(status) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Reservation Cancelled Successfully"
                    );


                    txtPNR.setText("");

                    lblName.setText("Passenger Name : ");
                    lblTrain.setText("Train Number : ");
                    lblDate.setText("Journey Date : ");
                    lblClass.setText("Class Type : ");

                }
                else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Cancellation Failed"
                    );

                }


            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter Valid PNR"
                );

            }

        });



        btnBack = new JButton("Back");
        btnBack.setBounds(280,400,100,35);
        panel.add(btnBack);



        btnLogout = new JButton("Logout");
        btnLogout.setBounds(400,400,100,35);
        panel.add(btnLogout);



        // Back Button

        btnBack.addActionListener(e -> {

            dispose();

        });


        // Logout Button

        btnLogout.addActionListener(e -> {

            dispose();

            new LoginFrame();

        });



        add(panel);

        setVisible(true);

    }



    public static void main(String[] args) {

        new CancellationFrame();

    }

}