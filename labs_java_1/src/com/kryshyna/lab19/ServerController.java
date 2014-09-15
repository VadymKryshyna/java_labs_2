/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab19;

import java.net.InetAddress;
import java.net.ServerSocket;

/**
 *
 * @author epam
 */
public class ServerController  extends Thread {
    private ServerSocket server;
    private MessageSender sender;
    
    public ServerController(ServerView serverView){
        this.sender = new MessageSender(serverView);
        this.start();
    }
    
    
    @Override
    public void run(){
        try {
            this.sender.sendMessageToAll("Server start...");
            int countDemonServer = 0;
            server = new ServerSocket(4444, 0, InetAddress.getByName("localhost")); 
            this.sender.sendMessageToAll("Server work...");
            while(true){
                this.sender.addSocket(new ServerDaemon(this.sender, countDemonServer, server.accept())); 
                countDemonServer++;
            }
        } catch(Exception e) {
            System.out.println("init error: "+e);
        }
        finally{
            this.sender.sendMessageToAll("Server stop...");//.serverController.sendMessageToAll("Server stop...");
        }
    }
}