package datastructures.stacks;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void push() {
        ListStack<Integer> stack = new ListStack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pop() {
        ListStack<Integer> stack = new ListStack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void peek() {
        ListStack<Integer> stack = new ListStack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.peek());
        stack.pop();
        assertEquals(3, stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        assertNull(stack.peek());
    }

    @Test
    void size() {
        ListStack<Integer> stack = new ListStack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.peek());
        stack.push(5);
        assertEquals(5, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(3, stack.size());
    }

    @Test
    void isEmpty() {
        ListStack<Integer> stack = new ListStack<>(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void contains() {
        ListStack<Integer> stack = new ListStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.contains(3));
    }
}