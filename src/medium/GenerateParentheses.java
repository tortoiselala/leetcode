package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author tortoiselala
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return backTrack(n);
    }

    /**
     * 暴力解法将可能的情况列举出来，然后挑选
     * 时间复杂度分析：
     * 所有可能的子串共有2^2n个
     * 判断某个子串是否为回文串需要n
     * 时间复杂度为O(n * 2 ^2n)
     * @param n n
     * @return result
     */
    private List<String> bruteForce(int n){
        char[] cur = new char[n * 2];
        List<String> result = new LinkedList<>();
        generateAll(cur, 0, result);
        return result;
    }

    private void generateAll(char[] cur, int pos, List<String> result){
        if(pos == cur.length){
            if(isValid(cur)){
                result.add(new String(cur));
            }
        }else{
            cur[pos] = '(';
            generateAll(cur, pos + 1, result);
            cur[pos] = ')';
            generateAll(cur, pos + 1, result);
        }
    }

    private boolean isValid(char[] cs){
        int balance = 0;
        for(char ch : cs){
            if(ch == '(') {
                ++balance;
            }
            else if(ch == ')'){
                --balance;
                if(balance < 0){
                    return false;
                }
            }
        }
        return balance == 0;
    }

    /**
     * 在暴力解法中存在某些不必要的耗费
     * 完全可以在生成子串的过程中将不符合的结果剔除
     * 在isValid中使用balance的方法也可以使用在这里。
     *
     *
     * 复杂度分析
     * 与暴力解法一样
     * @param n n
     * @return result
     */
    private List<String> backTrack(int n){
        List<String> result = new LinkedList<>();
        backTrackHelp(new char[n * 2], 0, 0, 0, result, n);
        return result;
    }

    private void backTrackHelp(char[] cur, int pos, int open, int close, List<String> result, int n){
        if(pos == cur.length){
            result.add(new String(cur));
        }else{
            if(open >= close && open < n){
                cur[pos] = '(';
                backTrackHelp(cur, pos + 1, open + 1, close, result, n);
            }
            if(open > close && close < n){
                cur[pos] = ')';
                backTrackHelp(cur, pos + 1, open, close + 1, result, n);
            }
        }
    }
}
