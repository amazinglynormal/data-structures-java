package datastructures.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    @Test
    public void testEmptyConstructor() {
        MaxHeap mh = new MaxHeap();
        assertEquals("[]", mh.toString());
    }

    @Test
    public void testCapacityConstructor() {
        MaxHeap mh = new MaxHeap(8);
        assertEquals("[]", mh.toString());

        mh.add(7);
        assertEquals("[7]", mh.toString());
    }

    @Test
    public void testArrayConstructor() {
        int[] arr = {3,8,5,1,9,7};
        MaxHeap mh = new MaxHeap(arr);
        assertEquals("[9,8,7,1,3,5]", mh.toString());
        assertEquals(9, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(1, mh.pop());
    }

    @Test
    public void testCapacityIncreases() {
        MaxHeap mh = new MaxHeap(5);
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
        MaxHeap mh = new MaxHeap();
        mh.add(arr[0]);
        mh.add(arr[1]);
        mh.add(arr[2]);
        mh.add(arr[3]);
        mh.add(arr[4]);
        mh.add(arr[5]);

        assertEquals("[9,8,7,1,3,5]", mh.toString());
        assertEquals(9, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(1, mh.pop());
    }

    @Test
    public void testPop() {
        MaxHeap emptyHeap = new MaxHeap();
        assertThrows(IllegalStateException.class, emptyHeap::pop, "Heap is empty");

        int[] arr = {3,8,5,1,9,7};
        MaxHeap mh = new MaxHeap(arr);
        assertEquals("[9,8,7,1,3,5]", mh.toString());

        assertEquals(9, mh.pop());
        assertEquals(8, mh.pop());
        assertEquals(7, mh.pop());
        assertEquals(5, mh.pop());
        assertEquals(3, mh.pop());
        assertEquals(1, mh.pop());
    }

    @Test
    public void testPeek() {
        int[] arr = {3,8,5,1,9,7,6};
        MaxHeap mh = new MaxHeap();

        assertThrows(IllegalStateException.class, mh::peek, "Heap is empty");

        MaxHeap mh2 = new MaxHeap(arr);
        assertEquals(9, mh2.peek());
    }

    @Test
    public void testIsEmpty() {
        MaxHeap mh = new MaxHeap();
        assertTrue(mh.isEmpty());
        mh.add(1);
        assertFalse(mh.isEmpty());
        mh.pop();
        assertTrue(mh.isEmpty());
    }

    @Test
    public void testGetSize() {
        MaxHeap mh = new MaxHeap();
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
        int[] arr = {3,8,5,1,9,7};
        MaxHeap mh = new MaxHeap(arr);
        assertEquals("[9,8,7,1,3,5]", mh.toString());
        mh.pop();
        assertEquals("[8,5,7,1,3]", mh.toString());
    }
}