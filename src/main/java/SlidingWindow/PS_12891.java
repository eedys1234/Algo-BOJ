package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PS_12891 {

    public static void main(String... args) throws IOException {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        boolean isPassword = true;
        long result = 0;

        String[] temp = inbr.readLine().split(" ");

        int s = Integer.parseInt(temp[0]);
        int p = Integer.parseInt(temp[1]);

        Map<Character, Integer> condition = new HashMap<>();
        Map<Character, Integer> base = new HashMap<>();

        String dna = inbr.readLine();
        int len = s - p + 1;

        temp = inbr.readLine().split(" ");

        condition.put('A', Integer.parseInt(temp[0]));
        condition.put('C', Integer.parseInt(temp[1]));
        condition.put('G', Integer.parseInt(temp[2]));
        condition.put('T', Integer.parseInt(temp[3]));

        base.put('A', 0);
        base.put('C', 0);
        base.put('G', 0);
        base.put('T', 0);

        for(int i=0;i<len;i++)
        {
            isPassword = true;

            if(i == 0) {
                for(int j=0;j<p;j++)
                {
                    char character = dna.charAt(j);
                    base.put(character, base.get(character)+1);
                }
            }
            else {
                char character = dna.charAt(i+p-1);
                base.put(character, base.get(character)+1);
                character = dna.charAt(i-1);
                base.put(character, base.get(character)-1);
            }

            for(Map.Entry<Character, Integer> entry : base.entrySet())
            {
                Character key = entry.getKey();
                Integer value = entry.getValue();

                if(condition.get(key) > value) {
                    isPassword = false;
                }
            }

            if(isPassword) {
                result++;
            }
        }

        System.out.println(result);

    }
}
