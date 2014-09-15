/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Реализовать собственный mutex на основе алгоритма Петерсона.

package com.kryshyna.lab16;

//import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

/**
 *
 * @author epam
 */
public class MyMutex {
    private Long threadID = null;
    private boolean turn = false;
 
    void enterRegion(){
        while (this.turn);
        this.threadID = Thread.currentThread().getId();
        this.turn = true;
    }
 
    void leaveRegion(int threadId){
        if(Thread.currentThread().getId() == this.threadID){
            this.turn = false;
            this.threadID = null;
            notify();
        }
    }
}




/*
class MyMutex {
    protected boolean inuse_ = false;

    public void acquire() throws InterruptedException {
        if (Thread.interrupted()) throw new InterruptedException();
        synchronized(this) {
            try {
                while (inuse_) wait();
                inuse_ = true;
            }catch (InterruptedException ex) {
                notify();
                throw ex;
            }
        }
    }

    public synchronized void release(){
        inuse_ = false;
        notify();
    }


    public boolean attempt(long msecs) throws InterruptedException {
        if (Thread.interrupted()) throw new InterruptedException();
        synchronized(this) {
            if (!inuse_) {
                inuse_ = true;
                return true;
            } else if (msecs <= 0){
                return false;
            } else {
                long waitTime = msecs;
                long start = System.currentTimeMillis();
                try {
                    for (;;) {
                        wait(waitTime);
                        if (!inuse_) {
                            inuse_ = true;
                            return true;
                        } else {
                            waitTime = msecs - (System.currentTimeMillis() - start);
                            if (waitTime <= 0){
                                return false;
                            }
                        }
                    }
                }
                catch (InterruptedException ex) {
                    notify();
                    throw ex;
                }
            }
        }
    }
}
*/