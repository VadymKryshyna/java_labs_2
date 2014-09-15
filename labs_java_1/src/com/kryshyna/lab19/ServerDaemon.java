/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab19;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author epam
 */
public class ServerDaemon extends Thread{
    private Socket socket;
    private MessageSender sender;
    private int number;
    private InputStream is;
    private OutputStream os;
    private byte buf[] = new byte[64*1024];
    
    public ServerDaemon(MessageSender sender, int num, Socket socket) { 
        this.number = num; 
        this.socket = socket;
        this.sender = sender;
          
        setDaemon(true); 
        setPriority(NORM_PRIORITY);
        this.start();
    }
    
    @Override
    public void run(){
        try{
            is = socket.getInputStream(); 
            os = socket.getOutputStream();
            while(true ){
                this.readMessage();
            }
        }catch(Exception e) {
            System.out.println("init error: "+e);
        }finally{
            this.sender.sendMessageToAll("Close...");
            this.sender.removeSocket(this);
        } 
    }
    
    public void readMessage() throws IOException{
        int r = is.read(buf); 
        String data = new String(buf, 0, r); 
        this.sender.sendMessageToAll(data);
    }
    
    public void sendMessage(String message){
        try {
            os.write((message).getBytes());
            os.flush();
        } catch (IOException ex) {
            System.out.println("init error: "+ex);
        }
    }

}