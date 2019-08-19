package easy;

/**
 * Created by tortoiselala on 2019-05-28
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    /**
     *
     * total[n] = min(total[n - 2] ,total[n - 1]) + cost[n];
     * total[0] = cost[0];
     * total[1] = cost[1];
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] total = new int[n];
        total[0] = 0;
        total[1] = 0;
        for (int i = 2; i < n; i++) {
            total[i] = Integer.min(total[i - 1] + cost[i - 1], total[i - 2] + cost[i - 2]);
        }
        return Integer.min(total[n - 1], total[n - 2]);
    }
}
