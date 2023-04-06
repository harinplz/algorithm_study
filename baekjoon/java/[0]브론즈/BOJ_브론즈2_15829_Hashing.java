package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_브론즈2_15829_Hashing {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		long hash = 0;
		long mul = 1;
		int mod = 1234567891;
		
		for(int i=0; i<N; i++) {
			int alpha = str.charAt(i) - 'a' + 1;
			hash += alpha * mul;
			
			mul = (mul * 31) % mod;
		}
		
		System.out.println(hash % mod);
	}

}