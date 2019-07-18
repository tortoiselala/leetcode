package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
//        return bruteForce(s);
        return slideWindow(s);
    }

    private int slideWindow(String s){
        int length = s.length();
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while(i < length && j < length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(j - i, max);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    private int bruteForce(String s){
        int length = s.length();
        for(int i = length; i > 0; --i){
            for(int j = 0; j + i <= length; ++j){
                if(isUnique(s, j, j + i)){
                    return i;
                }
            }
        }
        return 0;
    }

    private boolean isUnique(String s, int l, int r){
        Set<Character> set = new HashSet<>();
        for(int i = l; i < r; ++i){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }
        return true;
    }
}
