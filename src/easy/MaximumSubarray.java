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
        result[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
                for(int j = i - 1; j >= 0; --j){
                result[i] = Integer.max(nums[i], nums[i] + result[j]);
            }
        }
        return result[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
