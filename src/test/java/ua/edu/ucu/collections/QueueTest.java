package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testConstruct() {
        Queue queue = new Queue();
        assertArrayEquals(new Object[] {}, queue.getData());

    }

    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue("first item");
        assertArrayEquals(new Object[] {"first item"},
                queue.getData());
        queue.enqueue("second item");
        assertArrayEquals(new Object[] {"first item", "second item"},
                queue.getData());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue("first item");
        queue.enqueue("second item");

        assertEquals("first item", queue.dequeue());
        assertArrayEquals(new Object[] {"second item"},
                queue.getData());
        assertEquals("second item", queue.dequeue());
        assertArrayEquals(new Object[] {}, queue.getData());
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue("first item");
        assertEquals("first item", queue.peek());
        assertArrayEquals(new Object[] {"first item"},
                queue.getData());
        queue.enqueue("second item");
        assertEquals("first item", queue.peek());
        assertArrayEquals(new Object[] {"first item", "second item"},
                queue.getData());
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue();

        assertEquals(true, queue.isEmpty());
        assertArrayEquals(new Object[] {}, queue.getData());

        queue.enqueue("first item");
        assertEquals(false, queue.isEmpty());
        assertArrayEquals(new Object[] {"first item"},
                queue.getData());

    }

    @Test
    public void testGetData() {
        Queue queue = new Queue();

        assertArrayEquals(new Object[] {}, queue.getData());

        queue.enqueue("first item");
        assertArrayEquals(new Object[] {"first item"},
                queue.getData());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueError() {
        Queue queue = new Queue();
        queue.dequeue();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekError() {
        Queue queue = new Queue();
        queue.peek();
    }
    
}
