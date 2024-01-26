import java.io.*;
import java.util.*;

public class BOJ_실버1_2156_포도주시식 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {  
			if(i == 1) dp[1] = arr[1];
			else if(i == 2) dp[2] = arr[1] + arr[2];
			else dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]));
		}
		
		System.out.println(dp[n]);
	}
}
