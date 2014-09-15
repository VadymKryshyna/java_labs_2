package com.kryshyna.lab04;


import java.util.Date;


/**
 * @author Vadym Kryshyna
 */

public class Transfer {
    private String from;
    private String to;
    private Date date;
    private Driver driver;
    private Car car;
    private boolean complete;
    
    public Transfer(String from, String to, Date date){
        this.from = from;
        this.to = to;
        this.date = date;
    }
    
    public void setParametres(Car car, Driver driver){
        this.driver = driver;
        this.car = car;
        driver.setParametres(this, car);
    }
    
    public void complete(){
        this.complete = true; 
    }
    
    public boolean isComplete()
    {
        return this.complete;
    }
}
