package medium;

import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
       return dynamicProgramming(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict){
        if(s.length() == 0){
            return true;
        }

        char first = s.charAt(0);
        List<Integer> map = new LinkedList<>();
        for(int i = 0; i < wordDict.size(); ++i){
            if(wordDict.get(i).charAt(0) == first){
                map.add(i);
            }
        }
        for (Integer integer : map) {
            String t = wordDict.get(integer);
            int index = s.indexOf(t);
            if (index != 0) {
                continue;
            }
            boolean re = wordBreak(s.substring(t.length()), wordDict);
            if (re) {
                return true;
            }
        }
        return false;
    }

    private boolean dynamicProgramming(String s, List<String> wordDict){
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; ++i){
            for(int j = 0; j < i; ++j){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];

    }
}
