package medium;

/**
 * @author tortoiselala
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private int[] linerSearch(int[] nums, int target){
        int len;
        if(nums == null || (len = nums.length) == 0){
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = len -  1;
        while(l < len && nums[l] < target){
            ++l;
        }
        while(r >= 0 && nums[r] > target){
            --r;
        }

        if(r < l){
            return new int[]{-1, -1};
        }else{
            return new int[]{l, r};
        }
    }

    private int[] binarySearch(int[] nums, int target){
        int len;
        if(nums == null || (len = nums.length) == 0){
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = len -  1;
        int mid;
        while(l < r){
            mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                return linerSearch(nums, l, r, target);
            }
        }
        return nums[l] == target ? new int[]{l, l} : new int[]{-1, -1};
    }

    private int[] linerSearch(int[] nums, int low, int high, int target){
        int l = low;
        int r = high;
        while(l <= high && nums[l] < target){
            ++l;
        }
        while(r >= low && nums[r] > target){
            --r;
        }

        if(r < l){
            return new int[]{-1, -1};
        }else{
            return new int[]{l, r};
        }
    }
}
