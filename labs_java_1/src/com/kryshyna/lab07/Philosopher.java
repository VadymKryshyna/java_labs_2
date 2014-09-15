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
public class Philosopher extends Thread {
    private Waiter waiter; 
    Philosopher(String name, Waiter waiter){
        super(name);
        this.waiter = waiter;
    }
    public void run() {
	int k = Integer.parseInt(getName().substring(12));
	while (true){
	// Думает
            System.out.println(getName() + " thinking ...");
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
            // Захватывает левую вилку
            this.waiter.getFork(k-1);
            System.out.println(getName() + " queries " + "fork # " + (k-1));
            // Захватывает правую вилку				
            this.waiter.getFork(k%5);
            System.out.println(getName() + " queries " + "fork # " + (k%5));

            // Ест
            System.out.println(getName() + " eating ...");
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
            
            // Освобождает правую вилку
            System.out.println(getName() + " released " + "fork # " + (k%5));
            this.waiter.putFork(k%5);
            
            // Освобождает левую вилку
            System.out.println(getName() + " released " + "fork # " + (k-1));
            this.waiter.putFork(k-1);
        }
    }
}
