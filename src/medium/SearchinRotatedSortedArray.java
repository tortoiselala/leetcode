package medium;

import java.util.Arrays;

/**
 * Created by tortoiselala on 2019-05-29
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int l, int r){
        if(l + 1 >= r){
            if(l >= r){
                return -1;
            }
            return nums[l] == target ? l : -1;
        }
        int mid = l + (r - l) / 2;

        if(nums[mid] == target){
            return mid;
        }

        // 左右都有序
        if(nums[l] <= nums[mid] && nums[mid] <= nums[r - 1]){
            if(nums[mid] < target){
                return search(nums, target, mid + 1, r);
            }else{
                return search(nums, target, l, mid);
            }
        }

        // 左侧有序
        if(nums[mid] > nums[l]){
            if(nums[0] < target && target < nums[mid]){ // 在有序的一侧
                return search(nums, target, 0, mid - 1);
            }else{
                return search(nums, target, mid + 1, r);
            }
        }

        // 右侧有序
        if(nums[mid] < nums[r - 1]){
            if(nums[mid] < target && target < nums[r - 1]){
                return search(nums, target, mid + 1, r);
            }else{
                return search(nums, target, l, mid);
            }
        }
        return -1;
    }
}
