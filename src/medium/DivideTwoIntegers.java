package medium;

/**
 * Created by tortoiselala on 2019-05-29
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean sign = !((dividend > 0 && divisor < 0) || (dividend < 0 && divisor >0));

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);


        long res = ldivide(ldividend, ldivisor);

        if(res > Integer.MAX_VALUE){
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (sign ? res : -res);
    }

    private long ldivide(long ldividend, long ldivisor){
        if(ldivisor > ldividend){
            return 0;
        }

        long multiple = 1;
        long sum = ldivisor;
        while((sum + sum) < ldividend){
            sum += sum;
            multiple += multiple;
        }

        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
