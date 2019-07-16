package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/add-to-array-form-of-integer/

/**
 * For a non-negative integer X,
 * the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X,
 * return the array-form of the integer X+K.
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        int carry = 0;
        for(int i = A.length - 1; i >= 0; --i) {
            if(i == A.length - 1){
                A[i] = A[i] + K;
            }
            A[i]  = A[i] + carry;
            list.add(A[i] % 10);
            carry = A[i] / 10;
        }
        while(carry > 0){
            list.add(carry % 10);
            carry /= 10;
        }


        List<Integer> reverse = new LinkedList<>();
        for(Integer e : list){
            reverse.add(0, e);
        }
        return reverse;
    }
}
