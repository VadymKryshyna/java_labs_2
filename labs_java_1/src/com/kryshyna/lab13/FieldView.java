/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author epam
 */
public class FieldView extends JComponent{
    private FieldController controller;
    private int sizeCell = 20;
    private int sizeX;
    private int sizeY;
    
    public FieldView(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.setSize(this.sizeX, this.sizeY);
    }
    
    public void setFieldController(FieldController controller){
        this.controller = controller;
    }
    
    public int getSizeCell(){
        return this.sizeCell;
    }
    
    public int getSizeX(){
        return this.sizeX;
    }
    
    public int getSizeY(){
        return this.sizeY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ArrayList<Cell> list = controller.getAllEntity();
        for (Cell cell : list){
            g2d.setColor(cell.getColor());
            g2d.fillRect(cell.getX()*this.sizeCell, cell.getY()*this.sizeCell, this.sizeCell, this.sizeCell);
        }

    }

}
