package easy;

class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public int binarySearch(int[]nums, int target, int low, int high){
        int mid=(low+high)/2;
        if (low==high){
            if (target<=nums[low]){
                return low;
            }
            return low+1;
        }
        else if (high==low+1){
            if (target<=nums[low]){
                return low;
            }
            else if (target>nums[low] && target<=nums[high]){
                return high;
            }
            return high+1;
        }
        if (target==nums[mid]){
            return mid;
        }
        else if (target>nums[mid]){
            return binarySearch(nums,target,mid+1,high);
        }
        return binarySearch(nums,target,low,mid-1);
    }
}