package medium;

//https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers,
 * are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> result = new ArrayList<>(3);
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    results.add(result);
                    while(l < r && nums[l] == nums[l + 1]){
                        ++l;
                    }
                    while(l < r && nums[r] == nums[r - 1]){
                        --r;
                    }
                    ++l;
                    --r;
                }else if(sum > 0){
                    --r;
                }else{
                    ++l;
                }
            }
        }
        return results;
    }
}
