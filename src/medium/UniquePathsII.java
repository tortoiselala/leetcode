package medium;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m, n;
        if((m = obstacleGrid.length) == 0 || (n = obstacleGrid[0].length) == 0){
            return 1;
        }
        int[][] map = new int[m][n];
        map[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        boolean s = false;
        for(int i = 0; i < n; ++i){
            if(s){
                map[0][i] = 0;
            }else{
                s = obstacleGrid[0][i] == 1;
                map[0][i] = s ? 0 : 1;
            }
        }
        s = false;
        for(int i = 0; i < m; ++i){
            if(s){
                map[i][0] = 0;
            }else{
                s = obstacleGrid[i][0] == 1;
                map[i][0] = s ? 0 : 1;
            }
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                map[i][j] = obstacleGrid[i][j] == 1 ? 0 : (map[i][j - 1] + map[i - 1][j]);
            }
        }
        return map[m - 1][n - 1];
    }
}
