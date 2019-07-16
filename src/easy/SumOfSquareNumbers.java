package easy;

// https://leetcode.com/problems/sum-of-square-numbers/solution/

/**
 * Given a non-negative integer c,
 * your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(4));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(1));
    }

    public boolean judgeSquareSum(int c) {
        return bruteForce(c);
    }

    // Time Limited
    private boolean bruteForce(int c){
        for(int i = 0; i <= c; ++i){
            if(i * i > c){
                break;
            }
            for(int j = 0; j <= c; ++j){
                int result = i * i + j * j;
                if(result == c){
                    return true;
                }else if(result > c){
                    break;
                }
            }
        }
        return false;
    }

    private boolean usingSqrt(int c){
        for(int i = 0; i <= c; ++i){
            int b = c - i * i;
            int x = (int) Math.sqrt(b);
            if(b < 0){
                return false;
            }
            if(x * x == b){
                return true;
            }
        }
        return false;
    }

    private boolean usingBinarySearch(int c){
        for(int i = 0; i <= c; ++i){
            int b = c - i * i;
            if(b < 0){
                return false;
            }
            if(binarySearch(b)){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int c){
       return new ValidPerfectSquare().isPerfectSquare(c);
    }
}
