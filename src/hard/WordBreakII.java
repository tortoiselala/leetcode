package hard;

import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> re = new LinkedList<>();
        helper("", wordDict, s, re);
        return re;
    }
    private void helper(String pre, List<String> wordDict, String back, List<String> re, List<String> ) {
        int backLen = back.length();
        if(backLen == 0) {
            re.add(pre);
            return;
        }

        if(true)

        for(String word : wordDict) {
            if(back.startsWith(word)) {
                if(pre.length() != 0){
                    helper(pre + " " + word, wordDict, back.substring(word.length()), re);
                }else{
                    helper(pre + word, wordDict, back.substring(word.length()), re);
                }
            }
        }
    }
}
