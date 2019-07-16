package medium;

import easy.AddBinary;

import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        String result = "0";
        for(int i = num2.length() - 1; i >= 0; --i){
            char[] fill = new char[num2.length() - i - 1];
            Arrays.fill(fill, '0');
            result = AddBinary.addString(result, multiply(num1, num2.charAt(i)) + new String(fill), 10);
        }
        char[] compare = new char[result.length()];
        Arrays.fill(compare, '0');
        return result .equals(new String(compare)) ? "0" : result;
    }

    private String multiply(String num1, char ch){
        char[] array = new char[num1.length()];
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; --i){
            int tmpResult = (num1.charAt(i) - '0') * (ch - '0') + carry;
            array[i] = (char) ('0' + tmpResult % 10);
            carry = tmpResult / 10;
        }
        return carry > 0 ? carry + new String(array) : new String(array);
    }
    public String anotherSolution(String num1, String num2){
        int length1 = num1.length();
        int length2 = num2.length();

        char[] result = new char[(length1 > length2 ? length1 : length2) + 1];
        Arrays.fill(result, '0');
        for(int i = 0; i < num1.length(); ++i){
            for(int j = 0; j < num2.length(); ++j){
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(i) - '0');
                result[i + j] = (char) (tmp / 10);
            }
        }
        return null;
    }

}

/*


import java.util.Arrays;

class Solution {
    public String multiply(String num1, String num2) {
         String result = "0";
        for(int i = num2.length() - 1; i >= 0; --i){
            char[] fill = new char[num2.length() - i - 1];
            Arrays.fill(fill, '0');
            result = addString(result, multiply(num1, num2.charAt(i)) + new String(fill), 10);
        }
  char[] compare = new char[result.length()];
        Arrays.fill(compare, '0');
        return result .equals(new String(compare)) ? "0" : result;
    }

    private String multiply(String num1, char ch){
        char[] array = new char[num1.length()];
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; --i){
            int tmpResult = (num1.charAt(i) - '0') * (ch - '0') + carry;
            array[i] = (char) ('0' + tmpResult % 10);
            carry = tmpResult / 10;
        }
        return carry > 0 ? carry + new String(array) : new String(array);
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
 */
