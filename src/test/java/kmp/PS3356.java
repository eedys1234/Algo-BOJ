package kmp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@SpringBootTest(classes = BOJApplication.class)
public class PS3356 {

    /**
     * 풀이
     * 1) S는 S1 + S1 + S1으로 구성
     * 2) 우선적으로 연속적으로 이루어진 패턴을 구해야하는 문제
     * 3) 패턴을 구하기 위해서 원본 문자열을 원본문자열의 첫번째 자리, 두번째 자리, 세번째 자리, 네번째 자리, .... 원본문자열로 분할
     */
    @Test
    public void 라디오_전송() throws Exception {

//        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.valueOf(inbr.readLine());
//        String value = inbr.readLine();

        //givne
        int n = 8;
        String value = "cabcabca";
        int len = value.length();
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        int[] table = new int[value.length()];
        char[] pattern = value.toCharArray();

        //when
        for(int i=1;i<=len;i++)
        {
            cnt = 0;
            List<Integer> list = kmp(value, pattern, i, table);
            //i = 1 : 0, 1, 2, 3, 4, -> 0, 1, 2, 3, 4,
            //i = 2 : 0, 2, 4, 6, 8, -> 0, 1, 2, 3,
            //i = 3 : 0, 3, 6, 9, 12,

            for(int j=0;j<list.size();j++)
            {
                if(list.get(j) % i == 0) {
                    cnt++;
                }
            }

            if(cnt == len/i) {
                min = Math.min(min, i);
                break;
            }

            list.clear();

        }

        assertEquals(3, min);
        System.out.println(min);
    }

    private List<Integer> kmp(String value, char[] pattern, int k, int[] table) {

        List<Integer> list = new ArrayList<>();
        failurFunction(pattern, k, table);
        int len = value.length();

        for(int i=0,j=0;i<len;i++)
        {
            while(j > 0 && value.charAt(i) != pattern[j])
            {
                j = table[j - 1];
            }

            if(value.charAt(i) == pattern[j]) {

                if(j == k - 1) {

                    list.add(i - j);
                    j = table[j];
                }
                else {
                    j++;
                }
            }
        }

        return list;
    }

    private int[] failurFunction(char[] value, int k, int[] table) {

        int len = k;

        for(int i=1,j=0;i<len;i++)
        {
            while(j > 0 && value[i] != value[j]) {

                j = table[j - 1];
            }

            if(value[i] == value[j]) {
                table[i] = ++j;
            }
        }

        return table;
    }
}
