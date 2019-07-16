package easy;

// https://leetcode.com/problems/plus-one/

/**
 * Given a non-empty array of digits representing a non-negative integer,
 * plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; --i) {
            if(i == digits.length - 1){
                digits[i] = digits[i] + 1;
            }
            digits[i]  = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        int[] newArray;
        if(carry > 0){
            newArray = new int[digits.length + 1];
            newArray[0] = carry;
            System.arraycopy(digits, 0, newArray, 1, newArray.length - 1);
        }else{
            newArray = digits;
        }
        return newArray;
    }
}
