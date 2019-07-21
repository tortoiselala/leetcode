package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class Searcha2DMatrixTest {

    @Test
    public void searchMatrix() {
        System.out.println(new Searcha2DMatrix().searchMatrix(
                new int[][]{
                        {1,   3,  5,  7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                },
                3
        ));
    }
}