/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project1;

/**
 *
 * @author Kryshyna Vadym
 */
public class Locomotive {

    private static int inventaryLocomotive = 1;
    private int id;
        
    public Locomotive() {
        this.id = inventaryLocomotive++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locomotive other = (Locomotive) obj;
        return this.id != other.id;
    }
    
    @Override
    public String toString(){
        return "Locomotive: id="+id;
    }
}
