/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab13;

import java.awt.Color;

/**
 *
 * @author epam
 */
public class Cell {
    private int x;
    private int y;
    private Color color;
    
    public Cell(int x, int y){
        if(x < 0 || y < 0){
            x = 0;
            y = 0;
        }
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, Color color){
        this(x, y);
        this.color = color;
    }

    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public Color getColor(){
        return this.color;
    }

    
    @Override
    public int hashCode(){
        return this.x*100 + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
