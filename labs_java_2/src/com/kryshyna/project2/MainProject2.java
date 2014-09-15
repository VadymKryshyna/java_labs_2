/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project2;

/**
 *
 * @author Kryshyna Vadym
 */
public class MainProject2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filename = "book.txt";
        //MyProcessor();
        MyText myText1 = MyProcessor.readTextFromFile(filename);
        MyText myText2 = MyProcessor.sortText(myText1);
//        MyText myText2 = myText1.sortText();
        System.out.println(myText1);
        System.out.println();
//        System.out.println(myText1.punctuations());
//        System.out.println();
//        System.out.println(myText1.delimiters());
        System.out.println();
//        System.out.println(myText1.words());
        System.out.println(myText2);
    
    }
    
}
