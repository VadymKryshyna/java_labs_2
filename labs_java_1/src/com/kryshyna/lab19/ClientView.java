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
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author epam
 */
public class ClientView  extends JFrame implements Runnable{
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private String name;
    private InputStream is;
    private OutputStream os;
    private byte buffer[] = new byte[64*1024];
    private boolean flag;
    private Socket socket;

    public ClientView(int i, int x, int y) {
        super();
        this.name = "Client " + i;
        this.setTitle(name);
        this.flag = true;
        this.initComponents(x, y);
        new Thread(this).start();
    }

    private void initComponents(int x, int y) {
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
        this.setSize(280, 300);
        this.setLocation(280*x, 300*y);
        this.setVisible(true);
    }                        

    private void showMessage(String string){
        jTextArea1.append(string+"\n");
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }

    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 4444);
            is = socket.getInputStream(); 
            os = socket.getOutputStream();
            this.sendMessage(this.name + " start");
            while(true){
                if (this.flag==false){
                    Thread.currentThread().interrupt();
                }
                this.readMessage();
            }
        } catch (IOException ex) {
            System.out.println("init error: "+ex);
        }
    }
    
    public void readMessage() throws IOException{
        int sizeAnswer = is.read(buffer);
        if(sizeAnswer > 0){
            String answer = new String(buffer, 0, sizeAnswer);
            this.showMessage(answer);
        }
    }
    
    public void sendMessage(String message){
        try {
            os.write(message.getBytes());
            os.flush();
        } catch (IOException ex) {
            System.out.println("init error: "+ex);
        }
    }
    
    public void stopClient(){
        this.flag = false;
        this.sendMessage(this.name + " finish.");
        this.dispose();
        System.out.println("stop");
    }
}

