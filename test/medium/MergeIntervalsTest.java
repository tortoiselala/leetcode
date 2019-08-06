package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeIntervalsTest {

    @Test
    public void merge() {
        int[][] arr = new int[][]{
                {2, 3},
                {5, 5},
                {2, 2},
                {3, 4},
                {3, 4}

        };

        int[][] re = new MergeIntervals().merge(arr);
        for (int[] ints : re) {
            System.out.println(Arrays.toString(ints));
        }
    }
}