import java.io.*;
import java.util.*;

public class BOJ_실버2_1912_연속합 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int arr[] = new int [n];
		int dp[] = new int [n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		int ans = dp[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i], dp[i-1] + arr[i]);
			ans = Math.max(dp[i], ans);
		}
		
		System.out.println(ans);
	}
}
