package SlidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PS_11003 {

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = inbr.readLine().split(" ");
        Deque<Pair> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(temp[0]);
        int l = Integer.valueOf(temp[1]);

        int[] values = new int[n];
        temp = inbr.readLine().split(" ");

        for(int i=0;i<temp.length;i++)
        {
            values[i] = Integer.valueOf(temp[i]);
        }

        //deque가 오름차순으로 되어있다고 가장

        for(int i=0;i<values.length;i++)
        {

            if(!deque.isEmpty() && deque.peekFirst().getIndex() <= i - l) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && deque.peekLast().getValue() > values[i]) {
                deque.pollLast();
            }

            deque.offerLast(new Pair(values[i], i));
            sb.append(deque.peekFirst().getValue()).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static class Pair {

        private int value;
        private int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

}
