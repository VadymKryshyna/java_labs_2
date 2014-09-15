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
public class FillSektorElipse extends FillEllipse{
    private MyPoint leftPoint;
    private MyPoint rightPoint;
    
    public FillSektorElipse(MyPoint center, Color color, int valueA, int valueB,
            MyPoint leftPoint,MyPoint rightPoint) {
        super(center, color, valueA, valueB);
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }
    
}
