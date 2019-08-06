package medium;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd test = new ZeroEvenOdd(5);
        ExecutorService es = Executors.newFixedThreadPool(3);
        CyclicBarrier cb = new CyclicBarrier(3);
        es.submit(() -> {
            try {
                cb.await();
                test.zero(new Printer());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        es.submit(() -> {
            try {
                cb.await();
                test.even(new Printer());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        es.submit(() -> {
            try {
                cb.await();
                test.odd(new Printer());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        while(true){
            if(((ThreadPoolExecutor)(es)).getCompletedTaskCount() == 3){
                break;
            }

            Thread.sleep(10);
        }

        es.shutdown();
    }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n;){
            zero.acquire();
            printNumber.accept(0);
            ++i;
            if(i % 2 == 0){
                odd.release();
            }else{
                even.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for(int i = 2; i <= n; i = i + 2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i = i + 2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}

class Printer implements IntConsumer{

    @Override
    public void accept(int value) {
        System.out.println(value);
    }
}