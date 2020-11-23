package ua.edu.ucu.collections.immutable;


import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testConstruct() {
        ImmutableArrayList arr = new ImmutableArrayList();
        assertArrayEquals(new Object[] {}, arr.toArray());
        assertEquals(0, arr.size());
    }

    @Test
    public void testAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();

        // adding to empty list
        arr = arr.add("first item");
        assertArrayEquals(new Object[] {"first item"},
                arr.toArray());
        assertEquals(1, arr.size());

        // adding to non-empty list
        arr = arr.add(2);
        assertArrayEquals(new Object[] {"first item", 2},
                arr.toArray());
        assertEquals(2, arr.size());


    }

    @Test
    public void testInsertAdd() {
        ImmutableArrayList arr = new ImmutableArrayList();

        // adding to empty list
        arr = arr.add(0, "first item");
        assertArrayEquals(new Object[] {"first item"}, arr.toArray());
        assertEquals(1, arr.size());

        // adding to non-empty list
        arr = arr.add(0, 2);
        assertArrayEquals(new Object[] {2, "first item"},
                arr.toArray());
        assertEquals(2, arr.size());


    }

    @Test
    public void testAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();

        // adding to empty list
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());
        assertEquals(4, arr.size());

        // adding to non-empty list
        arr = arr.addAll( new Object[] {2.5, -3});
        assertArrayEquals(new Object[] {"first item", 2, 3, 4, 2.5, -3},
                arr.toArray());
        assertEquals(6, arr.size());

    }

    @Test
    public void testInsertAddAll() {
        ImmutableArrayList arr = new ImmutableArrayList();

        // adding to empty list
        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());
        assertEquals(4, arr.size());

        // adding to non-empty list
        arr = arr.addAll(2, new Object[] {2.5, -3});
        assertArrayEquals(new Object[] {"first item", 2, 2.5, -3, 3, 4},
                arr.toArray());
        assertEquals(6, arr.size());

    }

    @Test
    public void testGet() {
        ImmutableArrayList arr = new ImmutableArrayList();

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});

        assertEquals("first item", arr.get(0));
        assertEquals(4, arr.get(3));

        arr = arr.addAll(2, new Object[] {2.5, -3});
        assertEquals("first item", arr.get(0));
        assertEquals(-3, arr.get(3));

    }

    @Test
    public void testRemove() {
        ImmutableArrayList arr = new ImmutableArrayList();

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        arr = arr.remove(0);
        assertArrayEquals(new Object[] {2, 3, 4}, arr.toArray());

        arr = arr.addAll(2, new Object[] {2.5, -3});
        arr = arr.remove(1);
        assertArrayEquals(new Object[] {2, 2.5, -3, 4}, arr.toArray());

    }

    @Test
    public void testSet() {
        ImmutableArrayList arr = new ImmutableArrayList();

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        arr = arr.set(0, 1);
        assertArrayEquals(new Object[] {1, 2, 3, 4}, arr.toArray());

        arr = arr.set(3, 3);
        assertArrayEquals(new Object[] {1, 2, 3, 3}, arr.toArray());

    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList arr = new ImmutableArrayList();

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});

        assertEquals(0, arr.indexOf("first item"));

        assertEquals(-1, arr.indexOf("second item"));

    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList arr = new ImmutableArrayList();

        assertEquals(true, arr.isEmpty());

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        assertEquals(false, arr.isEmpty());

    }

    @Test
    public void clear() {
        ImmutableArrayList arr = new ImmutableArrayList();

        arr = arr.clear();
        assertArrayEquals(new Object[] {}, arr.toArray());

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        arr = arr.clear();
        assertArrayEquals(new Object[] {}, arr.toArray());

    }

    @Test
    public void testSize() {
        ImmutableArrayList arr = new ImmutableArrayList();

        assertEquals(0, arr.size());

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});

        assertEquals(4, arr.size());

        arr = arr.add(6);
        assertEquals(5, arr.size());

    }

    @Test
    public void testToArray() {

        ImmutableArrayList arr = new ImmutableArrayList();

        assertArrayEquals(new Object[] {}, arr.toArray());

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});

        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());


        arr = arr.add(6);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4, 6},
                arr.toArray());

    }

    @Test
    public void testToString() {

        ImmutableArrayList arr = new ImmutableArrayList();

        assertEquals("[]", arr.toString());

        arr = arr.addAll(0, new Object[] {"first item", 2, 3, 4});

        assertEquals("[first item, 2, 3, 4]", arr.toString());


        arr = arr.add(6);
        assertEquals("[first item, 2, 3, 4, 6]", arr.toString());

    }

    @Test
    public void testImmutability() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});

        arr.add(1);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.add(2, 1);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.addAll(new Object[] {"first item", 2, 3, 4});
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.addAll(0, new Object[] {"first item", 2, 3, 4});
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.indexOf(2);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.indexOf(0);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.set(0, 3);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.get(0);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.size();
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.remove(1);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.clear();
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.remove(2);
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.isEmpty();
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());

        arr.toArray();
        assertArrayEquals(new Object[] {"first item", 2, 3, 4},
                arr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.add(100, "test");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.addAll(100, new Object[] {"test"});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddSecondError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.add(-100, "test");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllSecondError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.addAll(-100, new Object[] {"test"});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSecondError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.remove(-100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSecondError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.get(-100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.set(100, "test");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetSecondError() {
        ImmutableArrayList arr = new ImmutableArrayList();
        arr = arr.addAll(new Object[] {"first item", 2, 3, 4});
        arr.set(-100, "test");

    }

}
