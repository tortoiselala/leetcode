package entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class MaxHeapTest {
    @Test
    public void main(){
        MaxHeap heap = new MaxHeap();
        heap.insert(10);
        heap.insert(20);
        System.out.println(heap);
        heap.insert(5);
        System.out.println(heap);
    }

}