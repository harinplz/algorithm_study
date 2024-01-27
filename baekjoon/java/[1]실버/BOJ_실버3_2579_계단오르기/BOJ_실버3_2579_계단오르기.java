import java.io.*;
import java.util.*;

public class BOJ_실버3_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			if(i==1) dp[i] = arr[1];
			else if(i==2) dp[i] = arr[1] + arr[2];
			else dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
		}
		
		System.out.println(dp[N]);
	}
}
