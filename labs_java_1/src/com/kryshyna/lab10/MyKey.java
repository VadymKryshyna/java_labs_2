package com.kryshyna.lab10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class MyKey {
    private int key;
    
    public MyKey(int key){
        this.key = key;
    }
    
    public void setKey(int key){
        this.key = key;
    }
    
    @Override
    public int hashCode(){
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyKey other = (MyKey) obj;
        if (!(this.key == other.key)){
            return false;
        }
        return true;
    }
    
}
