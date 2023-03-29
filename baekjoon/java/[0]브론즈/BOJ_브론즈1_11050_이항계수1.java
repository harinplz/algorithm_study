package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_브론즈1_11050_이항계수1 {
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int min = N-K == 0? K : Math.min(K, N-K);
		int mul = 1;
		int kmul = 1;
		
		for(int i=0; i<min; i++) {
			mul *= (N-i);
			kmul *= (min-i);
		}
		
		int ans = mul / kmul;
		
		System.out.println(ans);
		
	}
	
}
