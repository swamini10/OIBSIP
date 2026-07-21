package com.reservationsystem.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.reservationsystem.dao.TrainDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.reservationsystem.dao.ReservationDAO;
import com.reservationsystem.model.Reservation;
public class ReservationFrame extends JFrame {

    // Labels
    JLabel lblTitle;
    JLabel lblPassengerName;
    JLabel lblTrainNumber;
    JLabel lblTrainName;
    JLabel lblClassType;
    JLabel lblJourneyDate;
    JLabel lblSource;
    JLabel lblDestination;

    // Text Fields
    JTextField txtPassengerName;
    JTextField txtTrainNumber;
    JTextField txtTrainName;
    JTextField txtJourneyDate;
    JTextField txtSource;
    JTextField txtDestination;

    // Combo Box
    JComboBox<String> cmbClassType;

    // Buttons
    JButton btnBook;
    JButton btnBack;

    public ReservationFrame() {

        // Frame Properties
        setTitle("Reservation Form");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Title
        lblTitle = new JLabel("ONLINE RESERVATION SYSTEM");
        lblTitle.setBounds(160, 20, 300, 30);
        add(lblTitle);

        // Passenger Name
        lblPassengerName = new JLabel("Passenger Name");
        lblPassengerName.setBounds(50, 80, 120, 30);
        add(lblPassengerName);

        txtPassengerName = new JTextField();
        txtPassengerName.setBounds(200, 80, 250, 30);
        add(txtPassengerName);

        // Train Number
        lblTrainNumber = new JLabel("Train Number");
        lblTrainNumber.setBounds(50, 130, 120, 30);
        add(lblTrainNumber);

        txtTrainNumber = new JTextField();
        txtTrainNumber.setBounds(200, 130, 250, 30);
        add(txtTrainNumber);

        // Train Name
        lblTrainName = new JLabel("Train Name");
        lblTrainName.setBounds(50, 180, 120, 30);
        add(lblTrainName);

        txtTrainName = new JTextField();
        txtTrainName.setBounds(200, 180, 250, 30);
        txtTrainName.setEditable(false);
        add(txtTrainName);

        // Class Type
        lblClassType = new JLabel("Class Type");
        lblClassType.setBounds(50, 230, 120, 30);
        add(lblClassType);

        String[] classes = {"Sleeper", "AC", "First Class", "Second Class"};
        cmbClassType = new JComboBox<>(classes);
        cmbClassType.setBounds(200, 230, 250, 30);
        add(cmbClassType);

        // Journey Date
        lblJourneyDate = new JLabel("Journey Date");
        lblJourneyDate.setBounds(50, 280, 120, 30);
        add(lblJourneyDate);

        txtJourneyDate = new JTextField();
        txtJourneyDate.setBounds(200, 280, 250, 30);
        add(txtJourneyDate);

        // Source Station
        lblSource = new JLabel("Source Station");
        lblSource.setBounds(50, 330, 120, 30);
        add(lblSource);

        txtSource = new JTextField();
        txtSource.setBounds(200, 330, 250, 30);
        add(txtSource);

        // Destination Station
        lblDestination = new JLabel("Destination Station");
        lblDestination.setBounds(50, 380, 140, 30);
        add(lblDestination);

        txtDestination = new JTextField();
        txtDestination.setBounds(200, 380, 250, 30);
        add(txtDestination);

        txtTrainNumber.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                try {

                    int trainNumber = Integer.parseInt(txtTrainNumber.getText());

                    TrainDAO trainDAO = new TrainDAO();

                    String trainName = trainDAO.getTrainName(trainNumber);

                    if (trainName != null) {

                        txtTrainName.setText(trainName);

                    } else {

                        txtTrainName.setText("");

                    }

                } catch (NumberFormatException ex) {

                    txtTrainName.setText("");

                }

            }

        });

        // Book Button
        btnBook = new JButton("Book Ticket");
        btnBook.setBounds(120, 450, 150, 35);
        add(btnBook);
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerName = txtPassengerName.getText().trim();
                String trainNumberText = txtTrainNumber.getText().trim();
                String trainName = txtTrainName.getText().trim();
                String classType = cmbClassType.getSelectedItem().toString();
                String journeyDate = txtJourneyDate.getText().trim();
                String source = txtSource.getText().trim();
                String destination = txtDestination.getText().trim();

// Validation
                if (passengerName.isEmpty() ||
                        trainNumberText.isEmpty() ||
                        trainName.isEmpty() ||
                        journeyDate.isEmpty() ||
                        source.isEmpty() ||
                        destination.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            ReservationFrame.this,
                            "Please fill all fields!"
                    );
                    return;
                }

                try {

                    int trainNumber = Integer.parseInt(trainNumberText);

                    ReservationDAO reservationDAO = new ReservationDAO();

                    long pnr = reservationDAO.generatePNR();

                    Reservation reservation = new Reservation(
                            pnr,
                            passengerName,
                            trainNumber,
                            classType,
                            journeyDate,
                            source,
                            destination
                    );

                    boolean status = reservationDAO.bookTicket(reservation);

                    if (status) {

                        JOptionPane.showMessageDialog(
                                ReservationFrame.this,
                                "Reservation Successful!\n\n" +
                                        "PNR : " + pnr +
                                        "\nPassenger : " + passengerName +
                                        "\nTrain : " + trainName
                        );

                        txtPassengerName.setText("");
                        txtTrainNumber.setText("");
                        txtTrainName.setText("");
                        txtJourneyDate.setText("");
                        txtSource.setText("");
                        txtDestination.setText("");

                        cmbClassType.setSelectedIndex(0);

                        txtPassengerName.requestFocus();

                    } else {

                        JOptionPane.showMessageDialog(
                                ReservationFrame.this,
                                "Reservation Failed!"
                        );

                    }



                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            ReservationFrame.this,
                            "Train Number must be numeric!"
                    );

                }
            }
        });


        // Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(320, 450, 130, 35);
        add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new DashboardFrame();

            }
        });

        setVisible(true);
    }
}

/*
Why JFrame?	Create window
Why JLabel?	Display text
Why JTextField?	Take user input
Why JComboBox?	Select one option
Why JButton?	Perform action
Why setBounds()?	Set position and size
Why setLayout(null)?	Manual layout
Why setEditable(false)?	Prevent editing
Why setLocationRelativeTo(null)?	Center the frame
Why setVisible(true)?	Display the frame
 */