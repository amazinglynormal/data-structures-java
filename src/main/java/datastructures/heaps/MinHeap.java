package datastructures.heaps;

import java.util.Arrays;

public class MinHeap {

    int[] heap;
    int numOfElements = 0;
    int capacity;

    public MinHeap() {
        this.capacity = 20;
        this.heap = new int[this.capacity + 1];
        this.heap[0] = 0;
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity + 1];
        this.heap[0] = 0;
    }

    public MinHeap(int[] array) {
        this.capacity = array.length;
        this.heap = new int[capacity + 1];
        this.heap[0] = 0;
        heapify(array);
    }

    public void add(int element) {
        numOfElements++;

        if (numOfElements >= capacity) {
            increaseCapacity();
        }

        heap[numOfElements] = element;

        int index = numOfElements;
        int parent = index / 2;

        while (heap[index] < heap[parent] && index > 1) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    public int pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int minElement = heap[1];
        heap[1] = heap[numOfElements];
        numOfElements--;
        int index = 1;

        while (index <= numOfElements / 2) {
            int left = index * 2;
            int right = index * 2 + 1;

            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }

        return minElement;
    }

    public int peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[1];
    }

    public boolean isEmpty() {
        return numOfElements == 0;
    }

    public int getSize() {
        return numOfElements;
    }

    private void heapify(int[] array) {
        for (int val: array) {
            add(val);
        }
    }

    private void increaseCapacity() {
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity + 1);
    }

    @Override
    public String toString() {
        if (numOfElements == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 1; i <= numOfElements; i++) {
            sb.append(heap[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

}
