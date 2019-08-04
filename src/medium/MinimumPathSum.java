package medium;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m, n;
        if((m = grid.length) == 0 || (n = grid[0].length) == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        // dp[i][j] = Math.min(grid[i][j] + dp[i][j-1], grid[i][j] + dp[i - 1][j])
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; ++i){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i  < m; ++i){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = Math.min(grid[i][j] + dp[i][j-1], grid[i][j] + dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
