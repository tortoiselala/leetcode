package easy;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len;
        if(nums == null || (len = nums.length) == 0){
            return 0;
        }
        int low = 0, high = len - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
