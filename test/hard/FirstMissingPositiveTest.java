package hard;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class FirstMissingPositiveTest {

    @Test
    public void firstMissingPositive() {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1}));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{}));
    }

    @Test
    public void partition() {
        int[] nums = {2, 3, 4, 5, -1, -2, 3, 9, 7, -8};
        System.out.println(new FirstMissingPositive().partition(nums));
        System.out.println(Arrays.toString(nums));
    }
}