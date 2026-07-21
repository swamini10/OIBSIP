package com.reservationsystem;

import com.reservationsystem.gui.CancellationFrame;
import com.reservationsystem.gui.LoginFrame;

public class Main {

    public static void main(String[] args) {

        new LoginFrame();

    }
}

/*
new LoginFrame(); ase ka lihile  -> apan object tayar kela pan tyacha reference save kart nahi aplala reference save karychi garj nahi so
What is the purpose of the new keyword in Java? -> The new keyword is used to create an object in heap memory. It allocates memory, calls the constructor, and returns a reference to the created object
*/