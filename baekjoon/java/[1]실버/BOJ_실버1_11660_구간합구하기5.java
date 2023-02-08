package ssafy.com.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_11660_구간합구하기5 {
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[N+1][N+1];
		
		// 행의 합을 저장하는 배열 dp 
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1;j<=N;j++) {
				if (j==1) dp[i][j] = Integer.parseInt(st.nextToken());
				else {
					dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//M만큼 반복
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(in.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			
			for(int j = r1; j<=r2;j++) {
				ans += dp[j][c2] - dp[j][c1-1]; 
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
}
