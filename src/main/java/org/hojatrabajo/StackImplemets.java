package org.hojatrabajo;
import org.hojatrabajo.interfaces.Stack;

import java.util.ArrayList;

public class StackImplemets<T> implements Stack<T> {
    private ArrayList<T> items;
    private int top;

    public StackImplemets() {
        items = new ArrayList<>();
        top = -1;
    }

    @Override
    public void push(T element) {
        items.add(element);
        top++;
    }

    @Override
    public T pop() {
        if (top < 0) {
            throw new RuntimeException("Pila vacía");
        }
        T value = items.remove(top);
        top--;
        return value;
    }

    @Override
    public T peek() {
        if (top < 0) {
            throw new RuntimeException("Pila vacía");
        }
        return items.get(top);
    }
}