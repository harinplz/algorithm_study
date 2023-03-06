package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_브론즈2_11720_숫자의합 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += str.charAt(i) - '0';
		}
		
		System.out.println(sum);
		
	}
	
}
