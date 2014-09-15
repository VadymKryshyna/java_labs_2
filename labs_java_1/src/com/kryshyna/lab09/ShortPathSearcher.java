package com.kryshyna.lab09;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epam
 */
public class ShortPathSearcher extends Thread {
    private List<PathSearcher> listPathSearchers;
    private Graph graph;
    private List<Path> path;
    private int vertex1;
    private int vertex2;
    private int count;
    private Path shortPath;
    
    public ShortPathSearcher(Graph graph, int vertex1, int vertex2){
        this.graph = graph;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.path = new ArrayList<>();
        this.listPathSearchers = new ArrayList<>();
    }
    
    public void addSearcherTrack(PathSearcher pathSearcher){
        this.listPathSearchers.add(pathSearcher);
    }
    
    public synchronized void countUp(){
        this.count = this.count + 1;
    }

    public synchronized void countDown(){
        this.count = this.count - 1;
    }

    public synchronized void addPath(Path path){
        this.path.add(path);
    }
    
    @Override
    public void run(){
        if (this.graph.hasEdge(vertex1, vertex2)){
            shortPath = new Path(vertex1, vertex2);
            shortPath.addLength(this.graph.getLength(vertex1, vertex2));
            return;
        }
        if ((this.graph.hesVertex(vertex1)==false)&&
                (this.graph.hesVertex(vertex1)==false)){
            shortPath = new Path(vertex1, vertex2);
            shortPath.addLength(0);
            return;
        }
        
        PathSearcher searcher = new PathSearcher(graph, new Path(vertex1, vertex2),
                this);
        searcher.start();
        
        try {
            while(this.count!=0){
                this.wait(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ShortPathSearcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.shortPath = this.path.get(0);
        for(int i = 1; i < this.path.size(); i++){
            if(this.path.get(i).getSumLength() < this.shortPath.getSumLength()){
                this.shortPath = this.path.get(i);
            }
        }
    }
    
}
