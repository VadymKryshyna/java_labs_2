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
public class SubTotals {
        private long [] subTotals;
        
        public SubTotals(int count){
            this.subTotals = new long[count];
        }
        
        public void setMidleSum(int position, long sum){
            this.subTotals[position] = sum;
        }
        
        public long getMidleSum(int position){
            return this.subTotals[position];
        }
        
        public boolean isCounted(){
            boolean result = true;
            for (int i=0; (i<this.subTotals.length)&&(result==true); i++){
                if (this.subTotals[i] == 0){
                    result = false;
                }
            }
            return result;
        }
}
