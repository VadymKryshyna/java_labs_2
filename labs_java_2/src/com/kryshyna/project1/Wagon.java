/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project1;

/**
 *
 * @author Kryshyna Vadym
 */
public class Wagon {
    private static int inventaryWagon = 1;

    private int seats = 0;
    private int passangers = 0;
    private int place = 0;
    private int baggage = 0;
    private TypeWagon type;
    private int id;
    
    public Wagon(TypeWagon type){
        this.type = type;
        this.id = inventaryWagon++;
        switch(type){
            case FIRST:
                place = 10;
                seats = 15;
                break;
            case SECOND:
                place = 20;
                seats = 25;
                break;
            case THIRT:
                place = 30;
                seats = 35;
                break;
        }
    }

    public boolean addPassanger(int countPassanger){
        if((passangers+countPassanger) > seats){
            return false;
        }else{
            passangers+=countPassanger;
            return true;
        }
    }
    
    public int getCountPassanger(){
        return this.passangers;
    }
    
    public boolean addBaggage(int countBaggage){
        if((baggage+countBaggage) > place){
            return false;
        }else{
            baggage+=countBaggage;
            return true;
        }
    }
    
    public int getCountBaggage(){
        return this.baggage;
    }
    
    public TypeWagon getWagonClass(){
        return type;
    }
    
    @Override
    public String toString(){
        return "Wagon: id="+id+"; type="+ type.toString()+
                "; seats="+seats+"; passangers="+passangers
                +"; place="+place+"; baggage="+baggage;
    }
}
