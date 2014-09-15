package com.kryshyna.lab10;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class TestHashMap {
    public static void main (String [] args){
        MyKey myKey = new MyKey(1);
        String myString = "Hello";
        HashMap<MyKey, String> hashMap = new HashMap<MyKey, String>();

        hashMap.put(myKey, myString);
        myKey.setKey(2);
        String myNewString = hashMap.get(myKey);
        System.out.println(myNewString);
    }
    
}
