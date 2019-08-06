package medium;

public class DesignCircularQueue {
}

class MyCircularQueue {


    private int[] elems;
    private int front, rear = -1, len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        elems =  new int[k];
        front = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (++rear) % elems.length;
        elems[rear] = value;
        ++len;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        front = (++front) % elems.length;
        --len;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? - 1 : elems[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : elems[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == elems.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */