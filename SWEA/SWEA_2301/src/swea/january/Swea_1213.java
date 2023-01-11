package swea.january;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1213 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1;testCase<=10;testCase++) {
			sb.append("#"+testCase+" ");
			
			int caseNum = Integer.parseInt(in.readLine());
			
			String search = in.readLine();
			String str = in.readLine();
			
			int cnt = 0;
			
			for(int i = 0;i<str.length()-search.length()+1;i++) {
				if (search.equals(str.substring(i, i+search.length()))) {
					//str.substring은 str의 문자열 인덱스 i자리에서 i+search.length()-1자리까지 자른다.
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
