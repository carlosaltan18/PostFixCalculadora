package org.hojatrabajo;
import org.hojatrabajo.interfaces.Stack;

import java.util.ArrayList;

/**Class implements the interface stack
 * @author Carlos
 * @param <T>
 */
public class StackImplemets<T> implements Stack<T> {
    private ArrayList<T> items;
    private int top;

    public StackImplemets() {
        items = new ArrayList<>();
        top = -1;
    }

    /**
     * push de object un array
     * @param element object of any type
     */
    @Override
    public void push(T element) {
        items.add(element);
        top++;
    }

    /**
     * Method to delete de firts item in the stack
     * @return the first item in the stack
     */
    @Override
    public T pop() {
        if (top < 0) {
            throw new RuntimeException("Pila vacía");
        }
        T value = items.remove(top);
        top--;
        return value;
    }

    /**
     * class to get a item of stack
     * @return item of a stack
     */
    @Override
    public T peek() {
        if (top < 0) {
            throw new RuntimeException("Pila vacía");
        }
        return items.get(top);
    }
}