import java.io.*;
import java.util.*;

public class BOJ_실버1_12852_1로만들기2 {

	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		sb.append(N + " ");
		int dp[] = new int[N+1];
		arr = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			arr[i] = i-1;
			if(i%2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				arr[i] = i/2;
			}
			if(i%3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				arr[i] = i/3;
			}
		}
		
		DFS(N);
		
		System.out.println(dp[N]);
		System.out.println(sb);
	}
	
	public static void DFS(int num) {
		if(num == 1) return;
		
		sb.append(arr[num] + " ");
		DFS(arr[num]);
	}
}
