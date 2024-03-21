import java.io.*;
import java.util.*;

public class BOJ_실버2_15988_123더하기3 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		long dp[] = new long[1000001];
		
		dp[1] = 1;
		dp[2] = dp[1] + 1;
		dp[3] = dp[1] + dp[2] + 1;
		
		for(int i=4; i<=1000000; i++) {
			dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
		}
		
		while(T-->0) {
			int n = Integer.parseInt(in.readLine());
			
			sb.append(dp[n] + "\n");
		}
		
		System.out.println(sb);
	}
	
}
