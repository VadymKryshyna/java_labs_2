/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab05;

/**
 *
 * @author Vadym Kryshyna
 */
public class Coordinate {
    private int value;
    
    public Coordinate(int value)
    {
        this.value = value;
    }
    
    public int get()
    {
        return this.value;
    }
    
    public void set(int value)
    {
        this.value = value;
    }    
}
