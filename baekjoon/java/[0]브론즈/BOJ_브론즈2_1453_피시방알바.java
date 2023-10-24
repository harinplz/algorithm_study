import java.io.*;
import java.util.*;

public class BOJ_브론즈2_1453_피시방알바 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int ans = 0; // 거절 수 
        // PC방 자리 배열 만들기
        boolean[] pcroom = new boolean[101];
        
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        // PC방 자리 채우기
        // 만약 값이 true라면 (채워져있다면) 거절의 수(ans)를 증가시킨다.
        for(int i=0; i<N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if(pcroom[pos]) ans++;
            else pcroom[pos] = true;
        }
        
        System.out.println(ans);
	}

}
