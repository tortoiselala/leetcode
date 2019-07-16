package easy;

public class TwoSumSortedArray {

    public int[] twoSum1(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return new int[]{-1, -1};
        }
        int length = numbers.length;
        for(int i = 0; i < length && numbers[i] <= target; ++i){
            for(int j = i + 1; j < length; ++j){
                int sum = numbers[i] + numbers[j];
                if(sum == target){
                    return new int[]{i + 1, j + 1};
                }else if(sum > target){
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target){
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum > target){
                --right;
            }else{
                ++left;
            }
        }
        return new int[]{};
    }
}
