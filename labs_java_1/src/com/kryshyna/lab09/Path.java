package com.kryshyna.lab09;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class Path {
    private List<Integer> listVertex;
    private List<Integer> listLength;
    private boolean successful;
    private boolean complate;
    private int vertex1;
    private int vertex2;
    
    public Path(int vertex1, int vertex2){
        this.listLength = new ArrayList<>();
        this.listVertex = new ArrayList<>();
        this.complate = false;
        this.successful = false;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Path(Path path) {
        this.listVertex = new ArrayList<>(path.listVertex);
        this.listLength = new ArrayList<>(path.listLength);
        this.successful = path.successful;
        this.complate = path.complate;
        this.vertex1 = path.vertex1;
        this.vertex2 = path.vertex2;
    }
    
    public boolean addLength(int length){
        return this.listLength.add(new Integer(length));
    }
    
    public boolean addVertex(int vertex){
   //     if(this.listVertex.)
        return this.listVertex.add(new Integer(vertex));
    }
    
    public void complated(){
        this.complate = true;
    }

    public boolean isComplated(){
        return this.complate;
    }

    public void setSuccessful(){
        this.successful = true;
    }

    public boolean isSuccessful(){
        return this.successful;
    }
    
    public int getCountVertex(){
        return this.listVertex.size();
    }
    
    public int getSumLength(){
        int res = 0;
        for (int i = 0; i < this.listLength.size(); i++){
            res = res + this.listLength.get(i);
        }
        return res;
    }
    
    public int getVertex1(){
        return this.vertex1;
    }

    public int getVertex2(){
        return this.vertex2;
    }
}
