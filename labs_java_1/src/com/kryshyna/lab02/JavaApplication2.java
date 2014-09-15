package com.kryshyna.lab02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Kryshyna Vadym
 */

public class JavaApplication2 {
    private String[] myStrings;
    private Scanner input = new Scanner(System.in);
    
    public void menu(){
        System.out.print("Input count of lines, you wont input: ");
        String inputString = input.nextLine();
        try{
            int size  = Integer.parseInt(inputString);
            myStrings = new String[size];
        }catch(NumberFormatException e){
            System.out.println("Please input a number");
            menu();
        }
        fillArrayFromConsole();
        checkArrayForPalindrom();
        showInfoAuthor();
    }

    private void fillArrayFromConsole() {
        System.out.println("Please input " + myStrings.length + " lines:");
        for(int i = 0; i < myStrings.length; i++){
            System.out.print("line "+(i+1)+": ");
            myStrings[i] = input.nextLine();
        }
    }

    private void checkArrayForPalindrom() {
        int number1 = -1;
        int number2 = -1;
        Boolean flag = false;
        for(int i = 0; i < myStrings.length && flag == false; i++){
            if(isNumber(i) && isPalendrom(i)){
                if(number1 == -1){  number1 = i;    }
                else if(number2 == -1){
                    number2 = i;
                    flag = true;
                }
            }
        }
        if(number2 != -1){   
            System.out.println("Array have more than 1 palindrom");
            System.out.println("second palindrom is: " + myStrings[number2]);
        }
        else if(number1 != -1){
            System.out.println("Array have only 1 palindrom");
            System.out.println("This palindrom is: " + myStrings[number1]);
        }
        else{
            System.out.println("Array do not have any palindrom");
        }
    }

    private boolean isNumber(int index){
        try{
            Integer.parseInt(myStrings[index]);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

   private Boolean isPalendrom(int k) {
       char[] charArray = myStrings[k].toCharArray();
       Boolean result = true;
       for(int i = 0; i < charArray.length/2 && result == true; i++){
           if(charArray[i] != charArray[charArray.length-1]){   result = false; }
       }
       return result;
   }

   private void showInfoAuthor() {
       System.out.println("--------------------------------------------------");
       System.out.println("Author: Kryshyna Vadym.");
       System.out.println("Task was recived: 29.03.2014 02:51");
       Date currentDate = new Date();
       SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm");
       System.out.println("Task was complaited: " + formater.format(currentDate));
   }

    public static void main(String[] args) {
        //menu();
        JavaApplication2 app = new JavaApplication2();
        app.menu();
    }




}
