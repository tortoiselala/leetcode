package medium;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if(Math.abs((long)nums[i] - (long)nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }
}
