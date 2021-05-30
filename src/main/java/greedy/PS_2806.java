package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PS_2806 {

    public static int[][] dp;
    public static final int MAX = 100000000;

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(inbr.readLine());
        dp = new int[2][n];
        String dna = inbr.readLine();

        //초기화
        for(int i=0;i<n;i++)
        {
            dp[0][i] = dp[1][i] = MAX;
        }

        if(dna.charAt(0) == 'A') {
            dp[0][0] = 0;
            dp[1][0] = 1;
        }
        else {
            dp[0][0] = 1;
            dp[1][0] = 0;
        }

        for(int i=1;i<n;i++)
        {
            if(dna.charAt(i) == 'A') {
                dp[0][i] = Math.min(dp[0][i-1], dp[1][i-1] + 1);
                dp[1][i] = Math.min(dp[0][i-1] + 1, dp[1][i-1] + 1);
            }
            else {
                dp[0][i] = Math.min(dp[0][i-1] + 1, dp[1][i-1] + 1);
                dp[1][i] = Math.min(dp[0][i-1] + 1, dp[1][i-1]);
            }
        }

        System.out.println(dp[0][n-1]);
    }

}
