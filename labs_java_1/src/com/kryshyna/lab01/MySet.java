package com.kryshyna.lab01;

/**
 * @author Kryshyna Vadym
 */
public interface MySet {
    
    boolean add(Element element);
    
    
    boolean remove(Element element);
    
    boolean contains(Element element);
    
    Element get(int index);
    
    int size();
    
    boolean equals(MySet mySet);
    
    MySet union(MySet mySet);
    
    MySet intersection(MySet mySet);
    
    MySet difference(MySet mySet);
}
