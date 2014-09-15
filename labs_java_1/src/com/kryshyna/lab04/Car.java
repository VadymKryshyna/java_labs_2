package com.kryshyna.lab04;


import java.util.Date;


/**
 * @author Vadym Kryshyna
 */

public class Car {
    private String brand;
    private Date dateIssue;
    private boolean workingState;
    private boolean busy;
    
    public Car(String brand, Date dateIssue)
    {
        this.brand = brand;
        this.dateIssue = dateIssue;
        this.workingState = true;
        this.busy = false;
    }
    
    public void needRepair()
    {
        this.workingState = false;
    }
    
    public boolean isWorking()
    {
        return this.workingState;
    }
    
    public boolean setBusy()
    {
        if (this.busy = false)
        {
            this.busy = true;
            return true;
        }
        return false;
    }
    
    public boolean isBusy()
    {
        return this.busy;
    }

    public void setFree()
    {
        this.busy = false;
    }
    
    public void repair()
    {
        this.workingState = true;
    }

}
