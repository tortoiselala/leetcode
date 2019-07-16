package medium;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/submissions/

/**
 * given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,2,5,10,11}, 12));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int offset = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length - 2; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int tmpSum = nums[i] + nums[l] + nums[r];

                int tmpOffset = Math.abs(target - tmpSum);
                sum = tmpOffset < offset ? tmpSum : sum;
                offset = tmpOffset < offset  ? tmpOffset : offset;
                int signOffset = target - tmpSum;

                if(signOffset > 0){
                    ++l;
                }else if(signOffset < 0){
                    --r;
                }else{
                    return target;
                }
            }
        }
        return sum;
    }
}
