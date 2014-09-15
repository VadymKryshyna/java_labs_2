/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author Kryshyna Vadym
 */
public class MainProject1 {
    private Depot depot;
    private Train train;
 
    public static void main(String [] args){
        MainProject1 m = new MainProject1();
        m.depot = new Depot();
        m.depot.fillDepot();
        m.menu();
        System.out.println("Finish");
    }
    
    private void menu(){
        showMainMenu();
        int choose = readChooseInt();
        switch(choose){
            case 1: createTrain(); break;
            case 2: loadTrain(); break;
            case 3: showTrain(); break;
            case 4: sortWagon(); break;
            case 5: findByCondition(); break;
            case 6: break;
            default:wrongChoise(); break;
        }
    }

    private void createTrain(){
        train = depot.createTrain("100", 5);
        System.out.println("Train was created.");
        menu();
    }
    
    private void loadTrain() {
        if(train != null){
            Random rand = new Random();
            for(int i = 0; i < train.size(); i++){
                for(int j = 0; j < 3; j++){
                    train.addPassangers(i, rand.nextInt(3));
                    train.addBaggage(i, rand.nextInt(3));
                }
            }
            System.out.println("Train was load");
            menu();
        }else{
            System.out.println("Please make train");
            menu();
        }
    }
    
    public void showTrain(){
        if(train != null){
            System.out.println("Info about train");
            System.out.println(train);
            menu();
        }else{
            System.out.println("Please make train");
            menu();
        }
    }
    
    public void sortWagon(){
        if(train != null){
            train.sortWagons();
            System.out.println("Wagons was sorted");
            menu();
        }else{
            System.out.println("Please make train");
            menu();
        }
    }
    
    private void findByCondition(){
        if(train != null){
            System.out.print("Input count passangers for condition:");
            int chose = readChooseInt();
            if(chose == -100){
                System.out.print("Input correct date:");
                findByCondition();
            }else{
                List<Wagon> wagons = train.chooseWagons(chose);
                if(wagons.size()>0){
                    System.out.println("Find next wagons:");
                    for(int i = 0; i < wagons.size(); i++){
                        System.out.println(wagons.get(i));
                    }
                }else{
                    System.out.println("Find no one wagons");
                }
                menu();
            }
        }else{
            System.out.println("Please make train");
            menu();
        }
    }
    
    private void wrongChoise(){
        System.out.println("You input incorrect date");
        menu();
    }
    
    private void showMainMenu(){
//        for(int i = 0; i < 10; i++){
//            System.out.println();
//        }
        System.out.println("---Main menu---");
        System.out.println("1.Create train");
        System.out.println("2.Loud train");
        System.out.println("3.Show train (info)");
        System.out.println("4.Sort wagon in train");
        System.out.println("5.Find wagons by condotion");
        System.out.println("6.Quit");
        System.out.println();
        System.out.println("Please input your choose:");
    }
    
    private int readChooseInt(){
        int choose = -1;
	try{
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String line = bufferRead.readLine();
            String regExp = "[0-9]+";
            boolean res = Pattern.matches(regExp, line);
            if(res==true){
                choose = Integer.parseInt(line);
            }
        }catch(IOException e){
            e.printStackTrace();
	}
        return choose;
    }
    
}
