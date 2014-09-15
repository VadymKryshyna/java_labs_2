package com.kryshyna.lab06;


import java.awt.Shape;
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
public class SportsmanBuilder{
    protected SportsmanFigure figure;
    
    public SportsmanBuilder(){
        figure = new SportsmanFigure();
    }

    public void buildFigure(List<Shape> shapes) {
        this.figure.addBody(shapes.get(0));
        this.figure.addHands(shapes.get(1), shapes.get(2));
        this.figure.addHead(shapes.get(3));
        this.figure.addFoots(shapes.get(4), shapes.get(5));
        this.figure.addWeight(shapes.get(6));
    }

    public SportsmanFigure getFigure() {
        return this.figure;
    }
}
