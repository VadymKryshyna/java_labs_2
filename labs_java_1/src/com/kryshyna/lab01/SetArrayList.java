package com.kryshyna.lab01;


import java.util.ArrayList;

/**
 *
 * @author Kryshyna Vadym
 */
public class SetArrayList implements MySet{
    private ArrayList<Element> arrayList;
    
    public SetArrayList(){
        arrayList = new ArrayList<Element>();
    }
    
    public SetArrayList(MySet mySet){
        this();
        for (int i = 0; i < mySet.size(); i++){
            this.add(mySet.get(i));
        }
    }
    
    @Override
    public boolean add(Element element) {
        if(!this.contains(element)){
            return this.arrayList.add(element);
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Element element) {
        return this.arrayList.remove(element);
    }

    @Override
    public boolean contains(Element element) {
        return this.arrayList.contains(element);
    }

    @Override
    public Element get(int index) {
        return this.arrayList.get(index);
    }

    @Override
    public int size() {
        return this.arrayList.size();
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
        MySet result = new SetArrayList();
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
        MySet result = new SetArrayList();
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
        MySet result = new SetArrayList();
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
