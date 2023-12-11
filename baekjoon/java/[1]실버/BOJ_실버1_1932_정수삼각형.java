import java.io.*;
import java.util.*;

public class BOJ_실버1_1932_정수삼각형 {
	
	/*
	 * 풀이 시간 : 블로그 참고 
	 * 풀이 방법 : DP 
	 * 메모리 : 25232KB, 시간 : 232ms 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것만 가능하다. 
		// 선택을 어떻게 할 것인가? 
		
		// 참고 : https://dding9code.tistory.com/10
		// 위에서부터 아래까지 값을 더하고 내려가며 최하단 층에서 최댓값을 구한다. 
		// 즉, d[i][j], (i,j) 에 도착했을 때 합의 최댓값이라고 생각한다. 
		// 어떤 수가 선택되기 전 선택된 수는 왼쪽 위, 오른쪽 위에 있다.
		// 즉, (i, j)가 선택되기 전에 선택된 수는 (i-1, j-1) 왼쪽 위, (i-1, j) 오른쪽 위이다.
		// 즉 점화식은 d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + a[i][j] 이다. 
		
		// 그 후, 최하단에 최댓값이 모아져있으므로 마지막 층에서 MAX 값을 찾으면 된다. 
		
		int N = Integer.parseInt(in.readLine());
		
		int arr[][] = new int[N+1][N+1];
		int d[][] = new int[N+1][N+1];
		
		// 입력 
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최댓값 구하기 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + arr[i][j];
			}
		}
		
		// 최하단층에서 최댓값 구하기 
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, d[N][i]);
		}
 		
		System.out.println(ans);
	}
	
	
	
}
