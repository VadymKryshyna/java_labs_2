package com.kryshyna.lab04;


import java.util.Date;


/**
 * @author Vadym Kryshyna
 */

public class Driver {
    private String name;
    private String surname;
    private Date birthday;
    private Car car;
    private Transfer transfer;
    private boolean busy;
    
    public Driver(String name, String surname, Date birthday)
    {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.busy = false;
    }
    
    public void setParametres(Transfer transfer, Car car)
    {
        this.car = car;
        this.transfer = transfer;
        this.busy = true;
    }
    
    public void completeTransfer()
    {
        this.transfer.complete();
        this.transfer = null;
        this.car.setFree();
        this.car = null;
        this.busy = false;
    }
    
}
