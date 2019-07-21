package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class SearchInsertPositionTest {

    @Test
    public void searchInsert() {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));

    }
}