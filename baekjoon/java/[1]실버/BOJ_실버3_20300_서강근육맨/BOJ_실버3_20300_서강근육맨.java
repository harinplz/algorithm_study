import java.io.*;
import java.util.*;

public class BOJ_실버3_20300_서강근육맨 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long arr[] = new long[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr); // 오름차순 정렬 
		
		long M = 0;
		
		// 짝수일 경우 
		if(N%2 == 0) {
			for(int i=0; i<N/2; i++) {
				M = Math.max(M, arr[i] + arr[N-i-1]);
			}
		}
		else {
			for(int i=0; i<N/2; i++) {
				M = Math.max(M, arr[i] + arr[N-i-2]);
			}
			M = Math.max(M, arr[N-1]);
		}
 
		System.out.println(M);
		
	}


}
