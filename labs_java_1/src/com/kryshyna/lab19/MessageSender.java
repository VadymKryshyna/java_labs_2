/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab19;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author epam
 */
public class MessageSender extends Thread{
    private List <ServerDaemon> listDaemon;
    private ServerView serverView;
    
    public MessageSender(ServerView serverView){
        this.listDaemon = new ArrayList<>();
        this.serverView = serverView;
    }
    
    public synchronized void removeSocket(ServerDaemon sd){
        this.listDaemon.remove(sd);
    }
    
    public synchronized void addSocket(ServerDaemon serverDaemon) {
        this.listDaemon.add(serverDaemon);
    }
    
    public synchronized void sendMessageToAll(String message){
        this.serverView.sendMessage(message);
        for(ServerDaemon daemon:this.listDaemon){
            daemon.sendMessage(message);
        }
    }

}
