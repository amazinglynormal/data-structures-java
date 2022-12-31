package datastructures.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    public void testEmptyConstructor() {
        MinHeap mh = new MinHeap();
        assertEquals("[]", mh.toString());
    }

    @Test
    public void testCapacityConstructor() {
        MinHeap mh = new MinHeap(8);
        assertEquals("[]", mh.toString());

        mh.add(7);
        assertEquals("[7]", mh.toString());
    }

    @Test
    public void testArrayConstructor() {
        int[] arr = {3,8,5,1,9,7};
        MinHeap mh = new MinHeap(arr);
        assertEquals("[1,3,5,8,9,7]", mh.toString());
        assertEquals(1, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(9, mh.pop());
    }

    @Test
    public void testCapacityIncreases() {
        MinHeap mh = new MinHeap(5);
        mh.add(1);
        mh.add(1);
        mh.add(1);
        mh.add(1);
        mh.add(1);
        mh.add(1);

        assertEquals("[1,1,1,1,1,1]", mh.toString());
    }

    @Test
    public void testAdd() {
        int[] arr = {3,8,5,1,9,7};
        MinHeap mh = new MinHeap();
        mh.add(arr[0]);
        mh.add(arr[1]);
        mh.add(arr[2]);
        mh.add(arr[3]);
        mh.add(arr[4]);
        mh.add(arr[5]);

        assertEquals("[1,3,5,8,9,7]", mh.toString());
        assertEquals(1, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(9, mh.pop());
    }

    @Test
    public void testPop() {
        MinHeap emptyHeap = new MinHeap();
        assertThrows(IllegalStateException.class, emptyHeap::pop, "Heap is empty");

        int[] arr = {3,8,5,1,9,7,6};
        MinHeap mh = new MinHeap(arr);
        assertEquals("[1,3,5,8,9,7,6]", mh.toString());

        assertEquals(1, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(6, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(9, mh.pop());
    }

    @Test
    public void testPeek() {
        int[] arr = {3,8,5,1,9,7,6};
        MinHeap mh = new MinHeap();

        assertThrows(IllegalStateException.class, mh::peek, "Heap is empty");

        MinHeap mh2 = new MinHeap(arr);
        assertEquals(1, mh2.peek());
    }

    @Test
    public void testIsEmpty() {
        MinHeap mh = new MinHeap();
        assertTrue(mh.isEmpty());
        mh.add(1);
        assertFalse(mh.isEmpty());
        mh.pop();
        assertTrue(mh.isEmpty());
    }

    @Test
    public void testGetSize() {
        MinHeap mh = new MinHeap();
        assertEquals(0, mh.getSize());
        mh.add(1);
        mh.add(1);
        mh.add(1);
        assertEquals(3, mh.getSize());
        mh.pop();
        mh.pop();
        assertEquals(1, mh.getSize());
        mh.pop();
        assertEquals(0, mh.getSize());
    }

    @Test
    public void testToString() {
        int[] arr = {3,8,5,1,9,7,6};
        MinHeap mh = new MinHeap(arr);
        assertEquals("[1,3,5,8,9,7,6]", mh.toString());
        mh.pop();
        assertEquals("[3,6,5,8,9,7]", mh.toString());
    }

}