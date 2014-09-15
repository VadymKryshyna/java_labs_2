/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab13;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author epam
 */
public class GameWindow{
    private JFrame frame;
    private int noOfSpp;
    public static final int size = 10;   

    
    public GameWindow() {
        this.createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.noOfSpp = 1;
        frame = new JFrame("Competition finite automata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810,430);
        final FieldView fieldView = new FieldView(frame.getWidth()-10, frame.getHeight()-30);
        FieldController fieldController = new FieldController(
                fieldView.getSizeX()/fieldView.getSizeCell(),
                fieldView.getSizeY()/fieldView.getSizeCell()); 
        fieldView.setFieldController(fieldController);
        frame.add(fieldView);
        EntityController controller1 = new EntityController(fieldController, Color.GREEN, this.noOfSpp);
        EntityController controller2 = new EntityController(fieldController, Color.BLUE, this.noOfSpp);
        EntityController controller3 = new EntityController(fieldController, Color.RED, this.noOfSpp);
        EntityController controller4 = new EntityController(fieldController, Color.YELLOW, this.noOfSpp);
        
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    frame.repaint();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                    }
                }
            };
        }).start();
        frame.setVisible(true);
        controller1.start();
        controller2.start();
        controller3.start();
        controller4.start();

    }

    
    public static void main(String args[]) {
        GameWindow window = new GameWindow();
    }
}
