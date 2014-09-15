package com.kryshyna.lab09;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class ArrayGraph implements Graph{
    private Integer[][] array;
    private boolean empty;
    
    public ArrayGraph(){
        this.array = new Integer[10][10];
        this.empty = true;
    }
    
    @Override
    public boolean addEdge(int vertex1, int vertex2, int length) {
        if ((this.empty==true)||(!this.hasEdge(vertex1, vertex2))){
            Integer lengthEdge = new Integer(length);
            this.array[vertex1][vertex2]= lengthEdge;
            this.array[vertex2][vertex1]= lengthEdge;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasEdge(int vertex1, int vertex2) {
        if(this.array[vertex1][vertex2]!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean hesVertex(int vertex) {
        boolean result = false;
        for (int i = 0; (result == false) && (i < this.array[vertex].length); i++){
            if(this.array[vertex][i]!=null){
                result = true;
            }
        }
        return result;
    }

    @Override
    public int getLength(int vertex1, int vertex2) {
        return (int)this.array[vertex1][vertex2];
    }

    @Override
    public int[] getListConnectVertex(int vertex) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < this.array[vertex].length; i++){
            if(this.array[vertex][i] != null){
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
}
