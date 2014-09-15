package com.kryshyna.lab12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class Triangle extends Thread{
    private int centerX;
    private int centerY;
    private int radius;
    private int degree;
    private int time;
    
    public Triangle(int x, int y, int radius, int time){
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
        this.degree = 0;
        this.time = time;
        this.start();
    }
    
    private void changeDegree(){
        this.setDegree(this.getDegree() + 1);
        if(this.getDegree() == 359){
            this.setDegree(0);
        }
    }
    
    synchronized public void setDegree(int degree){
        this.degree = degree;
    }
    
    public int getDegree(){
        return this.degree;
    }

    public int[][] getCoordinate(){
        int[][] coordinate = new int[2][3];
        int grad = this.degree;
   	coordinate[0][0] = (int)(this.radius*Math.cos((grad+45)*Math.PI/180))+this.centerX;
   	coordinate[0][1] = (int)(this.radius*Math.cos((grad+120+45)*Math.PI/180))+this.centerX;
	coordinate[0][2] = (int)(this.radius*Math.cos((grad+240+45)*Math.PI/180))+this.centerX;
	coordinate[1][0] = (int)(this.radius*Math.sin((grad+45)*Math.PI/180))+this.centerY;
	coordinate[1][1] = (int)(this.radius*Math.sin((grad+120+45)*Math.PI/180))+this.centerY;
	coordinate[1][2] = (int)(this.radius*Math.sin((grad+240+45)*Math.PI/180))+this.centerY;
        return coordinate;
    }

    @Override
    public void run() {
        while (true) {
            this.changeDegree();
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException ex) {}
        }    
    }
}
