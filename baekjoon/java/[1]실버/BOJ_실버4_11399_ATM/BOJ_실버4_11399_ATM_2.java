import java.io.*;
import java.util.*;

public class BOJ_실버4_11399_ATM_2 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int p[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬하기 
		Arrays.sort(p);
		
		// 누적해서 합하기 
		for(int i=1; i<N; i++) {
			p[i] += p[i-1];
		}
		
		// 누적합한 배열의 전체 값 더하기 
		int ans = 0;
		for(int num : p) {
			ans += num;
		}
		
		System.out.println(ans);
	
	}


}
