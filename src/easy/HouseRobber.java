package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if (0 == len) {
            return 0;
        }
        int[] opt = Arrays.copyOf(nums, len);

        for (int i = 2; i < len; ++i) {
            for (int j = i; j >= 2; -- j) {
                opt[i] = Math.max(Math.max(opt[j - 1], opt[j - 2] + nums[i]), opt[i]);
            }

        }
        return len == 2 ? Math.max(opt[0], opt[1]) : opt[len - 1];
    }
}
