import java.io.*;
import java.util.*;

public class BOJ_브론즈1_2748_피보나치수2 {
	
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long dp[] = new long[91];

        dp[0] = 0;
        dp[1] = 1;

        if(n > 1) {
            for(int i=2; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[n]);
	}
	
}
