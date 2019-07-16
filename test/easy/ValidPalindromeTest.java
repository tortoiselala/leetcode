package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tortoiselala
 */
public class ValidPalindromeTest {

    @Test
    public void isPalindrome() {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}