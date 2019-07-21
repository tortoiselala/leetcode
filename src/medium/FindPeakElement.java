package medium;

/**
 * @author tortoiselala
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}
