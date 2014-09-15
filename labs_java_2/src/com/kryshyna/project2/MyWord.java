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
public class MyWord {
    private String word;
    
    public MyWord(String word){
        this.word = word;
    }
    
    @Override
    public String toString(){
        return word;
    }
    
    public boolean isFirstVowel(){
        boolean result = false;
        char ch = Character.toLowerCase(word.toCharArray()[0]);
        char [] vowel = {'a','e','i','o','u','y'};
        for(int i = 0; i < vowel.length && result == false; i++){
            if (ch == vowel[i]){
                result = true;
            }
        }
        return result;
    }
    
    public boolean compareBySecondChar(MyWord otherMyWord){
        if(word.toCharArray().length > 1 && otherMyWord.word.toCharArray().length > 1){
            return this.word.toCharArray()[1] > otherMyWord.word.toCharArray()[1];
        }else{
            return false;
        }
    }
}
