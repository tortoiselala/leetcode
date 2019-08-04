package medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * @author tortoiselala
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        int[][] map = new int[m][n];
        Arrays.fill(map[0], 1);
        map[0][0] = 0;
        for(int i = 1; i < m; ++i){
            map[i][0] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[m - 1][n - 1];
    }
}
