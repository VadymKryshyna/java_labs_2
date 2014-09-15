package com.kryshyna.lab12;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class AppRotate extends JFrame {
    private JTriangle jTriangle;
    public AppRotate(){
        super("Ratate tringles");
        this.setSize(800, 400);
        jTriangle = new JTriangle();
        this.add(jTriangle);
        new RotateThread().start();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}

    public static void main(String []args){
        new Runnable(){
            @Override
            public void run() {
                new AppRotate();
            }
        }.run();
    }
    
    
    class RotateThread extends Thread{
        @Override
        public void run() {
            int i = 0;
            while (true) {
                if(i == 100){
                    i = 0;
                    jTriangle.balance();
                }
                jTriangle.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {}
                i = i + 1;
            }    
        }
    
    }
    
    
    
    class JTriangle extends JComponent{
        private Triangle [] triangle; 
        public JTriangle(){
            this.triangle = new Triangle[5];
            triangle[0] = new Triangle(100, 100, 50, 10);
            triangle[1] = new Triangle(220, 100, 60, 25);
            triangle[2] = new Triangle(340, 100, 70, 40);
            triangle[3] = new Triangle(460, 100, 80, 55);
            triangle[4] = new Triangle(580, 100, 90, 70);
        }
        
        public void balance(){
            int degree = 0;
            for (int i = 0; i < this.triangle.length; i++){
                degree = degree + this.triangle[i].getDegree();
            }
            degree = degree / this.triangle.length;
            for (int i = 0; i < this.triangle.length; i++){
                this.triangle[i].setDegree(degree);
            }
        }
               
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int [][] tempCoordinate0 = this.triangle[0].getCoordinate();
            int [][] tempCoordinate1 = this.triangle[1].getCoordinate();
            int [][] tempCoordinate2 = this.triangle[2].getCoordinate();
            int [][] tempCoordinate3 = this.triangle[3].getCoordinate();
            int [][] tempCoordinate4 = this.triangle[4].getCoordinate();
            
            g2d.drawPolygon(tempCoordinate0[0], tempCoordinate0[1], 3);
            g2d.drawPolygon(tempCoordinate1[0], tempCoordinate1[1], 3);
            g2d.drawPolygon(tempCoordinate2[0], tempCoordinate2[1], 3);
            g2d.drawPolygon(tempCoordinate3[0], tempCoordinate3[1], 3);
            g2d.drawPolygon(tempCoordinate4[0], tempCoordinate4[1], 3);
        }

    }
}