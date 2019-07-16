package medium;


//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(
                new LetterCombinationsOfAPhoneNumber().letterCombinations("5678"));
    }

    private String[] charMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        // map中存储计数器，当前位置，理论位置移动值
        // 计数器是位置移动的标准，当计数器值等于理论位置移动值时，当前位置+1
        List<String> results = new LinkedList<>();
        Map<String, Integer[]> map = new HashMap<>();
        int total = 1;
        for(int i = 0; i < digits.length(); ++i){
            int count = 0;
            int currentPos = 0;
            int whenToAdd = 1;
            int num = digits.charAt(i) - '0';
            for(int j = digits.length() - 1; j > i; --j){
                whenToAdd *= charMap[digits.charAt(j) - '0'].length();
            }
            map.put("" + digits.charAt(i) + i, new Integer[]{count, currentPos, whenToAdd});

            total *= charMap[num].length();
        }

        if(total == 1){
            return results;
        }

        for(int i = 0; i < total; ++i){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < digits.length(); ++j){
                char ch = digits.charAt(j);
                String key = "" + ch + j;
                Integer[] values = map.get(key);
                ++values[0];
                sb.append(charMap[ch - '0'].charAt(values[1]));
                if(values[2] <= values[0]){
                    values[1] = (values[1] + 1) % charMap[ch - '0'].length();
                    values[0] = 0;
                }
            }
            results.add(sb.toString());
        }
        return results;
    }

    // 回溯法
    String[] digitMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> output = new LinkedList<>();
    public List<String> letterCombinations2(String digits){
        if(digits.length() == 0){
            return output;
        }
        traceback("", digits);
        return output;
    }

    public void traceback(String combination, String nextDigits){
        if(nextDigits.length() == 0){
            output.add(combination);
            return;
        }
        String currentDigitsMap = digitMap[nextDigits.charAt(0) - '0'];
        for(int i = 0; i < currentDigitsMap.length(); ++i){
            traceback(combination + currentDigitsMap.charAt(i), nextDigits.substring(1));
        }
    }
}
