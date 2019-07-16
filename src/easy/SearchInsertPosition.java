package easy;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    public int binarySearch(int[] nums, int target, int from, int to){


        while(from  < to){
            int mid = from  + (to - from) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                if(mid + 1 < to && nums[mid + 1] > target){
                    return mid + 1;
                }else if(mid + 1 == to){
                        return mid + 1;
                }else{
                    from = mid + 1;
                }

            }else{
                if(mid - 1 > from && nums[mid - 1] < target){
                    return mid -1;
                }else if(mid - 1 == from){
                    return from;
                }else{
                    to = mid - 1;
                }
            }
        }
        return from;
    }

    public static void main(String[] args) {
//        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 7, 9, 50, 60, 70, 90}, 20));
//        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
//        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3}, 2));
    }
}
