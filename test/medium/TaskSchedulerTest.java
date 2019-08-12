package medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskSchedulerTest {

    @Test
    public void leastInterval() {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'B', 'B', 'B'}, 2));
    }
}