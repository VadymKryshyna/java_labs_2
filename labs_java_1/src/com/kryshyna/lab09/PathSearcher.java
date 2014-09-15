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
public class PathSearcher extends Thread{
    private Graph graph;
    private Path path;
    private ShortPathSearcher searcherShortTrack;
    
    public PathSearcher(Graph graph, Path path, ShortPathSearcher searcherShortTrack){
        this.graph = graph;
        this.path = new Path(path);
        this.searcherShortTrack = searcherShortTrack;
    }
    
    @Override
    public void run(){
        this.searcherShortTrack.countUp();
        this.searcherShortTrack.addPath(path);
        this.searcherShortTrack.addSearcherTrack(this);

        int [] arrayVertex = this.graph.getListConnectVertex(this.path.getVertex1());
        
        for (int i = 0; i < arrayVertex.length; i++){
//
//            
            if(true){
               PathSearcher el = new PathSearcher(graph, path, searcherShortTrack);
               el.start();
            }
        }

        
        
        this.searcherShortTrack.countUp();
    }
}
