/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.lab19;

import java.util.ArrayList;

/**
 *
 * @author epam
 */
public class Main {
    
    public static void main(String args[]) {
        final ServerView view = new ServerView();
        view.sendMessage("hello");
        final ServerController controller = new ServerController(view);
        
        pause();
        ClientView client1 = new ClientView(1, 1, 0);
        pause();
        ClientView client2 = new ClientView(2, 2, 0);
        pause();
        ClientView client3 = new ClientView(3, 3, 0);
        pause();
        client2.stopClient();
        pause();
        client3.stopClient();
        
//        ArrayList<ClientView> clients = new ArrayList<>();
//        for (int i = 0, n = 0; i < 5; i++){
//            for (int j = 0; j < 2; j++){
//                if(i == 0 && j == 0){
//                    continue;
//                }
//                clients.add(new ClientView(n, i, j));
//                n++;
//            }
//        }
        
        while (true){}

//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                int i = 0;
//                while (true){
//                    String string = "its "+ i;
//                    view.sendMessage(string);
//                    i++;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException ex) {
//                    }
//                }
//            }
//        }).start();
    }
    
    public static void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("pause " + ex);
        }
    }
    
}
