import java.io.*;
import java.util.*;

public class BOJ_실버2_1965_상자넣기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int box[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1];
		int ans = Integer.MIN_VALUE;
		
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(box[j] < box[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				ans = Math.max(dp[i], ans);
			}
		}
		
		System.out.println(ans);
		
	}
}
