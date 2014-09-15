package com.kryshyna.lab01;


import java.util.LinkedList;

/**
 *
 * @author Kryshyna Vadym
 */
public class SetLinkedList implements MySet{
    private LinkedList<Element> linkedList;
    
    public SetLinkedList(){
        linkedList = new LinkedList<Element>();
    }

    public SetLinkedList(MySet mySet){
        this();
        for (int i = 0; i < mySet.size(); i++){
            this.add(mySet.get(i));
        }
    }
    
    @Override
    public boolean add(Element element) {
        if (!this.linkedList.contains(element)){
            return this.linkedList.add(element);
        }else{
            return false;
        }
    }


    @Override
    public boolean contains(Element element) {
        return this.linkedList.contains(element);
    }

    @Override
    public Element get(int index) {
        return (Element)this.linkedList.get(index);
    }

    @Override
    public int size() {
        return this.linkedList.size();
    }

    @Override
    public boolean remove(Element element) {
        return this.linkedList.remove(element);
    }

    @Override
    public boolean equals(MySet mySet) {
        if (mySet == null)
            return false;
        if (this.size() != mySet.size())
            return false;
        boolean result = true;
        for (int i = 0; (i < this.size()) &&(result == true); i++)
        {
            if (!mySet.contains(this.get(i)))
                result = false;
        }
        return result;
    }

    @Override
    public MySet union(MySet mySet) {
        MySet result = new SetLinkedList();
        for (int i = 0; i < this.size(); i++)
        {
            result.add(this.get(i));
        }
        for (int i = 0; i < mySet.size(); i++)
        {
            result.add(mySet.get(i));
        }
        return result;

    }

    @Override
    public MySet intersection(MySet mySet) {
        MySet result = new SetLinkedList();
        for (int i = 0; i < mySet.size(); i++)
        {
            if( this.contains(mySet.get(i))){
                result.add(mySet.get(i));
            }
        }
        return result;
    }

    @Override
    public MySet difference(MySet mySet) {
        MySet result = new SetLinkedList();
        for (int i = 0; i < this.size(); i++)
        {
            if( !mySet.contains(this.get(i))){
                result.add(this.get(i));
            }
        }
        for (int i = 0; i < mySet.size(); i++)
        {
            if( !this.contains(mySet.get(i))){
                result.add(mySet.get(i));
            }
        }
        return result;
    }

}
