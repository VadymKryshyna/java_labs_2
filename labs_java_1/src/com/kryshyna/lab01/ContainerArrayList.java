package com.kryshyna.lab01;


import java.util.ArrayList;

/**
 *
 * @author Kryshyna Vadym
 */
public class ContainerArrayList implements Container {
    private ArrayList<Element> arrayList;

    public ContainerArrayList(){
        arrayList = new ArrayList<Element>();
    }

    public ContainerArrayList(ContainerArrayList containerArrayList){
        arrayList.addAll(containerArrayList.arrayList);
    }
    
    @Override
    public void add(Element element) {
        arrayList.add(element);
    }

    @Override
    public void remove(Element element) {
        arrayList.remove(element);
    }

    @Override
    public boolean contains(Element element) {
        return arrayList.contains(element);
    }

    @Override
    public Element get(int index) {
        return arrayList.get(index);
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}
