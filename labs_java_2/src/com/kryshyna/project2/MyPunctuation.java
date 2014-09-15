/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project2;

/**
 *
 * @author Kryshyna Vadym
 */
public class MyPunctuation {
    private String punctuation;

    public String getPunctuation() {
        return punctuation;
    }

    public MyPunctuation(char punctuation) {
        this.punctuation = Character.toString(punctuation);
    }
    
    @Override
    public String toString(){
        return punctuation;
    }
}
