package medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author tortoiselala
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        return bruteForceSolution(s);
    }

    /**
     * 使用最长公共子串的解法解决
     * 将原字符串s反转之后得到一个新的字符串sr
     * s和sr之间寻找最长的公共子串即为最长的回文串。
     * zui
     * @param s 原始字符串
     * @return 最长公共子串
     */
    private String longestSubstring(String s){
        return null;
    }

    /**
     * 暴力解法
     * 暴力解法验证所有可能的子串是否为回文串
     * 对于一个长度为n的字符串，子串分别为（下标表示）
     * (0, 0) (0, 1) (0, 2)...(0, n)
     * (1, 1) (1, 2)...(1, n)
     * ...
     * (n, n)
     * 寻找到所有子串所需时间为:n * n
     * 判断该子串是否为回文串所需时间为n
     * 综上：时间复杂度O(n^3)
     * @param s 待寻找字符串
     * @return 最长回文串
     */
    private String bruteForceSolution(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int maxLen = 1;
        int fromIndex = 0;
        int toIndex = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; ++i){
            for(int j = i; j < chars.length; ++j){
                if(j - i + 1> maxLen && isPalindromicString(chars, i, j)){
                    fromIndex = i;
                    toIndex = j;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(fromIndex, toIndex + 1);
    }

    /**
     * 动态规划解法
     * 动态规划解法的核心思想是在原有已知回文串的左右分
     * 别增加一个相同的字符，该回文串依然是回文串
     * 定义如下：
     *  P(i, j) =
     *      |_____true  如果(i, j)的子串是回文串
     *      |_____false 如果(i, j)的子串不是回文串
     *
     *  判断P(i - 1, j + 1)的值的方法是
     *  判断P(i, j) && s[i - 1] == s[j + 1]
     *  起始条件
     *      P(i, i) = true
     *      P(i, i + 1) == (s[i + 1] == s[i])
     *
     *  复杂度分析：
     *      时间复杂度：O(n^2)
     *      空间复杂度：O(n^2)
     * @param s 待寻找字符串
     * @return 最长回文子串
     */
    private String dynamicProgramming(String s){
        int len = s.length();
        if(len == 0){
            return "";
        }
        char[] sToArray = s.toCharArray();
        boolean[][] mem = new boolean[len][len];
        int maxLen = 1;
        int fromIndex = 0;
        int toIndex = 1;
        // 初始化条件
        for(int i = 0; i < len; ++i){
            mem[i][i] = true;
            if(i + 1 < len && sToArray[i] == sToArray[i + 1]){
                mem[i][i + 1] = true;
                maxLen = 2;
                fromIndex = i;
                toIndex = i + 1 + 1;
            }
        }
        // 执行dp
        for(int i = 2; i < len; ++i){
            for(int j = 0; j < i - 1; ++j){
                mem[j][i] = mem[j + 1][i - 1] && sToArray[j] == sToArray[i];
                if(mem[j][i] && i - j + 1 > maxLen){
                    maxLen = i - j + 1;
                    fromIndex = j;
                    toIndex = i + 1;
                }
            }
        }

        return s.substring(fromIndex, toIndex);
    }

    /**
     * 中心扩展方法
     *
     * 回文串的构造有这样一个显然成立的方法：
     *  以一个回文串作为元回文串（瞎掰的），则在元回文串左右分别增加一个相同的字符，构造后的字符串依然是回文串
     *
     *  假如以最短的子串作为元回文串，我们就可以以其为中心进行无限扩展，所以下面需要寻找到最短的回文串
     *
     *  最短的回文串有两种类型（这样来说，最短并不是“最短”）
     *          |______只有一个字符的字符串，比如 "a"（类型一）
     *          |______只有两个相同字符的字符串, 比如 "aa"（类型二）
     *
     *   对于一个长度为n的字符串，共有n个类型一的元回文串
     *   对于一个长度为n的字符串，最多有n-1个类型二的元回文串
     *
     *   以2n - 1个元回文串为中心进行扩展，最多需要扩展n/2次（元回文串处于n/2的位置，且原始字符串为回文串）
     *   则时间复杂度为T(n) = (2n-1)*n/2 = n^2 - n/2 = O(n^2)
     *   空间复杂度为O(1)
     * 要寻找一个回文串，我们只需要从列举出所有可以作为
     * @param s str
     * @return substring
     */
    public String expandAroundCenter(String s){

        /*
          laxLen记录最大长度的回文子串
          fromIndex 记录回文子串左侧截止位置
          toIndex 记录回文子串右侧截止位置
         */
        int len = s.length();
        if(len == 0){
            return "";
        }
        int maxLen = 1, fromIndex = 0, toIndex = 1;

        char[] charArray = s.toCharArray();
        for(int i = 0; i < len; ++i){
            int[] r1 = expandAroundCenterHelp(charArray, i, true);
            int[] r2 = expandAroundCenterHelp(charArray, i, false);
            if(r1[0] > maxLen){
                maxLen = r1[0];
                fromIndex = r1[1];
                toIndex = r1[2];
            }
            if(r2[0] > maxLen){
                maxLen = r2[0];
                fromIndex = r2[1];
                toIndex = r2[2];
            }
        }

        return s.substring(fromIndex, toIndex);
    }

    /**
     * 从指定位置扩展，寻找最长的回文子串
     * @param array array
     * @param m 元回文串所在位置
     * @param type 扩展类型 true:类型一; false:类型二
     * @return 3元素数组 int[0] 表示最大长度， int[1] 表示fromIndex， int[2] 表示toIndex
     */
    private int[] expandAroundCenterHelp(char[] array, int m, boolean type) {

        int[] result = new int[3];

        // 是否多走一步
        int step = type ? 0 : 1;
        result[0] = 1 + step;
        result[1] = m;
        result[2] = m + 1 + step;
        for (int i = 1; i <= array.length / 2; ++i) {
            if (m - i >= 0 && m + i + step < array.length && array[m - i] == array[m + i + step]) {
                ++result[0];
                result[1] = m - i;
                result[2] = m + i + 1 + step;
            } else {
                break;
            }
        }
        return result;
    }

    private boolean isPalindromicString(char[] chars, int fromIndex, int toIndex){

        while(fromIndex < toIndex){
            if(chars[fromIndex] == chars[toIndex]){
                ++fromIndex;
                --toIndex;
            }else{
                return false;
            }
        }
        return true;
    }
}
