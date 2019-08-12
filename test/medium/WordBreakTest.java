package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    @Test
    public void wordBreak() {
        String s = "leetcode";
        List<String> l = new ArrayList<>();
        l.add("leet");
        l.add("code");
        System.out.println(new WordBreak().wordBreak(s, l));
        l.clear();
        l.addAll(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        s = "applepenapple";
        System.out.println(new WordBreak().wordBreak(s, l));
        test();
    }

    private void test(){
        String s = "bccdbacdbdacddabbaaaadababadad";
        List<String> l = new ArrayList<>(Arrays.asList("cbc", "bcda", "adb",
                "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab",
                "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc",
                "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a",
                "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb",
                "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd",
                "cadaa", "ddbc", "babb"));
        // bcc dbac dbda     dad
        System.out.println(new WordBreak().wordBreak(s, l));
    }
}