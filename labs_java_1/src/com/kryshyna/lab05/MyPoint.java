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
public class MyPoint {
    private Coordinate x;
    private Coordinate y;
    
    public MyPoint(Coordinate x, Coordinate y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Coordinate getX()
    {
        return new Coordinate(this.x.get());
    }
    
    public Coordinate getY()
    {
        return new Coordinate(this.y.get());
    }
    
    public void set(Coordinate x, Coordinate y)
    {
        this.x = x;
        this.y = y;
    }
}
