package com.kryshyna.lab03;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class Main {
    
    public static void main (String[]args){
        MyPoint p = new MyPoint();
        MySegment s = new MySegment();
        Square sq = new Square(p, s);

        Square sq1 = new Square(p, s);
        while(true){
            break;
        }

        System.out.println("Method toString for MyPoint = " + p);
        System.out.println("Method toString for MySegment = " + s);
        System.out.println("Method toString for Square = " + sq);
        
        System.out.println("Method hashcode for MyPoint = " + p.hashCode());
        System.out.println("Method hashcode for MySegment = " + s.hashCode());
        System.out.println("Method hashcode for Square obj1 = " + sq.hashCode());
        System.out.println("Method hashcode for Square obj2 = " + sq1.hashCode());
        
        System.out.println("Method equals for obj1 and obj2 = " + sq.equals(sq1));
        
    }
}
