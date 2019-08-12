package qushikeji.pro2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int co = 0;
    private static String process(String num1, String num2) {
        String[] moneys = num1.split(" ");
        int[] moneysIntArray = new int[moneys.length];
        for(int i = 0; i < moneys.length; ++i) {
            moneysIntArray[i] = Integer.valueOf(moneys[i]);
        }
        dfs(moneysIntArray, Integer.valueOf(num2), 0, 1);
        return "" + (co == 0 ? -1 : 0);
    }

    private static void dfs(int[] moneys, int total, int length, int money) {
        if(total == 0) {
            co += length;
            return;
        }
        if(total < 0){
            return;
        }
        if(money == -1){
            return;
        }
        int nextMoney;
        int index = 0;
        switch (money) {
            case 1:
                nextMoney = 5;
                index = 0;
                break;
            case 5:
                nextMoney = 10;                index = 1;

                break;
            case 10:
                nextMoney = 20;                index = 2;

                break;
            case 20:
                nextMoney = 50;                index = 3;

                break;
            case 50:
                nextMoney = 100;                index = 4;

                break;
            case 100:
                nextMoney = -1;
                break;
            default:
                nextMoney = -1;
        }

        int e = moneys[index];
        int max = total / money;
        max = Integer.min(max, e);
        for(int i = 0; i <= max; ++i) {
            dfs(moneys ,total - i * money, length + i, nextMoney);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strValueSequences = sc.nextLine();
        String strChargeNum = sc.nextLine();

        String sum = process(strValueSequences, strChargeNum);
        System.out.println(sum);
    }
}