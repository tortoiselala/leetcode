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
        int rotate;
        int length = nums.length;
        int low = 0, high = length - 1;
        int mid;
        int realmid;

        // 寻找旋转点
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        rotate = low;

        low = 0;
        high = length - 1;
        while(low <= high){
            // compute real mid
            mid = low + (high - low) / 2;
            realmid = (rotate + mid) % length;
            if(nums[realmid] == target){
                return realmid;
            }else if(nums[realmid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target, int l, int r){
        if(nums == null || nums.length == 0){
            return -1;
        }
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
            // 在有序的一侧
            if(nums[l] < target && target < nums[mid]){
                return search(nums, target, l, mid);
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
