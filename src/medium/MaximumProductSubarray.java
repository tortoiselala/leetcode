package medium;

import java.util.Arrays;

/**
 * @author tortoiselala
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        boolean[] flags = new boolean[len + 1];
        int[] value = Arrays.copyOf(nums, len);
        flags[0] = true;
        int max = value[0];
        for(int i = 1; i < len; ++i) {
//            for(int j = )
            if(flags[i - 1]){
                int mul = nums[i] * value[i - 1];
                if (mul > value[i]) {
                    value[i] = mul;
                    flags[i] = true;
                }else{
                    flags[i] = false;
                }
            }else{
                if (value[i - 1] > value[i]) {
                    value[i] = value[i - 1];
                    flags[i] = false;
                }else{
                    flags[i] = true;
                }
            }
            max = value[i] > max ? value[i] : max;
        }
        return max;
    }
}
