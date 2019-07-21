package medium;

/**
 * @author tortoiselala
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        int rotate = l;
        System.out.println("rotate : " + rotate);
        l = 0;
        r = len - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int real = (mid + rotate) % len;
            if(nums[real] == target) {
                return true;
            }else if(nums[real] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return false;
    }
}
