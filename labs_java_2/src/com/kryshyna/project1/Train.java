/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Kryshyna Vadym
 */
public class Train {
    private Locomotive locomotive;
    private List<Wagon> wagons;
    private String trainNumber;
    
    public Train(String trainNumber, Locomotive locomotive){
        this.trainNumber = trainNumber;
        this.locomotive = locomotive;
        this.wagons = new ArrayList<>();
    }
    
    public boolean addWagon(Wagon wagon){
        if(!wagons.contains(wagon)){
            return wagons.add(wagon);
        }else{
            return false;
        }
    }
    
    public int getAmountPassangers(){
        int amountPassanger = 0;
        for(int i = 0; i < wagons.size(); i++){
            amountPassanger += wagons.get(i).getCountPassanger();
        }
        return amountPassanger;
    }
    
    public int getAmountBaggage(){
        int amountBaggage = 0;
        for(int i = 0; i < wagons.size(); i++){
            amountBaggage += wagons.get(i).getCountBaggage();
        }
        return amountBaggage;
    }
    
    public List<Wagon> chooseWagons(int countPassangers){
        List<Wagon> list = new ArrayList<>();
        for(int i = 0; i < wagons.size(); i++){
            if(wagons.get(i).getCountPassanger() > countPassangers){
                list.add(wagons.get(i));
            }
        }
        return list;
    }
    
    public void sortWagons(){
        Collections.sort(wagons, new Comparator<Wagon>() {
            @Override
            public int compare(Wagon  wagon1, Wagon  wagon2)
            {
                return wagon1.getWagonClass().compareTo(wagon2.getWagonClass());
            }
        });    
    }
    
    @Override
    public String toString(){
        StringBuffer result = new StringBuffer("Train: number="+trainNumber);
        result.append("\n");
        result.append(locomotive.toString());
        result.append("\n Wagons:");
        for(int i = 0; i < wagons.size(); i++){
            result.append("\n");
            result.append(i+1);
            result.append(": ");
            result.append(wagons.get(i).toString());
        }
        return result.toString();
    }
    
    public boolean addPassangers(int numberWagon, int countPassangers){
        if(numberWagon > wagons.size()){
            return false;
        }else{
            return wagons.get(numberWagon).addPassanger(countPassangers);
        }
    }

    public boolean addBaggage(int numberWagon, int countBaggage){
        if(numberWagon > wagons.size()){
            return false;
        }else{
            return wagons.get(numberWagon).addBaggage(countBaggage);
        }
    }
    
    public int size(){
        return wagons.size();
    }
}
