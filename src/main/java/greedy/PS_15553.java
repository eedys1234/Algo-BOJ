package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

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

        int result = friends[friends.length-1] + 1 - friends[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=1;i< friends.length;i++)
        {
            pq.offer(friends[i] - (friends[i-1] + 1));
        }

        while(k-- > 1) {
            result -= pq.poll();
        }

        System.out.println(result);
    }
}
