import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 동전 입력받기 
		int[] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[k+1];
		Arrays.fill(dp, 10001);
		
		dp[0] = 0;
		
		for(int i=1; i<=k; i++) {
			for(int j=0; j<n; j++) {
				if(i >= coin[j]) dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
			}
		}
		
		int ans = dp[k] == 10001 ? -1 : dp[k];
		System.out.println(ans);
		
		
	}
	
}
