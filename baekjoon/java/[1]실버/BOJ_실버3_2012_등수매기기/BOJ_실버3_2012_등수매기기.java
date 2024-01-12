import java.io.*;
import java.util.*;

public class BOJ_실버3_2012_등수매기기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int arr[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		long ans = 0;
		
		Arrays.sort(arr);
		
		for(int i=1; i<=N; i++) {
			ans += Math.abs(arr[i]-i);
		}

		System.out.println(ans);
	}
}
