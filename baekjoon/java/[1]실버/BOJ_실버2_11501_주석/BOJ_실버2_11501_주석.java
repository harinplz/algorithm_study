import java.io.*;
import java.util.*;

public class BOJ_실버2_11501_주석 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N;
		int[] arr;
		StringTokenizer st;
		
		while(T-->0) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N + 1];
			
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 최대 이익 구하기 
			long ans = 0;
			int max = arr[N];
			
			for(int i=N-1; i>=1; i--) {
				if(max > arr[i]) {
					ans += max - arr[i];
				}
				else {
					max = arr[i];
				}
			}
			
			sb.append(ans + "\n");
			
		}
		System.out.println(sb);
	}
	
	
}
