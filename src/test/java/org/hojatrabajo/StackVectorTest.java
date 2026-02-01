package org.hojatrabajo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the StackVector implementation
 */
public class StackVectorTest {

    @Test
    public void testPushAndPop() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(10);
        stack.push(20);
        Integer result1 = stack.pop();
        assertEquals("The last element pushed (20) should be popped first", Integer.valueOf(20), result1);
        Integer result2 = stack.pop();
        assertEquals("The first element pushed (10) should be popped second", Integer.valueOf(10), result2);
    }

    @Test
    public void testPeek() {
        StackVector<String> stack = new StackVector<>();
        stack.push("Hello");
        stack.push("World");
        String result = stack.peek();
        assertEquals("Peek should return the last element", "World", result);
        assertEquals("Stack size should remain 2 after peek", 2, stack.size());
    }

    @Test
    public void testIsEmpty() {
        StackVector<Double> stack = new StackVector<>();
        assertTrue("New stack should be empty", stack.isEmpty());
        stack.push(5.5);
        assertFalse("Stack should not be empty after push", stack.isEmpty());
        stack.pop();
        assertTrue("Stack should be empty after removing all elements", stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        StackVector<Integer> stack = new StackVector<>();
        Integer result = stack.pop();
        assertNull("Popping an empty stack should return null", result);
    }
}