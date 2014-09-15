/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab13;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author epam
 */
public class EntityController extends Thread{
    protected FieldController fieldController;
    private Color color;
    private int fertility = 2; //count child
    private int radDisp = 3;   //radius for leave child
    private int radBreed = 3;  //radius for partner
    private int sexBreed = 1;  //variants of sex
    private Random rand;
    
    public EntityController(FieldController fieldController, Color color, int count){
        this.rand = new Random();
        this.color = color;
        this.fieldController = fieldController;
        int time = 1;
        for (int i = 0; i < count; i++){
            boolean flag = false;
            int x = 0;
            int y = 0;
            while (!flag){
                x = rand.nextInt(fieldController.getSizeX());
                y = rand.nextInt(fieldController.getSizeY());
                Cell cell = new Cell(x,y);
                if(fieldController.isFreeCell(cell)){
                    flag = fieldController.setEntity(cell, new Entity(sexBreed, this.color, time));
                }
            }
        }
    }
    
    @Override
    public void run(){
        while(true){
            Iterator iteratorEntity = this.fieldController.getArrayEntity(color).iterator();
            while (iteratorEntity.hasNext()){
                Cell cell = (Cell) iteratorEntity.next();
                int newTime = this.fieldController.getEntity(cell).getTime()+1;

                ArrayList<Cell> listCell = this.fieldController.getFreeArea(cell, radDisp);
                int nextCell;
                if(listCell.size() > this.fertility){
                    int count = 0;
                    int step = 0;
                    while(count < this.fertility && step < 10){
                        step++;
                        nextCell = rand.nextInt(listCell.size());
                        if(this.fieldController.isFreeCell(listCell.get(nextCell))){
                            Entity newEntity = new Entity(sexBreed, this.color, newTime);
                            this.fieldController.setEntity(listCell.get(nextCell), newEntity);
                            count++;
                        }
                    }
                }else{
                    listCell = this.fieldController.getAreaNoColor(cell, radDisp, color);
                    if(listCell.size() > this.fertility){
                        int count = 0;
                        while(count < this.fertility){
                            int i = rand.nextInt(listCell.size());
                            Entity newEntity = new Entity(sexBreed, this.color, newTime);
                            this.fieldController.setEntity(listCell.get(i), newEntity);
                            count++;
                        }
                        for(int i = 0; i < this.fertility; i++){
                        }
                    }
                }
                
                this.fieldController.delEntity(cell);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Exception" + ex);
            }
        }
    }
}
