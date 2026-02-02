package org.hojatrabajo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the StackImplemets class.
 * Tests core stack operations and edge cases.
 *
 * @author Carlos
 */
public class StackImplementsTest {

    private StackImplemets<Integer> stack;

    /**
     * Sets up a fresh stack instance before each test.
     * Ensures test isolation and independence.
     */
    @Before
    public void setUp() {
        stack = new StackImplemets<>();
    }

    /**
     * Tests that pop() throws RuntimeException when called on empty stack.
     * This ensures proper error handling for underflow conditions.
     */
    @Test(expected = RuntimeException.class)
    public void testPopOnEmptyStackThrowsException() {
        stack.pop();
    }

    /**
     * Tests basic push and peek operations.
     * Verifies that elements can be added and viewed correctly.
     */
    @Test
    public void testPushAndPeek() {
        stack.push(5);
        stack.push(10);

        assertEquals(Integer.valueOf(10), stack.peek());
    }

    /**
     * Tests LIFO (Last In First Out) property of the stack.
     * Validates correct order of elements when pushing and popping.
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
     * Tests peek operation returns top element without removing it.
     * Validates that peek is non-destructive (doesn't modify stack).
     */
    @Test
    public void testPeekDoesNotRemoveElement() {
        stack.push(42);

        Integer first = stack.peek();
        Integer second = stack.peek();

        assertEquals(first, second);
        assertEquals(Integer.valueOf(42), stack.pop());
    }

    /**
     * Tests complete push and pop cycle returning to empty state.
     * Ensures exception is thrown after emptying the stack.
     */
    @Test(expected = RuntimeException.class)
    public void testStackBecomesEmptyAfterPoppingAll() {
        stack.push(100);
        stack.push(200);

        stack.pop();
        stack.pop();
        stack.pop();
    }
}