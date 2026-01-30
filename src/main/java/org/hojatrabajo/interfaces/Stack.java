package org.hojatrabajo.interfaces;

/**
 * Interface of a stack
 * @author Carlos
 * @param <T> generic type
 */
public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
}

