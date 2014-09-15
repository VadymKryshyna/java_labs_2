package com.kryshyna.lab01;


/**
 *
 * @author Kryshyna Vadym
 */
public interface Container {
    
    void add(Element element);
    
    void remove(Element element);
    
    boolean contains(Element element);
    
    Element get(int index);
    
    int size();
}
