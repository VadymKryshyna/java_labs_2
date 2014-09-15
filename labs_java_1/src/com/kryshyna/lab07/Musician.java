package com.kryshyna.lab07;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class Musician extends Thread {
    private String name;
    private Administrator admin;
        
    public Musician(String name, Administrator admin){
        this.name = name;
        this.admin = admin;
    }
    
    public void play(){
        System.out.println(this.name + " playing...");
        try {
            sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) { }
    }
    
    public void sleep(){
        System.out.println(this.name + " sleeping...");
        try {
            sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) { }
    }
    
    public void run(){
        while(true){
            String bow;
            String violin;
            if(this.admin.haveBow()){
                bow = this.admin.getBow();
                if(this.admin.haveViolin()){
                    violin = this.admin.getViolin();
                    this.play();
                    this.admin.putBow(bow);
                    this.admin.putViolin(violin);
                    
                }else{
                    this.admin.putBow(bow);
                    this.sleep();
                }
            }else{
                this.sleep();
            }
            
        }
    }
}
