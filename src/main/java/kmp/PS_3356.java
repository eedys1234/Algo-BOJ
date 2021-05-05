package kmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 풀이
 * 1) S는 S1 + S1 + S1으로 구성
 * 2) 우선적으로 연속적으로 이루어진 패턴을 구해야하는 문제
 * 3) 패턴을 구하기 위해서 원본 문자열을 원본문자열의 첫번째 자리, 두번째 자리, 세번째 자리, 네번째 자리, .... 원본문자열로 분할
 */
public class PS_3356 {

    public static void main(String[] args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(inbr.readLine());
        String value = inbr.readLine();

        int min = FailurFunc(value);
        System.out.println(min);
    }

    public static int FailurFunc(String pattern) {

        int len = pattern.length();
        int[] table = new int[len];
        int index = Integer.MAX_VALUE;

        for(int i=1,j=0;i<len;i++) {

            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
                index = Math.min(index, i);
            }
        }

        return len - table[len-1];

    }
}
