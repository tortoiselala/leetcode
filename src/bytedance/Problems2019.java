package bytedance;

import java.util.Scanner;

public class Problems2019 {
    public static void main(String[] args) {
//        automaticProofreadingProgram();
//        getLocations();
        coinNums();
    }

    private static void automaticProofreadingProgram(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] params = new String[n];
        for(int i = 0; i < n; ++i){
            params[i] = scanner.next();
            System.out.println(automaticProofreadingProgram(params[i]));
        }
        scanner.close();
    }

    private static String automaticProofreadingProgram(String str){
        int len = str.length();
        int loop = 0;
        while(true) {
            if(loop >= len){
                break;
            }

            char fi = str.charAt(loop);
            char se = loop + 1 < len ? str.charAt(loop + 1) : '0';
            char th = loop + 2 < len ? str.charAt(loop + 2) : '0';
            char fo = loop + 3 < len ? str.charAt(loop + 3) : '0';
            if (loop < len - 2 && (fi == se && se == th)) {
                str = str.substring(0, loop + 2) + (loop + 3 < str.length() ? str.substring(loop + 3) : "");
                len = str.length();
            } else if (loop < len - 3 && (fi == se && th == fo)) {
                str = str.substring(0, loop + 3) + (loop + 4 < str.length() ? str.substring(loop + 4) : "");
                len = str.length();
            } else {
                ++loop;
            }
        }
        return str;
    }

    private static void getLocations(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();

        int[] lo = new int[N];
        for(int i = 0; i < N; ++i){
            lo[i] = scanner.nextInt();
        }

        int count = 0;
        for(int i = 0; i < N; ++i){
            count += getLocations(D, lo, i);
            count %= 99997867;
        }
        System.out.println(count);
    }

    private static int getLocations(int D, int[] lo, int cur){
        int count = 0;
        for(int i = cur + 1; i < lo.length; ++i){
            if(lo[i] <= lo[cur] + D){
                count += getLocations(D, lo, cur, i);
            }else{
                break;
            }
        }
        return count % 99997867;
    }

    private static int getLocations(int D, int[] lo, int pre, int cur){
        int count = 0;
        for(int i = cur + 1; i < lo.length; ++i){
            if(lo[i] <= lo[pre] + D){
                ++count;
            }else{
                break;
            }
        }
        return count % 99997867;
    }

    private static void coinNums(){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = 1024 - n;
        int count = 0;
        if(r >= 64){
            count += r / 64;
            r %= 64;
        }

        if(r >= 16){
            count += r / 16;
            r %= 16;
        }
        if(r >= 4){
            count += r / 4;
            r %= 4;
        }
        count += r;
        System.out.println(count);
        scanner.close();
    }
}