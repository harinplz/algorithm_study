import java.io.*;
import java.util.*;

public class Main {
  
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카드 놀이 진행 
		while(m-->0) {
			Arrays.sort(arr);
			
			long sum = arr[0] + arr[1];
			arr[0] = sum;
			arr[1] = sum;
		}
		
		// 카드의 총 합 구하기 
		long ans = 0;
		for(long num : arr) {
			ans += num;
		}
		
		System.out.println(ans);
	}

}
