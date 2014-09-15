package com.kryshyna.lab08;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vadym Kryshyna
 */
public class CalculatorSubtotals extends Thread {
        private int from;
        private int to;
        private SubTotals subTotals;
        private int myPosition;
        
        public CalculatorSubtotals(int from, int to, SubTotals subTotals,
                int myPosition){
            this.from = from;
            this.to = to;
            this.subTotals = subTotals;
            this.myPosition = myPosition;
//            System.out.println("Create subThread № " + myPosition + " from:" +
//                    from + " to:" + to);
        }
        
        public void run(){
//            System.out.println("Start subThread № " + myPosition + " from:" +
//                    from + " to:" + to);
            long sum = 0;
            for (int i = this.from; i <= this.to; i++){
                sum = sum+i;
            }
            this.subTotals.setMidleSum(myPosition, sum);
           
//            System.out.println("Finish subThread № " + myPosition + " from:" +
//                    from + " to:" + to);
        }
}
