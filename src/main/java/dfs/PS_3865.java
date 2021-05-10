package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PS_3865 {
    public static int count = 0;

    public static void main(String... args) throws Exception {

        BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.valueOf(inbr.readLine());
            if(n == 0) {
                break;
            }
            count = 0;
            String[] temp = new String[n];

            for(int i=0;i<n;i++)
            {
                temp[i] = inbr.readLine();
            }

            Map<String, List<String>> store = new LinkedHashMap<>();

            Map<String, Boolean> visited = Stream.of(temp)
                    .flatMap(key -> Stream.of(key.split(":")[1].replace(".", "").split(",")))
                    .collect(Collectors.toSet())
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), key -> false));

            for(int i=0;i<temp.length;i++)
            {
                String[] value = temp[i].split(":");
                String academy = value[0];
                List<String> list = Stream.of(value[1].replace(".", "").split(","))
                                            .collect(Collectors.toList());
                store.put(academy, list);
            }

            dfs(store, visited, temp[0].split(":")[0]);
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());

    }


    public static void dfs(Map<String, List<String>> store, Map<String, Boolean> visited, String start) {

        List<String> list = store.get(start);

        for(String str : list)
        {
            if(!visited.get(str)) {
                visited.put(str, true);
                if(store.containsKey(str)) {
                    dfs(store, visited, str);
                }
                else {
                    count++;
                }
            }
        }
    }
}
