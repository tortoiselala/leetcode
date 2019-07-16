package easy;


public class TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
