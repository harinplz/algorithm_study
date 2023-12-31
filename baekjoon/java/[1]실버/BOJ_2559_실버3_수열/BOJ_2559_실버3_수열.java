import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=N-K; i++) {
			int sum = 0;
			for(int j=i; j<i+K; j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
			
		}
		
		System.out.println(max);
	}
	
}
