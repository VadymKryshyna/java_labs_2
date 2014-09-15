package com.kryshyna.lab06;


import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class SportsmanFigure{
    private List<Shape> shapes;

    public SportsmanFigure(){
        this.shapes = new ArrayList<Shape>();
    }
    
    public void show() {
        System.out.println("Sportsman");
    }

    public boolean addHead(Shape head){
        return this.shapes.add(head);
    }
    
    public boolean addBody(Shape body){
        return this.shapes.add(body);
    }

    public boolean addHands(Shape hand1, Shape hand2){
        return this.shapes.add(hand1) && this.shapes.add(hand2);
    }
    
    public boolean addFoots(Shape foot1, Shape foot2){
        return this.shapes.add(foot1) && this.shapes.add(foot2);
    }
    
    public boolean addWeight(Shape weight){
        return this.shapes.add(weight);
    }

}
