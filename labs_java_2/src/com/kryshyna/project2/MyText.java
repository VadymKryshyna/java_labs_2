/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kryshyna Vadym
 */
public class MyText {
    private Map<Integer, MyWord> words;
    private Map<Integer, MyPunctuation> punctuations;
    private Map<Integer, MyDelimiter> delimiters;
    
    public MyText(){
        words = new HashMap<>();
        punctuations = new HashMap<>();
        delimiters = new HashMap<>();
    }
    
    public void addMyWord(int index, MyWord myWord){
        words.put(index, myWord);
    }
    
    public void addMySpace(int index, MyDelimiter myDelimiter){
        delimiters.put(index, myDelimiter);
    }

    public void addMyPunctuation(int index, MyPunctuation myPunc){
        punctuations.put(index, myPunc);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        int textLength = punctuations.size()+ delimiters.size()+ words.size();
        for (int i = 0; i < textLength; i++){
            if(words.containsKey(i)){
                str.append(words.get(i).toString());
            }else if(punctuations.containsKey(i)){
                str.append(punctuations.get(i).toString());
            }else if(delimiters.containsKey(i)){
                str.append(delimiters.get(i).toString());
            }
        }
        return str.toString();
    }
    
    public Map<Integer, MyWord> getWords() {
        return new HashMap(words);
    }

    public void setWords(Map<Integer, MyWord> words) {
        this.words = words;
    }

    public Map<Integer, MyPunctuation> getPunctuations() {
        return new HashMap(punctuations);
    }

    public void setPunctuations(Map<Integer, MyPunctuation> punctuations) {
        this.punctuations = punctuations;
    }

    public Map<Integer, MyDelimiter> getDelimiters() {
        return new HashMap(delimiters);
    }

    public void setDelimiters(Map<Integer, MyDelimiter> delimiters) {
        this.delimiters = delimiters;
    }

    
//    public String delimiters(){
//        StringBuilder str = new StringBuilder();
//        Integer[] index = delimiters.keySet().toArray(new Integer[0]);
//        for (int i = 0; i < index.length; i++){
//            str.append(delimiters.get(index[i]).toString());
//        }
//        return str.toString();
//    }
//
//    public String punctuations(){
//        StringBuilder str = new StringBuilder();
//        Integer[] index = punctuations.keySet().toArray(new Integer[0]);
//        for (int i = 0; i < index.length; i++){
//            str.append(punctuations.get(index[i]).toString());
//        }
//        return str.toString();
//    }
//
//    public String words(){
//        StringBuilder str = new StringBuilder();
//        Integer[] index = words.keySet().toArray(new Integer[0]);
//        Arrays.sort(index);
//        for (int i = 0; i < index.length; i++){
//            str.append(index[i].toString());
//            str.append("\n");
//            str.append(words.get(index[i]).toString());
//        }
//        return str.toString();
//    }
    
//    public MyText sortText(){
//        Map<Integer, MyWord> newWords = new HashMap(this.getWords());
//        Integer[] allKeys = newWords.keySet().toArray(new Integer[0]);
//        List<Integer> listKeysForSort = new ArrayList(); 
//        for(int i = 0; i < allKeys.length; i++){
//            if(newWords.get(allKeys[i]).isFirstVowel()){
//                listKeysForSort.add(i);
//            }
//        }
//        for(int i = 0; i < listKeysForSort.size()-1; i++){
//            for(int j = listKeysForSort.size()-1; j > i ; j--){
//                Integer key1 = listKeysForSort.get(j);
//                Integer key2 = listKeysForSort.get(j);
//                MyWord first = newWords.get(key1);
//                MyWord second = newWords.get(key2);
//                System.out.println(key1+ " " + key2);
//                System.out.println(first+ " " + second);
//                if(second.compareBySecondChar(first)){
//                    newWords.put(key2, first);
//                    newWords.put(key1, second);
//                }
//            }
//        }
//        MyText result = new MyText();
//        result.setDelimiters(this.getDelimiters());
//        result.setPunctuations(this.getPunctuations());
//        result.setWords(newWords);
//        return result;
//    }

}
