import java.io.*;
import java.util.*;

public class BOJ_브론즈4_5717_상근이의친구들
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;
            sb.append(N+M).append('\n');
        }

        System.out.println(sb);
    }
}
