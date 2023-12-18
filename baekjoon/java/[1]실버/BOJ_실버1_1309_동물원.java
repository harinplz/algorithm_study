import java.io.*;
import java.util.*;

public class BOJ_실버1_1309_동물원 {
	
	/*
	 * 풀이 시간 : 21분 18초 
	 * 풀이 방법 : DP 
	 * 메모리 : 11900KB, 시간 : 84ms 
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int dp[] = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 3;
		
		if(N>=2) {
			for(int i=2; i<=N; i++) {
				dp[i] = dp[i-2] * 3 + (dp[i-1] - dp[i-2]) * 2;
				dp[i] = dp[i] % 9901;
			}
		}
		
		System.out.println(dp[N]);
		
	}
	
	
}
