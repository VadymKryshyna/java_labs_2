package com.kryshyna.lab04;


import java.util.ArrayList;

/**
 *
 * @author Vadym Kryshyna
 */

public class AutoCenter {
    private ArrayList<Car> cars;
    private ArrayList<Driver> drivers;
    private ArrayList<Transfer> listOpenTransfer;
    private ArrayList<Transfer> listRunTransfer;
    private ArrayList<Transfer> listCloseTransfer;
    private Dispatcher dispatcher;
    
    public AutoCenter(Dispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }
    
    public boolean addCar(Car car)
    {
        return this.cars.add(car);
    }
    
    public boolean addDriver(Driver driver)
    {
        return this.drivers.add(driver);
    }
    
    public boolean addTransfer(Transfer transfer)
    {
        return this.listOpenTransfer.add(transfer);
    }

    public void startTransfer()
    {
        if(this.listOpenTransfer.size() == 0)
        {
            return;
        }
        if(this.cars.size() == 0)
        {
            return;
        }
        if(this.drivers.size() == 0)
        {
            return;
        }
        Transfer transfer = this.listOpenTransfer.get(0);
        transfer.setParametres(this.cars.get(0), this.drivers.get(0));
        this.listRunTransfer.add(transfer);
        this.listOpenTransfer.remove(transfer);
    }
    
    public void repairCars()
    {
        for (int  i = 0; i < this.cars.size(); i++)
        {
            if (!this.cars.get(i).isWorking())
            {
                this.cars.get(i).repair();
            }
        }
    }

}

class Dispatcher {
    private  String name;
    
    public Dispatcher(String name)
    {
        this.name = name;
    }
    
    
}