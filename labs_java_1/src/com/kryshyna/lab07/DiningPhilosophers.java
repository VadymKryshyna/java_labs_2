package com.kryshyna.lab07;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vadym Kryshyna
 */
public class DiningPhilosophers {
    public static void main (String []args){
        Waiter waiter = new Waiter();
        for (int i = 1; i<=5; i++){
            new Philosopher("Philosopher " + i, waiter).start();
	}

    }
}
