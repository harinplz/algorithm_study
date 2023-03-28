package ssafy.com.BOJ.silver;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_1149_RGB거리 {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		//1. 동적 테이블 생성
		int dp[][] = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//i에서 빨간색을 골랐을 때 최솟값 (전에  초록색 혹은 파란색 고름)
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
			//i에서 초록색을 골랐을 때 최솟값 (전에 빨간색 혹은 파란색 고름)
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
			//i에서 파란색을 골랐을 때 최솟값 (전에 빨간색 혹은 초록색 고름)
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		
	}
	
}
