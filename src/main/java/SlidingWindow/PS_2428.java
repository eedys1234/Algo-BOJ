package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PS_2428 {

    public static void main(String... args) throws IOException {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(inbr.readLine());
        int[] file_size = new int[n];
        long count = 0;

        String[] temp = inbr.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<temp.length;i++)
        {
            file_size[i] = Integer.valueOf(temp[i]);
        }

        Arrays.sort(file_size);

        for(int i=0;i<file_size.length;i++)
        {
            while(!queue.isEmpty() && queue.peek() < 0.9 * file_size[i]) {
                queue.poll();
            }

            count += queue.size();
            queue.offer(file_size[i]);
        }

        System.out.println(count);
    }
}
