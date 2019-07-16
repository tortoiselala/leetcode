package easy;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int carry = 0;
        int result = 0;
        int mark = 1;
        int sum = 0;
        for(int i = 0; i < 32; ++i){
            sum = (a ^ b ^ carry) & mark;
            carry = ((a & b) | ((a ^ b) & carry)) & mark;
            result |= sum;
            mark <<= 1;
            carry <<= 1;
        }
        return result;
    }
}
