package datastructures.stacks;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListStack<T> {

    private LinkedList<T> stack;

    public ListStack() {
        this.stack = new LinkedList<>();
    }

    public ListStack(T element) {
        this.stack = new LinkedList<>();
        this.stack.push(element);
    }

    public void push(T element) {
        stack.push(element);
    }

    public T pop() throws NoSuchElementException {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public boolean contains(T element) {
        return stack.contains(element);
    }
}
