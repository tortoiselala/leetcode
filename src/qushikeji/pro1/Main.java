package qushikeji.pro1;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
    public static String add(String a, String b) {
        int dotIndexA = a.indexOf('.');
        int dotIndexB = b.indexOf('.');
        String integerA, decimalA;
        String integerB, decimalB;
        if(dotIndexA != -1){
            integerA= a.substring(0, dotIndexA);
            if(dotIndexA != a.length() - 1) {
                decimalA = a.substring(dotIndexA + 1);
            }else{
                decimalA = "0";
            }
        }else{
            integerA = a;
            decimalA = "0";
        }

        if(dotIndexB != -1){
            integerB= a.substring(0, dotIndexA);
            if(dotIndexA != a.length() - 1) {
                decimalB = a.substring(dotIndexB + 1);
            }else{
                decimalB = "0";
            }
        }else{
            integerB = a;
            decimalB = "0";
        }

        String[] decimalResul = addDecimal(decimalA, decimalB);
        integerA = new StringBuffer(integerA).reverse().toString();
        integerB = new StringBuffer(integerB).reverse().toString();
        String[] integerResul = addInteger(integerA, integerB, false);
        if(decimalResul[1].equals('1')){
            integerResul =  addInteger(integerResul[0], decimalResul[1], false);
        }

        return new StringBuffer(integerResul[0]).reverse().toString() + '.' + decimalResul[0];

    }
    // 10.20000
    // 20.30
    private static String[] addInteger(String a, String b, boolean decimal){
        StringBuilder sb = new StringBuilder();
        if(a.length() > b.length()) {
            String e = a;
            a = b;
            b = e;
        }
        int carry = 0;
        for(int i = 0; i < a.length(); ++i){
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }

        for(int i = a.length(); i < b.length(); ++i){
            int sum = carry + (b.charAt(i) - 1);
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        String[] res;
        if(decimal) {
            res = new String[]{sb.toString(), "" + carry};
        }else{
            if(carry > 0){
                sb.append(carry);
            }
            res = new String[]{sb.toString(), "0"};
        }

        return res;
    }

    private static String[] addDecimal(String a, String b){
        if(a.length() > b.length()){
            String t = a;
            a = b;
            b = t;
        }
        int sub = b.length() - a.length();
        char[] array = new char[sub];
        Arrays.fill(array, '0');
        String tail = new String(array);
        a += tail;
        String[] re = addInteger(a, b, true);
        return re;
    }
}