package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        for(String str : new GenerateParentheses().generateParenthesis(3)){
            System.out.println(str);
        }
    }
}