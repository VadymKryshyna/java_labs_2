/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kryshyna Vadym
 */
public final class MyProcessor {
  //  private int countPartText;
    
    private MyProcessor(){
        //countPartText = 0;
    }
    
    public static MyText readTextFromFile(String filename){
        MyText myText = new MyText();
        List<char[]> charList = readFile(filename);
        for(int i = 0; i < charList.size(); i++){
            parseCharArray(charList.get(i), myText);
        }
        return myText;
    }
    
    private static void parseCharArray(char[] charArray, MyText myText){
        int countPartText = 0;
        List<Character> charList = null;
        boolean newWord = false;
        boolean newDelimeter = false;
        for(int i = 0; i < charArray.length; i++){
            if(isPartOfWord(charArray[i])){
                if (newWord == false){
                    newWord = true;
                    charList = new ArrayList<>();
                    charList.add(charArray[i]);
                    if(newDelimeter==true){
                        newDelimeter = false;
                    }
                }else{
                    charList.add(charArray[i]);
                }
            }else{
                if(newWord == true && charList.size()>0){
                    char[] word = new char[charList.size()];
                    for (int j = 0; j < charList.size(); j++){
                        word[j] = charList.get(j);
                    }
                    charList = null;
                    newWord = false;
                    myText.addMyWord(countPartText++, new MyWord(new String(word)));
                }
                if(isPunctuation(charArray[i])){
                    myText.addMyPunctuation(countPartText++, new MyPunctuation(charArray[i]));
                    if(newDelimeter==true){
                        newDelimeter = false;
                    }
                }else if(isDelimeter(charArray[i])){
                    if(newDelimeter==false){
                        myText.addMySpace(countPartText++, new MyDelimiter(charArray[i]));
                        newDelimeter=true;
                    }
                }
            }
        }
        if(newWord == true){
            char[] word = new char[charList.size()];
            for (int j = 0; j < charList.size(); j++){
               word[j] = charList.get(j);
            }
            charList = null;
            newWord = false;
            myText.addMyWord(countPartText++, new MyWord(new String(word)));
        }
    }
    
    private static List<char[]> readFile(String filename){
        List<char[]> charList = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine())!=null){
                charList.add(str.toCharArray());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return charList;
    }
    
    private static boolean isPunctuation(char ch){
        boolean result = false;
        switch(ch){
            case '.':
            case ',':
            case '!':
            case '?':
            case '-':
                result = true; break;
        }
        return result;
    }

    private static boolean isPartOfWord(char ch){
        return Character.isLetterOrDigit(ch);
    }

    private static boolean isDelimeter(char ch){
        return Character.isSpaceChar(ch);
    }
    
    public static MyText sortText(MyText myText){
        Map<Integer, MyWord> words = myText.getWords();
        Integer[] allKeys = words.keySet().toArray(new Integer[0]);
        List<Integer> listKeysForSort = new ArrayList(); 
        for(int i = 0; i < allKeys.length; i++){
            if(words.get(allKeys[i]).isFirstVowel()){
                listKeysForSort.add(allKeys[i]);
            }
        }
        Integer []arrayKeysForSort = listKeysForSort.toArray(new Integer[0]);
        Arrays.sort(arrayKeysForSort);
        for(int i = 0; i < arrayKeysForSort.length-1; i++){
            for(int j = arrayKeysForSort.length-1; j > i ; j--){
                Integer key1 = arrayKeysForSort[j];
                Integer key2 = arrayKeysForSort[j-1];
                MyWord first = words.get(key1);
                MyWord second = words.get(key2);
                if(second.compareBySecondChar(first)){
                    words.put(key2, first);
                    words.put(key1, second);
                }
            }
        }
        MyText result = new MyText();
        result.setDelimiters(myText.getDelimiters());
        result.setPunctuations(myText.getPunctuations());
        result.setWords(words);
        return result;
    }
}
