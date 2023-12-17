import java.io.*;
import java.util.*;

public class BOJ_골드5_5582_공통부분문자열 {
	
	/*
	 * 풀이 시간 : 블참 (ㅠㅠ)
	 * 풀이 방법 : DP 
	 * 메모리 : 74505KB, 시간 : 192ms 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = in.readLine();
		String str2 = in.readLine();
		
		int dp[][] = new int[str1.length() + 1][str2.length() + 1]; // DP 배열 생성 
		
		int ans = 0;
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	
}
