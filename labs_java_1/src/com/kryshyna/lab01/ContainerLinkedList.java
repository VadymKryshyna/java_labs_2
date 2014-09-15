package com.kryshyna.lab01;


import java.util.LinkedList;


/**
 *
 * @author Kryshyna Vadym
 */
public class ContainerLinkedList implements Container{
    private LinkedList<Element> linkedList;
    
    public ContainerLinkedList(){
        linkedList = new LinkedList<Element>();
    }

    public ContainerLinkedList(ContainerLinkedList containerLinkedList){
        linkedList.addAll(containerLinkedList.linkedList);
    }

    @Override
    public void add(Element element) {
        linkedList.add(element);
    }

    @Override
    public void remove(Element element) {
        linkedList.remove(element);
    }

    @Override
    public boolean contains(Element element) {
        return linkedList.contains(element);
    }

    @Override
    public Element get(int index) {
        return linkedList.get(index);
    }

    @Override
    public int size() {
        return linkedList.size();
    }
    
}
