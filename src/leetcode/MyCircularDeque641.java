package leetcode;

/**
 * leetcode 641. 设计循环双端队列
 */
public class MyCircularDeque641 {

    private int[] deque;
    private int head;
    private int tail;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque641(int k) {
        deque = new int[k + 1];
        size = k + 1;
        head = 0;
        tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + size) % size;
        deque[head] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[tail] = value;
        tail = (tail + 1) % size;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + size) % size;
        return true;

    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(tail - 1 + size) % size];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return tail == head;

    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return tail + 1 % size == head;
    }

    public int dequeSize() {
        return size - 1;
    }

    public static void main(String[] args) {

        MyCircularDeque641 obj = new MyCircularDeque641(5);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
    }
}