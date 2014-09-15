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
public class MyDelimiter {
    private String delimiter;

    public MyDelimiter(char delimiter) {
        this.delimiter  = " ";
    }

    public String getDelimiter() {
        return delimiter;
    }
        
    @Override
    public String toString(){
        return delimiter;
    }
}
