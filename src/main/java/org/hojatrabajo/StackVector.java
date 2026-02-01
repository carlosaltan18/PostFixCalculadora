package org.hojatrabajo;

import org.hojatrabajo.interfaces.Stack;
import java.util.Vector;

/**
 * Stack implementation using a Vector
 * @author Sergio
 * @param <T> generic type of the elements
 */
public class StackVector<T> implements Stack<T> {

    private Vector<T> vector;

    public StackVector() {
        this.vector = new Vector<>();
    }

    @Override
    public void push(T value) {
        vector.add(value);
    }

    @Override
    public T pop() {
        if (vector.isEmpty()) {
            return null;
        }
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        if (vector.isEmpty()) {
            return null;
        }
        return vector.lastElement();
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public int size() {
        return vector.size();
    }
}