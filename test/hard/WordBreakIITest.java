package hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class WordBreakIITest {

    @Test
    public void wordBreak() {
        int count = 1;
        for(String s : new WordBreakII()
                .wordBreak("aaaaaaaaaaaaaaaaaaaa",
                        new LinkedList<>(Arrays.asList("cat", "cats", "dog", "and", "sand", "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")))){
            System.out.println("" + (count++) + "  " + s);
        }
    }
}