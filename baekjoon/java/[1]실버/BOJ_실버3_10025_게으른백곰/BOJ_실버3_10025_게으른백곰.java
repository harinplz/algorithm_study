import java.io.*;
import java.util.*;

public class BOJ_실버3_10025_게으른백곰 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[1000001];
		int g, x;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			g = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			arr[x] = g;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		
		//초기값 
		for(int i=0; i < 2*K + 1 && i <= 1000000; i++) {
			sum += arr[i]; 
		}
		
		int max = sum;
		
		// 슬라이딩 윈도우 
		for(int i = 2*K + 1, j=0; i<=1000000; i++, j++) {
			sum -= arr[j];
			sum += arr[i];
			if(sum > max) max = sum;
		}
		
		System.out.println(max);
	}
	
		
}
