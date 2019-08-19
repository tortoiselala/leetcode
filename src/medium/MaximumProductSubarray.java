package medium;

import java.util.Arrays;

/**
 * @author tortoiselala
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;

        int optMax = nums[0];
        int optMin = nums[1];

        int max = optMax;

        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = optMax;
                optMax = optMin;
                optMin = tmp;
            }

            optMax = Math.max(nums[i], optMax * nums[i]);
            optMin = Math.min(nums[i], optMin * nums[i]);

            max = Math.max(optMax, max);
        }
        return max;
    }
}
