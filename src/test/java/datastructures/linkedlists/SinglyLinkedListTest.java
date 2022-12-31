package datastructures.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testAdd() {
        assertEquals(-1, list.indexOf(1));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.getSize());
        assertEquals(2, list.indexOf(3));
    }

    @Test
    public void testAddToHead() {
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        assertEquals(4, list.getSize());
        assertEquals(3, list.indexOf(1));
        assertEquals(0, list.indexOf(4));
    }

    @Test
    public void testRemoveLast() {
        assertNull(list.removeLast());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.removeLast());
        assertEquals(3, list.removeLast());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveFirst() {
        assertNull(list.removeFirst());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(4, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIndexOf() {
        assertEquals(-1, list.indexOf(10));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(2, list.indexOf(3));
        list.add(10);
        assertEquals(4, list.indexOf(10));
        list.addToHead(10);
        assertEquals(0, list.indexOf(10));
        list.removeFirst();
        assertEquals(4, list.indexOf(10));
        list.removeFirst();
        assertEquals(1, list.indexOf(3));
        list.removeLast();
        assertEquals(-1, list.indexOf(10));
    }

    @Test
    public void testContains() {
        assertFalse(list.contains(10));
        list.add(10);
        assertTrue(list.contains(10));
        list.removeFirst();
        assertFalse(list.contains(10));
    }

    @Test
    public void testGetSize() {
        assertEquals(0, list.getSize());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        assertEquals(7, list.getSize());
        list.removeLast();
        list.removeLast();
        list.removeLast();
        assertEquals(4, list.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        list.removeLast();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("[]", list.toString());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals("[1, 2, 3, 4]", list.toString());
        list.removeFirst();
        assertEquals("[2, 3, 4]", list.toString());
    }

}