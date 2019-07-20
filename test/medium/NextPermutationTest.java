package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class NextPermutationTest {

    @Test
    public void nextPermutation() {
        int[] param = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] result= {1, 5, 8, 5, 1, 3, 4, 6, 7};
        new NextPermutation().nextPermutation(param);
        System.out.println(Arrays.toString(param));
    }
}