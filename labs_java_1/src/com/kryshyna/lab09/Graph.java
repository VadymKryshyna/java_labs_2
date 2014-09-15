package com.kryshyna.lab09;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
interface Graph {
    public boolean addEdge(int vertex1, int vertex2, int length);
    
    public boolean hasEdge(int vertex1, int vertex2);
    
    public boolean hesVertex(int vertex);
    
    public int getLength(int vertex1, int vertex2);
    
    public int[] getListConnectVertex(int vertex);
}
