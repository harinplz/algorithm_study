package ssafy.com.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버3_11659_구간합구하기4 {
	
	/**
	 * 출력과 split을 위한 StringBuilder, StringTokenizer 선언
	 */
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		//입력을 위한 BufferedReader 선언
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		//N, M 입력 받음
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//값들의 합을 저장하는 배열 dp 선언
		int dp[] = new int[N+1];
		
		st = new StringTokenizer(in.readLine());
		
		//dp 배열 i번째에는 인덱스 1부터 i번쨰까지의 수의 합을 저장한다.
		for(int i = 1;i<=N;i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) { //M만큼 반복
			st = new StringTokenizer(in.readLine());
			//구간을 시작하는 인덱스와 끝나는 인덱스를 입력받음.
			int startIdx = Integer.parseInt(st.nextToken()); 
			int endIdx = Integer.parseInt(st.nextToken());
			
			int ans = dp[endIdx] - dp[startIdx-1];
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
