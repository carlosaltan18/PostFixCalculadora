package org.hojatrabajo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for StackVector implementation.
 * @author Carlos & Sergio
 */
public class StackVectorTest {

    private StackVector<Integer> stack;

    /**
     * Sets up a fresh stack before each test.
     */
    @Before
    public void setUp() {
        stack = new StackVector<>();
    }

    /**
     * Tests that pop throws exception on empty stack.
     */
    @Test(expected = RuntimeException.class)
    public void testPopOnEmptyStackThrowsException() {
        stack.pop();
    }

    /**
     * Tests that peek throws exception on empty stack.
     */
    @Test(expected = RuntimeException.class)
    public void testPeekOnEmptyStackThrowsException() {
        stack.peek();
    }

    /**
     * Tests basic push and peek operations.
     */
    @Test
    public void testPushAndPeek() {
        stack.push(5);
        stack.push(10);
        assertEquals("Peek should return the last element pushed", Integer.valueOf(10), stack.peek());
    }

    /**
     * Tests LIFO (Last In First Out) property.
     */
    @Test
    public void testLIFOOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    /**
     * Tests that peek does not remove the element.
     */
    @Test
    public void testPeekDoesNotRemoveElement() {
        stack.push(42);

        Integer first = stack.peek();
        Integer second = stack.peek();

        assertEquals("Multiple peeks should return the same value", first, second);
        assertEquals("Element should still be poppable after peek", Integer.valueOf(42), stack.pop());
    }

    /**
     * Tests that stack becomes empty after popping all elements.
     */
    @Test(expected = RuntimeException.class)
    public void testStackBecomesEmptyAfterPoppingAll() {
        stack.push(100);
        stack.push(200);

        stack.pop();
        stack.pop();
        stack.pop();
    }

    /**
     * Tests automatic resizing with many elements.
     */
    @Test
    public void testLargeNumberOfElements() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        for (int i = 99; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), stack.pop());
        }
    }

    /**
     * Tests stack with String type.
     */
    @Test
    public void testWithStringType() {
        StackVector<String> stringStack = new StackVector<>();

        stringStack.push("Hello");
        stringStack.push("World");

        assertEquals("World", stringStack.peek());
        assertEquals("World", stringStack.pop());
        assertEquals("Hello", stringStack.pop());
    }

    /**
     * Tests stack with Double type.
     */
    @Test
    public void testWithDoubleType() {
        StackVector<Double> doubleStack = new StackVector<>();

        doubleStack.push(3.14);
        doubleStack.push(2.71);

        assertEquals(Double.valueOf(2.71), doubleStack.pop());
        assertEquals(Double.valueOf(3.14), doubleStack.pop());
    }
}