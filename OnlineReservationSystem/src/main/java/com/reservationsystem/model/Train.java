package com.reservationsystem.model;

public class Train {

    private int trainNumber;
    private String trainName;

    public Train() {
    }

    public Train(int trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}

/*
Why Train class?	Store train data
Why private?	Data Hiding
Why constructor?	Initialize object
Why getter?	Read data
Why setter?	Update data
Train.java  POJO class
What is POJO class    to store data in Java class.
        */