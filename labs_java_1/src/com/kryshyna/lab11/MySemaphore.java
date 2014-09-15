package com.kryshyna.lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vadym Kryshyna
 */
public class MySemaphore {
    private int counter;
    private Queue<Thread> queue;

    public MySemaphore() {
        this(0);
    }

    public MySemaphore(int i) {
        if (i < 0){
            throw new IllegalArgumentException(i + " < 0");
        }
        this.queue = new PriorityQueue<>();
        this.counter = i;
    }

    public synchronized void release() {
        this.counter++;
        if (this.queue.size() != 0) {
            this.queue.peek().notify();
        }
    }

    public synchronized void acquire() throws InterruptedException {
        if(this.counter == 0){
            this.queue.add(Thread.currentThread());
            Thread.currentThread().wait();
        }else if(this.counter > 0 && this.queue.size() == 0){
            this.counter--;
        }else if(Thread.currentThread().getId() == this.queue.peek().getId()){
            this.queue.poll();
            this.counter--;
        } else{
            if(!this.queue.contains(Thread.currentThread())){
                this.queue.add(Thread.currentThread());
                this.queue.peek().notify();
                Thread.currentThread().wait();
            }else{
                this.queue.peek().notify();
                Thread.currentThread().wait();
            }
        }
    }
    
/*
    public synchronized void acquire() throws InterruptedException {
        if(this.counter == 0){
            this.queue.add(Thread.currentThread());
            Thread.currentThread().wait();
        }else if(this.counter > 0 && this.queue.size() == 0){
            this.counter--;
        }else{
            if(Thread.currentThread().getId() == this.queue.peek().getId()){
                this.queue.poll();
                this.counter--;
            }else{
                if(!this.queue.contains(Thread.currentThread())){
                    this.queue.add(Thread.currentThread());
                    this.queue.peek().notify();
                    Thread.currentThread().wait();
                }else{
                    this.queue.peek().notify();
                    Thread.currentThread().wait();
                }
            }
        }
    }

*/

}
