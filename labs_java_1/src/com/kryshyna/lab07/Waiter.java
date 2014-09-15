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
public class Waiter {
    // fork[] -- массив локальных переменных, соответствующих вилкам
    private boolean fork[] = {true,true,true,true,true}; // true -- вилка свободна, false -- вилка занята
    public synchronized void getFork(int i){
	cwait(!fork[i]);
	fork[i] = false;
    }
    public synchronized void putFork(int i){
	fork[i] = true;
	csignal(fork[i]);
    }

    // Операция приостановки вызывающего потока и помещения его
    // в очередь на условной переменой
    private void cwait(boolean c){
	if (c) {
            try{
                wait();
            } catch(InterruptedException e) {
            	throw new RuntimeException(e);
            };
        }
    }

    // Операция возобновления потока, ожидающего в очереди
    // на условной переменной
    private void csignal(boolean c){
    	c = true;
	notify();
    }
}
