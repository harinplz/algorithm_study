import java.io.*;
import java.util.*;

public class BOJ_실버1_1890_점프 {
	
	/*
	 * 풀이 시간 : 오후 2시 49분 ~ 오후 3시 11분 
	 * 풀이 방법 : DP
	 * 시간 : 11820KB, 시간 : 84ms 
	 */

	public static void main(String[] args) throws Exception {
		// 1. 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int map[][] = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long dp[][] = new long[N][N];
		// 초기화 
		if(map[0][0] < N) {
			dp[0][map[0][0]] += 1;
			dp[map[0][0]][0] += 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(dp[i][j] != 0 && map[i][j] != 0) {
					if(j + map[i][j] < N) dp[i][j+map[i][j]] += dp[i][j];
					if(i + map[i][j] < N) dp[i+map[i][j]][j] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);	
	}
}
