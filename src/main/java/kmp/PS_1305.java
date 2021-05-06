package kmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PS_1305 {

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.valueOf(inbr.readLine());
        String value = inbr.readLine();

        int min = failurFunc(l, value);
        System.out.println(min);
    }

    public static int failurFunc(int l, String value) {

        int[] table = new int[l];

        for(int i=1,j=0;i<l;i++)
        {
            while(j > 0 && value.charAt(i) != value.charAt(j)) {
                j = table[j - 1];
            }

            if(value.charAt(i) == value.charAt(j)) {
                table[i] = ++j;
            }
        }

        return l - table[l - 1];
    }
}
