package easy;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tortoiselala on 2019-05-28
 */
public class ClimbStairsTest {

    @Test
    public void climbStairs() {
        Calendar calendar = Calendar.getInstance();
        Date start = calendar.getTime();
        System.out.println(new ClimbStairs().climbStairs(44));
        Date end = calendar.getTime();
        System.out.println("cost : " + (end .getTime()- start.getTime()));
    }

    @Test
    public void climbStairs2() {
        Calendar calendar = Calendar.getInstance();
        Date start = calendar.getTime();
        System.out.println(new ClimbStairs().climbStairs2(44));
        Date end = calendar.getTime();
        System.out.println("cost : " + (end .getTime()- start.getTime()));
    }
}