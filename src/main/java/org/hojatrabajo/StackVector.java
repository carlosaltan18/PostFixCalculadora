package org.hojatrabajo;

import org.hojatrabajo.interfaces.Stack;

/**
 * Stack implementation using an array.
 * @param <T> type of elements in the stack
 * @author Sergio & Carlos
 */
public class StackVector<T> implements Stack<T> {

    private T[] pila;
    private int top;

    public StackVector(int capacity) {
        pila = (T[]) new Object[capacity];
        top = -1;
    }

    public StackVector() {
        this(100);
    }

    @Override
    public void push(T value) {
        ++top;
        pila[top] = value;
    }

    @Override
    public T pop() {
        if (top == -1) {
            return null;
        }
        T element = pila[top];
        pila[top] = null;
        top--;
        return element;
    }

    @Override
    public T peek() {
        if (top == -1) {
            return null;
        }
        return pila[top];
    }
}