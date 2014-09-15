/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab13;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author epam
 */
public class FieldController{
    private Entity[][] cell;
    private int sizeX;
    private int sizeY;
    
    public FieldController(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
        this.cell = new Entity[this.sizeX][this.sizeY];
    }

    public int getSizeX(){
        return this.sizeX;
    }

    public int getSizeY(){
        return this.sizeY;
    }

    
    public synchronized boolean setEntity(Cell cell, Entity e){
        if (this.cell[cell.getX()][cell.getY()]==null){
            this.cell[cell.getX()][cell.getY()] = e;
            return true;
        }else{
            return false;
        }
    }

    public synchronized Entity getEntity(Cell cell){
        return this.cell[cell.getX()][cell.getY()];
    }

    public synchronized boolean isFreeCell(Cell cell){
        return this.cell[cell.getX()][cell.getY()]==null;
    }

    public synchronized void delEntity(Cell cell){
        this.cell[cell.getX()][cell.getY()] = null;
    }

    public synchronized void changeCell(Cell cellFrom, Cell cellTo){
        this.setEntity(cellTo, this.cell[cellFrom.getX()][cellFrom.getY()]);
        this.cell[cellFrom.getX()][cellFrom.getY()] = null;
    }

    //???
    public ArrayList<Cell> getAllEntity(){
        ArrayList<Cell> res = new ArrayList<>();
        Entity temp;
        for (int i = 0; i < this.sizeX; i++){
            for (int j = 0; j < this.sizeY; j++){
                if (this.cell[i][j]!=null){
                    res.add(new Cell(i,j, this.cell[i][j].getColor()));
                }
            }
        }
        return res;
    }

    public synchronized ArrayList<Cell> getArrayEntity(Color color){
        ArrayList<Cell> res = new ArrayList<>();
        Entity temp;
        for (int i = 0; i < this.sizeX; i++){
            for (int j = 0; j < this.sizeY; j++){
                if (this.cell[i][j]!=null && this.cell[i][j].getColor()==color){
                    res.add(new Cell(i,j));
                }
            }
        }
        return res;
    }
    
    public synchronized ArrayList<Cell> getFreeArea(Cell cell, int radius){
        ArrayList<Cell> res = new ArrayList<>();
        if(cell.getX()<this.sizeX && cell.getY()<this.sizeY){
            int fromX = (cell.getX()-radius)>0 ? cell.getX()-radius : 0;
            int toX = (cell.getX()+radius)<this.sizeX ? cell.getX()+radius : this.sizeX;
            int fromY = (cell.getY()-radius)>0 ? cell.getY()-radius : 0;
            int toY = (cell.getY()+radius)<this.sizeY ? cell.getY()+radius : this.sizeY;
            for(int i = fromX; i < toX;i++){
                for(int j = fromY; j < toY; j++){
                    if(this.cell[i][j]==null){
                        res.add(new Cell(i,j));
                    }
                }
            }
        }
        return res;
    }
    
    public synchronized ArrayList<Cell> getAreaNoColor(Cell cell, int radius, Color color){
        ArrayList<Cell> res = new ArrayList<>();
        if(cell.getX()<this.sizeX && cell.getY()<this.sizeY){
            int fromX = (cell.getX()-radius)>0 ? cell.getX()-radius : 0;
            int toX = (cell.getX()+radius)<this.sizeX ? cell.getX()+radius : this.sizeX;
            int fromY = (cell.getY()-radius)>0 ? cell.getY()-radius : 0;
            int toY = (cell.getY()+radius)<this.sizeY ? cell.getY()+radius : this.sizeY;
            for(int i = fromX; i < toX;i++){
                for(int j = fromY; j < toY; j++){
                    if(this.cell[i][j] == null || this.cell[i][j].getColor()!=color){
                        res.add(new Cell(i,j));
                    }
                }
            }
        }
        return res;
    }

        
}
