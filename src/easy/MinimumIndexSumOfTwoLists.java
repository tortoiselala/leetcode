package easy;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        return hashMapSolution(list1, list2);
    }

    public String[] hashMapSolution(String[] list1, String[] list2){
        Map<String, Integer> map = new HashMap<>();
        List<String> results = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        int index = 0;
        for(String str : list2){
            map.put(str, index);
            ++index;
        }
        index = 0;
        for(String str : list1){
            if(map.containsKey(str) && map.get(str) + index < minIndex){
                minIndex = map.get(str) + index;
                results.clear();
                results.add(str);
            }else if(map.containsKey(str) && map.get(str) + index == minIndex){
                results.add(str);
            }
            ++index;
        }
index = 0;
        String[] resultArray = new String[results.size()];
        for(String str : results){
            resultArray[index] = str;
            ++index;
        }

        return resultArray;
    }
}
