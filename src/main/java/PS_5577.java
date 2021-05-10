import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PS_5577 {

    public static void main(String[] args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(inbr.readLine());
        int[] org_pang = new int[n];
        int[] copy_pang = new int[n];
        boolean isSub = false;

        for(int i=0;i<n;i++) {
            org_pang[i] = Integer.valueOf(inbr.readLine());
            copy_pang[i] = org_pang[i];
        }

        while(true) {
            int len = copy_pang.length;

            if(len >= 1) {

                int init = copy_pang[0];
                int cnt = 1;

                for (int i = 1; i < copy_pang.length; i++) {
                    if (init == copy_pang[i]) {
                        cnt++;
                    } else {
                        if (cnt >= 4) {
//                    i = 0, 1, 2, 3
                            int start_index = i - cnt + 1;
                            int end_index = i;
                            AtomicInteger auto = new AtomicInteger();

                            copy_pang = Arrays.stream(copy_pang).filter(value -> {
                                int index = auto.getAndIncrement();

                                if (start_index > index && index > end_index) {
                                    return true;
                                }
                                return false;
                            }).toArray();
                            isSub = true;
                            break;
                        }
                    }
                }
            }

            if(!isSub) {
                System.out.println(copy_pang.length);
                return;
            }
            isSub = false;
        }
    }
}
