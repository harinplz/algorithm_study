import java.io.*;
import java.util.*;

public class BOJ_실버2_1912_연속합_2 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		int max = dp[1];
		
		for(int i=2; i<=n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}


}
