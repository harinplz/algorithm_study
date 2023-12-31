import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		st = new StringTokenizer(in.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] += arr[i-1];
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=K; i<=N; i++) {
			max = Math.max(max, arr[i] - arr[i-K]);
		}
		
		System.out.println(max);
	}
	
}
