/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

/**
 *
 * @author Kryshyna Vadym
 */
public class Plane {
    private String model;
    private String origin;
    private Chars chars;
    private Parameters parameters;
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("model="+model);
        sb.append("origin="+origin);
        sb.append(" chars:id="+chars.getId());
        sb.append(" type="+chars.getType());
        sb.append(" seat="+chars.getSeat());
        sb.append(" arming="+chars.getArming());
        sb.append(" rockets="+chars.getRockets());
        sb.append(" radar="+chars.getRadar());
        sb.append(" param:length="+parameters.getLength());
        sb.append(" width="+parameters.getWidth());
        sb.append(" height"+parameters.getHeight());
        sb.append(" price="+price);
         
        return sb.toString();
//        return "model="+model+" origin="+origin+" chars:type="+chars.getType()
//                +" seat="+chars.getSeat()+" arming="+chars.getArming()
//                +" rockets="+chars.getRockets()+" radar="+chars.getRadar()
//                +" param:length="+parameters.getLength()+" width="+parameters.getWidth()
//                + " height"+parameters.getHeight()+" price="+price;
    }
}

