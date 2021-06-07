package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PS_2405 {

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(inbr.readLine());
        int[] num = new int[n];

        for(int i=0;i<n;i++)
        {
            num[i] = Integer.parseInt(inbr.readLine());
        }

        //sorting
        Arrays.sort(num);

        int val = num[0] + num[num.length-1];
        long max = 0;
        for(int i=1;i<num.length-1;i++)
        {
            max = Math.max(max, Math.abs(2 * num[i] - val));
        }

        System.out.println(max);
    }

}
