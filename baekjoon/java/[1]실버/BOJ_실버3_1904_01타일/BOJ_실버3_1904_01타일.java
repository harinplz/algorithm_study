import java.io.*;
import java.util.*;

public class BOJ_실버3_1904_01타일 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int dp[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(i==1) dp[i] = 1;
			else if(i==2) dp[i] = 2;
			else dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		
		System.out.println(dp[N] % 15746);
		
	}

}
