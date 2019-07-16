package easy;

/**
 * Created by tortoiselala on 2019-05-28
 */

/**
 * https://leetcode.com/problems/climbing-stairs/
 * @author tortoiselala
 */
public class ClimbStairs {
    /**
     * Time Limited
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] result = new int[1];
        result[0] = 0;
        climbStairsHelper(n, result);
        return result[0];
    }

    private void climbStairsHelper(int n, int[] result){
        if(n == 1 || n == 0){
            ++result[0];
            return;
        }
        climbStairsHelper(n - 1, result);
        climbStairsHelper(n - 2, result);
    }

    public int climbStairs2(int n) {
        int total = 0;
        int[] array = new int[n + 1];
        if(n >= 1){
            array[0] = 1;
            array[1] = 1;
        }
        for(int i = 2; i < n + 1; ++i){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
