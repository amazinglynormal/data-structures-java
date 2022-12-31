package datastructures.linkedlist;

public class SinglyLinkedList<T> {

    private int size = 0;
    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data.toString();
        }
    }
    public void add(T data) {
        if (isEmpty()) {
            head = tail = new ListNode<>(data, null);
        } else {
            tail.next = new ListNode<>(data, null);
            tail = tail.next;
        }

        size++;
    }

    public void addToHead(T data) {
        if (isEmpty()) {
            head = tail = new ListNode<>(data, null);
        }
        else {
            ListNode<T> currentHead = head;
            head = new ListNode<>(data, currentHead);
        }

        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        ListNode<T> last = tail;

        if (getSize() == 1) {
            tail = null;
            head = null;
        } else {

            ListNode<T> currentNode = head;

            while (currentNode.next != tail) {
                currentNode = currentNode.next;
            }

            currentNode.next = null;
            tail = currentNode;
        }

        size--;

        return last.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        ListNode<T> currentHead = head;

        if (currentHead.next != null) {
            head = currentHead.next;
        } else {
            head = null;
            tail = null;
        }

        size--;

        return currentHead.data;
    }

    public int indexOf(T data) {
        if (isEmpty()) {
            return -1;
        }

        ListNode<T> currentNode = head;

        int index = 0;

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return index;
            }

            index++;

            currentNode = currentNode.next;
        }

        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) {
                sb.append(", ");
            }
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}