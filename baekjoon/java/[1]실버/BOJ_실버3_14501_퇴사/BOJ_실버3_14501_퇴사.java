import java.io.*;
import java.util.*;

public class BOJ_실버3_14501_퇴사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		int time[] = new int[N+1];
		int cost[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1];
		dp[1] = cost[1];
		int ans = time[1] + 1 > N+1 ? 0 : dp[1]; // 한 번도 상담을 안할 수 있다는 것을 생각! 
		
		for(int i=2; i<=N; i++) {
			if(time[i] + i > N+1) continue;
			dp[i] = cost[i];
			for(int j=1; j<i; j++) {
				if(j + time[j] <= i) {
					dp[i] = Math.max(dp[i], dp[j] + cost[i]);
				}
			}
			
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}
}
