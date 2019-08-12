package medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int index = 0;
        // 红色
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                swap(nums, index++, i);
            }
        }
        // 白色
        for(int i = index; i < nums.length; ++i){
            if(nums[i] == 1){
                swap(nums, index++, i);
            }
        }

        // 蓝色
        for(int i = index; i < nums.length; ++i){
            if(nums[i] == 2){
                swap(nums, index++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
