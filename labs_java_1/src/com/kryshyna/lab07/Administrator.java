package com.kryshyna.lab07;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vadym Kryshyna
 */
public class Administrator {
    private LinkedList<String> bows;
    private LinkedList<String> violins;
    private LinkedList<Musician> musicians;
    public Administrator(int countMusicians, int countBow, int countViolin){
        this.bows = new LinkedList<>();
        for (int i = 0; i < countBow; i++){
            this.bows.add("Bows " + i);
        }
        this.violins = new LinkedList<>();
        for (int i = 0; i < countViolin; i++){
            this.violins.add("Violin " + i);
        }
        this.musicians = new LinkedList<>();
        for (int i = 0; i < countMusicians; i++){
            this.musicians.add(new Musician("Musician " + i, this));
        }
    }

    public void begin(){
        for (int i = 0; i < this.musicians.size(); i++){
            this.musicians.get(i).start();
        }
    }

    public synchronized void putViolin(String violin){
        this.violins.addLast(violin);
    }
    
    public synchronized String getViolin(){
        return this.violins.removeFirst();
    }
    
    public synchronized boolean haveViolin(){
        if (this.violins.size()==0){
            return false;
        }else{
            return true;
        }
    }

    public synchronized void putBow(String bow){
        this.bows.addLast(bow);
    }
    
    public synchronized String getBow(){
        return this.bows.removeFirst();
    }
    
    public synchronized boolean haveBow(){
        if (this.bows.size()==0){
            return false;
        }else{
            return true;
        }
    }

    public static void main (String []args){
        Administrator admin = new Administrator(5, 3, 2);
        admin.begin();
    }
}
