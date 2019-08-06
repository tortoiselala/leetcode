package medium;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BuildingH2O {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        CyclicBarrier cb = new CyclicBarrier(2);
        H2O test = new H2O();
        es.submit(() -> {
            try {
                cb.await();
                for(int i = 0; i < 100; ++i){
                    test.hydrogen(() -> {
                        System.out.print("H");
                    });
                }

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                cb.await();
                for(int i = 0; i < 100; ++i) {
                    test.oxygen(() -> {
                        System.out.print("O");
                    });
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        while (((ThreadPoolExecutor) (es)).getCompletedTaskCount() != 3) {
            Thread.sleep(10);
        }

        es.shutdown();
    }
}

class H2O {

    private Semaphore os = new Semaphore(2);
    private Semaphore hs = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

        os.acquire();
        releaseHydrogen.run();
        hs.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.

        hs.acquire(2);
        releaseOxygen.run();
        os.release(2);
    }
}