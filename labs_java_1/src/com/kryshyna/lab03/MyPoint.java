package com.kryshyna.lab03;

/**
 *
 * @author Kryshyna Vadym
 */
public class MyPoint {
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyPoint other = (MyPoint) obj;
        if (this!=other)
            return false;
        return true;
    }    

    @Override
    public int hashCode() {
        int result;
        result = super.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "@name";
    }
}
