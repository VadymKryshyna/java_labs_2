package com.kryshyna.lab03;


import java.awt.Color;



/**
 *
 * @author Kryshyna Vadym
 */
public class Square {
    private MyPoint point;
    private MySegment segment;
    private Color color;
    
    public Square(MyPoint point, MySegment segment){
        this.point = point;
        this.segment = segment;
        this.color = Color.black;
    }

    public Square(MyPoint point, MySegment segment, Color color){
        this.point = point;
        this.segment = segment;
        this.color = color;
    }

    public void setDemension(MySegment segment){
        this.segment = segment;
    }
    
    public void stretch(int i){
        //do thomething
    }

    public void compress(int i){
        //do thomething
    }

    public void rotate(){
        //do thomething
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (!this.point.equals(other.point))
            return false;
        if (!this.segment.equals(other.segment))
            return false;
        if (!this.color.equals(other.color))
            return false;
        return true;
    }    
    
    @Override
    public int hashCode() {
        int result;
        result = color.hashCode() + segment.hashCode() + point.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "@name"
                + " segment:"+ this.segment.toString()
                + " point:"+ this.point.toString()
                + " color:"+ this.color.toString();
    }

}
