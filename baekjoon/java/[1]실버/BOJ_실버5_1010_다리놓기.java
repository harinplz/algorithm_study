package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_실버5_1010_다리놓기 {
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			BigInteger N = new BigInteger(st.nextToken());
			int n = N.intValue();
			BigInteger M = new BigInteger(st.nextToken());
			int m = M.intValue();
			
			int min = m-n == 0 ? m : n;
			
			BigInteger mul = new BigInteger("1");
			BigInteger Nmul = new BigInteger("1");
			
			for(int i=0; i<min; i++) {
				String iStr = String.valueOf(i);
				BigInteger I = new BigInteger(iStr);
				mul = mul.multiply(M.subtract(I));
				Nmul = Nmul.multiply(N.subtract((I)));
				
			}
		
			
			sb.append(mul.divide(Nmul)).append('\n');
		}
		
		System.out.println(sb);
		
	}
}
