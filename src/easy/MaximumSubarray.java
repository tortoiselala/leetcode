package easy;

import java.util.Arrays;
import java.util.concurrent.Executor;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = Arrays.copyOf(nums, nums.length);
        int max = 0;
        max = result[0];
        for(int i = 1; i < nums.length; ++i){
            result[i] = Integer.max(result[i], nums[i] + result[i - 1]);
            max = Math.max(result[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
