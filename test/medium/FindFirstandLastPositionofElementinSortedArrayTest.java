package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class FindFirstandLastPositionofElementinSortedArrayTest {

    @Test
    public void searchRange() {
        System.out.println(
                Arrays.toString(new FindFirstandLastPositionofElementinSortedArray()
                        .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}