import java.io.*;
import java.util.*;

public class BOJ_실버4_1120_문자열 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int diff = B.length() - A.length();
		int aLen = A.length();
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=diff; i++) {
			int cnt = 0;
			for(int j=0; j<aLen; j++) {
				if(A.charAt(j) != B.charAt(i+j)) {
					cnt++;
				}
			}
			if(cnt < min) min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	
	}
	
	
		
}
