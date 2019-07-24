package medium;

import static org.junit.Assert.*;

public class UniquePathsIITest {

    @org.junit.Test
    public void uniquePathsWithObstacles() {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{1}}));
    }
}