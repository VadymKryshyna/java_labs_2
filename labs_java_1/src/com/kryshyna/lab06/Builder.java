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
 */interface Builder {
    
    public Figure getFigure();
    
    public void buildFigure(List<Shape> shapes);
}
