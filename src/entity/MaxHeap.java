package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tortoiselala
 */
public class MaxHeap {
    private List<Integer> arr;
    private int n;

    public MaxHeap() {
        arr  = new ArrayList<>();
        arr.add(0);
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(int elem){
        arr.add(elem);
        swim(++n);
    }

    public int deleteMax(){
        int returnValue = arr.get(0);
        arr.add(1, arr.remove(n));
        --n;
        sink(1);
        return returnValue;
    }

    private void swim(int n){
        while(n > 1 && (arr.get(n / 2) < arr.get(n))){
            int tmp = arr.get(n / 2);
            arr.set(n / 2, arr.get(n));
            arr.set(n, tmp);
            n /= 2;
        }
    }

    private void sink(int n){
        while(n < this.n){
            if(n * 2 <= this.n && n * 2 + 1 <= this.n){
                int maxIndex = arr.get(n * 2) > arr.get(n * 2 + 1) ? n * 2 : n * 2 + 1;
                if(arr.get(n) < arr.get(maxIndex)){
                    int tmp = arr.get(n);
                    arr.set(n, arr.get(maxIndex));
                    arr.set(maxIndex, tmp);
                    n = maxIndex;
                }else{
                    n = this.n;
                }
            }else if(n * 2 <= this.n){
                if(arr.get(n) < arr.get(n * 2)){
                    int tmp = arr.get(n);
                    arr.set(n, arr.get(n * 2));
                    arr.set(n * 2, tmp);
                    n = n * 2;
                }
            }else{
                n = this.n;
            }
        }
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "arr=" + arr +
                ", n=" + n +
                '}';
    }
}