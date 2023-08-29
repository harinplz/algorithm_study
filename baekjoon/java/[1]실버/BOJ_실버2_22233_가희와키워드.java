import java.io.*;
import java.util.*;

public class BOJ_실버2_22233_가희와키워드 {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> keyword = new HashMap<>();

        for(int i=0; i<N; i++) {
            String word = in.readLine();
            keyword.put(word, true);
        }

        int ans = keyword.size();
        for(int i=0; i<M; i++) {
            String[] split = in.readLine().split(",");
            for(int j=0; j<split.length; j++) {
                String word = split[j];
                if(keyword.containsKey(word)){
                    keyword.remove(word);
                    ans--;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
