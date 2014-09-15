/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Kryshyna Vadym
 */
public class Depot {
    private List<Locomotive> locomotives; 
    private List<Wagon> wagons;
    private List<Train> trains;

    public Depot(){
        locomotives = new ArrayList<>();
        wagons = new ArrayList<>();
  //      trains = new ArrayList<>();
    }
    
    public void fillDepot(){
        for(int i = 0; i < 5; i++){
            createLocomotive();
        }
        String[] arrayTypes = {"FIRST", "SECOND", "THIRT"};
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            int index = rand.nextInt(arrayTypes.length);
            TypeWagon type = TypeWagon.valueOf(arrayTypes[index]);
            createWagon(type);
        }
    }
    
    public boolean createWagon(TypeWagon type){
        return wagons.add(new Wagon(type));
    }

    public boolean createLocomotive(){
        return locomotives.add(new Locomotive());
    }
    
    public Train createTrain(String trainNumber, int countWagon){
        Random rand = new Random();
        int indexLocomotives = rand.nextInt(locomotives.size());
        Train train = new Train(trainNumber, locomotives.get(indexLocomotives));
        for(int i = 0; i < 7; i++){
            int indexWagon = rand.nextInt(wagons.size());
            train.addWagon(wagons.get(indexWagon));
        }
        trains.add(train);
        return train;
    }
}
