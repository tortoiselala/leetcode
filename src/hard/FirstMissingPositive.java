package hard;

import java.util.concurrent.ConcurrentHashMap;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * @author tortoiselala
 */
public class FirstMissingPositive {
//    ConcurrentHashMap

    Thread a = new Thread();
    /**
     * 解决这个问题的核心思想在于，如何在寻找过程中将已经存在的标记出来，
     * 从而在之后寻找到所需的目标数字
     * 显然我们可以采用一个长度为n的数组来表示某一数字是否存在，需要额外的空间为n
     * 如果原始数组nums中的元素有比nums.length大的，完全可以忽略
     * 由鸽巢原理可以知道，在n个元素的取值范围为[0, k] (k > n)
     * 则必定缺少一个在区间(0, n)内的数字
     * 且记该数组为flag， 由于我们只需要标志某一数字是否存在，所以，可以使用boolean数组
     * 因此，我们有以下声明:
     *  boolean[] flag = new boolean[n]
     * 我们可以扫描一遍原数组，寻找到那些比0大的数字，并且更新flag[i]的值
     * 然后，我们再次扫描flag数组，就可以知道最小的未出现的值了。
     * 对于以上思路，写出函数firstMissingPositiveUsingAdditionalNSpace
     *
     * 再来完善一下上面的思路
     * 上面我们使用了额外的空间，但是这个空间仅仅是为了保存n个状态，我们可以尝试将保存状态的工作转移
     * 而不需要额外的空间。
     * 由于只需要保存true，false两种状态，所以我们可以用在原来的数组的基础上，使用正负来代替
     *
     *
     * 再来审查以下原来的问题：
     *  - 数组长度为n
     *  - 数字可能是正数，也可能是负数
     * 由于负数不计入范围，所以需要先进行处理将非负数挑选出来
     * 使用快速排序中的partition方法，将负数全部移动到数组末尾
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        return firstMissingPositiveInPlaceTag(nums);
    }

    private int firstMissingPositiveUsingAdditionalNSpace(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num >= 0 && num < nums.length + 1) {
                flag[num] = true;

            }
            for (int i = 1; i < nums.length + 1; ++i) {
                if (!flag[i]) {
                    return i;
                }
            }
            return nums.length + 1;
        }
        return 0;
    }

    private int firstMissingPositiveInPlaceTag(int[] nums){
        // get line
        int k = partition(nums);
        // 将所有负数变为正数（由于要保存两种状态，所以将所有数字变为正数，用负数表示那些出现过的数字）
        for(int i = k; k < nums.length; ++i){
            nums[i] = Math.abs(nums[i]);
        }
        // 状态转换
        for(int i = 0; i < k + 1; ++i){
            int num = Math.abs(nums[i]);

            if(nums[i] >= 0 && num >= 0 && num <= nums.length){
                nums[num] = nums[num] < 0 ? nums[num] : -nums[num];
            }
        }
        // 寻找
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){
                return i;
            }
        }
        return nums.length + 1;
    }

    int partition(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] <= 0){
                swap(nums, i, j);
                --j;
            }else{
                ++i;
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
