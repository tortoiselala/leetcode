package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tortoiselala on 2019-05-29
 */
public class SearchinRotatedSortedArrayTest {

    @Test
    public void search() {
//        System.out.println(
//                new SearchinRotatedSortedArray().search(
//                        new int[]{5, 1, 3}, 5));
//        int[] array = new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3};
//        for(int e : array){
//            System.out.println(new SearchinRotatedSortedArray().search(array, e));
//        }
        int[] array2 = new int[]{1, 3};
        System.out.println(new SearchinRotatedSortedArray().search(array2, 3));
    }
}