package com.kryshyna.lab08;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vadym Kryshyna
 */
public class CalculatorSum extends Thread{
    private int number;
    private int count;
    private SubTotals subTotals;
    
    public CalculatorSum(int number, int count){
        this.number = number;
        this.count = count;
    }
    public void run(){
//        System.out.println("Main thread starts...");
        this.subTotals = new SubTotals(this.count);
        Thread[] threadGroup = new Thread[this.count];
        int part = this.number / this.count;
        int from = 0;
        int to = 0;
        for(int i = 0; i < threadGroup.length; i++){
            from = to + 1;
            to = to + part;
            if (to > this.number){
                to = this.number;
            }
            threadGroup[i] = new CalculatorSubtotals(from, to, this.subTotals, i);
        }
        
        for (int i = 0; i < threadGroup.length; i++){
            threadGroup[i].start();
        }
        this.checkIsCounted();
        
        long result = 0;
        for(int i = 0;i < this.count; i++){
            result = result + this.subTotals.getMidleSum(i);
        }
//        System.out.println("Result for sum all numbers from 0 to " + 
//                    this.number + " is " + result);
    }
    
    public synchronized void checkIsCounted(){
            while(!this.subTotals.isCounted()){
            try {
                this.wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CalculatorSum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

    public static void main(String[] args){
        int myNumber =1_000_000;
        int myCount = 20;
        CalculatorSum calc = new CalculatorSum(myNumber, myCount);
        calc.start();
        long checkResult = 0;
        for(int i = 0; i < myNumber+1; i++){
            checkResult = checkResult + i;
        }
//        System.out.println("    Check result = " + checkResult);
    }
}
