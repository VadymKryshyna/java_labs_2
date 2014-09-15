/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab05;

import java.awt.Color;

/**
 *
 * @author Vadym Kryshyna
 */
public class FillEllipse {
    private MyPoint center;
    private Color color;
    private int valueA;
    private int valueB;
    private boolean visible;
    
    public FillEllipse(MyPoint center, Color color, int valueA, int valueB)
    {
        this.center = center;
        this.color = color;
        this.valueA = valueA;
        this.valueB = valueB;
        this.visible = false;
    }
    
    public void setVisible()
    {
        this.visible = true;
    }
    
    public void setHide()
    {
        this.visible = false;
    }
    
    public void move(MyPoint center)
    {
        this.center = center;
    }
    
    public void setDimension(int valueA, int valueB)
    {
        this.valueA = valueA;
        this.valueB = valueB;
    }
}
