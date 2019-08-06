package medium;

public class DesignCircularDeque {
    public static MyCircularDeque getInstance(int n){
        return new MyCircularDeque(n);
    }
}

class MyCircularDeque {

    private final int[] elems;
    private int front = 0;
    private int rear = 0;
    private int len = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elems = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        elems[front] = value;
        front = (++front) % elems.length;
        ++len;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        rear = (rear + elems.length - 1) % elems.length;
        elems[rear] = value;
        ++len;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + elems.length - 1) % elems.length;
        --len;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rear = (rear + 1) % elems.length;
        --len;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : elems[(front + elems.length - 1) % elems.length];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : elems[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == elems.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
