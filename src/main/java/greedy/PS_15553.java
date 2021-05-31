package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PS_15553 {

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = inbr.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int[] friends = new int[n];

        for(int i=0;i<n;i++)
        {
            friends[i] = Integer.parseInt(inbr.readLine());
        }



    }
}
