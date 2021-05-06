package BipartiteMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PS_11367 {

    public static boolean[] visited;
    public static int[] d;

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = inbr.readLine().split(" ");
        int n = Integer.valueOf(temp[0]);
        int m = Integer.valueOf(temp[1]);
        List<List<Integer>> adj = new ArrayList<>();
        visited = new boolean[m+1];
        d = new int[m+1];

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<=n;i++)
        {
            temp = inbr.readLine().split(" ");
            int k = Integer.valueOf(temp[0]);
            for(int j=1;j<=k;j++) {
                adj.get(i).add(Integer.valueOf(temp[j]));
            }
        }

        int count = 0;

        for(int k=0;k<2;k++) {
            for(int i=1;i<=n;i++) {
                if(dfs(adj, i)) {
                    count++;
                }
                Arrays.fill(visited, false);
            }
        }

        System.out.print(count);

    }

    public static boolean dfs(List<List<Integer>> adj, int start) {

        for(int i=0;i<adj.get(start).size();i++)
        {
            int t = adj.get(start).get(i);

            if(visited[t]) {
                continue;
            }

            visited[t] = true;

            if(d[t] == 0 || dfs(adj, d[t])) {
                d[t] = start;
                return true;
            }

        }

        return false;
    }
}
