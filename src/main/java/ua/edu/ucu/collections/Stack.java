package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    // LIFO
    private ImmutableLinkedList data;

    public Stack() {
        data = new ImmutableLinkedList();
    }

    public void push(Object obj) {
        data = data.addLast(obj);
    }

    public Object peek() {
        return data.getLast();
    }

    public Object pop() {
        Object obj = peek();
        data = data.removeLast();
        return obj;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Object[] getData() {
        return data.toArray();
    }
}
