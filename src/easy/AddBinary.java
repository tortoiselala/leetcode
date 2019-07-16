package easy;

// https://leetcode.com/problems/add-binary/

import java.util.Arrays;

/**
 * Given two binary strings,
 * return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        return addString(a, b, 2);
    }

    public static String addString(String a, String b, int x){
        int lengthA = a.length();
        int lengthB = b.length();
        if(lengthA > lengthB){
            char[] array = new char[lengthA - lengthB];
            Arrays.fill(array, '0');
            b = new String(array) + b;
        }else{
            char[] array = new char[lengthB - lengthA];
            Arrays.fill(array, '0');
            a = new String(array) + a;
        }
        char[] result = new char[a.length()];
        int carry = 0;
        for(int i = a.length() - 1; i >= 0; --i){
            int sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            result[i] = (char) ('0' + sum % x);
            carry = sum / x;
        }
        return carry > 0 ? carry + new String(result) : new String(result);
    }
}
