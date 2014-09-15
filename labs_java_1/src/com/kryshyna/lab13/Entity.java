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
public class Entity{
    private Color color;
    private int sexBreed;
    private int time;
    
    public Entity(int sexBreed, Color color, int time){
        this.sexBreed = sexBreed;
        this.color = color;
        this.time = time;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public int getSexBreed(){
        return this.sexBreed;
    }
    
    public int getTime(){
        return this.time;
    }
}