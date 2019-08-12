package medium;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        sort(intervals);
        int index = 0;
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[index][1] >= intervals[i][0]){
                int max = Integer.max(intervals[index][1], intervals[i][1]);
                intervals[index][1] = max;
            }else{
                ++index;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }

        return copyOf(intervals, index);
    }

    private void sort(int[][] arr){
        for(int i = 0; i < arr.length; ++i){
            for(int j = i; j < arr.length; ++j){
                if(arr[i][0] > arr[j][0]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(int[][] arr, int i, int j){
        int a = arr[i][0];
        int b = arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = a;
        arr[j][1] = b;
    }

    private int[][] copyOf(int[][] or, int index){
        int[][] re = new int[index + 1][2];
        for(int i = 0; i <= index; ++i){
            re[i][0] = or[i][0];
            re[i][1] = or[i][1];
        }
        return re;
    }
}
