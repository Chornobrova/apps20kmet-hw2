package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testConstruct() {
        Stack stack = new Stack();
        assertArrayEquals(new Object[] {}, stack.getData());

    }

    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push("first item");
        assertArrayEquals(new Object[] {"first item"},
                stack.getData());
        stack.push("second item");
        assertArrayEquals(new Object[] {"first item", "second item"},
                stack.getData());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push("first item");
        stack.push("second item");

        assertEquals("second item", stack.pop());
        assertArrayEquals(new Object[] {"first item"},
                stack.getData());
        assertEquals("first item", stack.pop());
        assertArrayEquals(new Object[] {}, stack.getData());
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push("first item");
        assertEquals("first item", stack.peek());
        assertArrayEquals(new Object[] {"first item"},
                stack.getData());
        stack.push("second item");
        assertEquals("second item", stack.peek());
        assertArrayEquals(new Object[] {"first item", "second item"},
                stack.getData());
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();

        assertEquals(true, stack.isEmpty());
        assertArrayEquals(new Object[] {}, stack.getData());

        stack.push("first item");
        assertEquals(false, stack.isEmpty());
        assertArrayEquals(new Object[] {"first item"},
                stack.getData());

    }

    @Test
    public void testGetData() {
        Stack stack = new Stack();

        assertArrayEquals(new Object[] {}, stack.getData());

        stack.push("first item");
        assertArrayEquals(new Object[] {"first item"},
                stack.getData());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopError() {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekError() {
        Stack stack = new Stack();
        stack.peek();
    }
    
}
