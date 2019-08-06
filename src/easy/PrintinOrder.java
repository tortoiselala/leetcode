package easy;

import java.util.concurrent.Semaphore;

public class PrintinOrder {

}
class Foo {

    Semaphore one = new Semaphore(1);
    Semaphore two = new Semaphore(1);
    public Foo() {
        try {
            one.acquire();
            two.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        one.acquire();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        one.release();
        two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        two.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        two.release();
    }
}