package medium;

// https://leetcode.com/problems/4sum/

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourNum {
    public static void main(String[] args) {
        System.out.println(new FourNum().fourSum(new int[]{0, 0, 0, 0}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> output = new LinkedList<>();
        for(int i = 0; i < nums.length - 3; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; ++j){
                if(j != i + 1 && nums[j] == nums[j - 1] )
                    continue;
                int l = j + 1, r = nums.length - 1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        output.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]){
                            ++l;
                        }
                        while(l < r && nums[r] == nums[r - 1]){
                            --r;
                        }
                        ++l;
                        --r;

                    }else if(sum > target){
                        --r;
                    }else{
                        ++l;
                    }
                }
            }
        }
        return output;
    }
}

/**
 * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Expected
 * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],           [-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
