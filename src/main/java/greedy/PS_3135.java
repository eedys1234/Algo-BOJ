package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PS_3135 {

    //a -> b로 이동(+, -)
    //a -> b 이동횟수와 a에서 즐겨찾기 주파수 이동 후(1) -> b 이동횟수
    //즐겾찾기 주파수로 이동한 후 b와의 차이가 가장 작은게 적게 이동
    public int moveShortestCount(String first, String second, String[] thirty) {

        int resValue = 0;

        //a, b 추출
        String[] temp = first.split(" ");

        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);

        //n 추출
        int n = Integer.parseInt(second);
        int[] bookmark = new int[thirty.length];
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            bookmark[i] = Integer.parseInt(thirty[i]);

            if(min > Math.abs(b - bookmark[i])) {
                min = Math.abs(b - bookmark[i]);
            }
        }

        resValue = Math.abs(a - b) < 1 + min ? Math.abs(a - b) : 1 + min;
        return resValue;
    }

    public static void main(String... args) throws Exception {

        //given
        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        String first_line = inbr.readLine();
        String second_line = inbr.readLine();
        int n = Integer.parseInt(second_line);
        String[] thirty_line = new String[n];

        for(int i=0;i<n;i++)
        {
            thirty_line[i] = inbr.readLine();
        }

        PS_3135 ps = new PS_3135();
        int expected = ps.moveShortestCount(first_line, second_line, thirty_line);
        System.out.println(expected);
    }
}
