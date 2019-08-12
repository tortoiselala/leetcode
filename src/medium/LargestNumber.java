package medium;

import java.math.BigInteger;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        sort(nums);
        StringBuilder sb = new StringBuilder();
        for(int e : nums){
            sb.append(e);
        }
        int start = 0;
        for(int i = 0; i < sb.length(); ++i){
            if(sb.charAt(i) == '0'){
                start = i;
            }else{
                break;
            }
        }
        return sb.length() == 0 ? "0" : sb.toString().substring(start);
    }

    private void sort(int[] nums){
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if (compare(nums[i], nums[j]) < 0){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }

    private int compare(int i, int j){
       BigInteger ib = new BigInteger("" + i + "" + j);
       BigInteger jb = new BigInteger("" + j + "" + i);
       return ib.compareTo(jb);
    }
}
