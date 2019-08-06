package medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3

        print(circularQueue.enQueue(6));  // return true
        print( circularQueue.Rear());  // return 3
        print( circularQueue.Rear());  // return 3
        print( circularQueue.deQueue());  // return true
        print( circularQueue.enQueue(5));  // return true
        print((circularQueue.Rear()));
        print( circularQueue.deQueue());  // return true
        print((circularQueue.Front()));
        print( circularQueue.deQueue());  // return true
        print( circularQueue.deQueue());  // return true
        print( circularQueue.deQueue());  // return true
    }

    private static void print(boolean v){
        System.out.println(v);
    }

    private static void print(int v){
        System.out.println(v);
    }
}