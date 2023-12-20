import java.io.*;
import java.util.*;

public class BOJ_실버3_9996_한국이그리울땐서버에접속하지 {
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); 
		
		String pattern = in.readLine();

    // *의 앞 뒤로 어떤 문자열이 오는 지 저장 
		String startStr = "";
		String endStr = "";
		
		boolean flag = false;
		for(int i=0; i<pattern.length(); i++) {
			if(!flag && pattern.charAt(i) != '*') {
				startStr += pattern.charAt(i);
			}
			else if(!flag && pattern.charAt(i) == '*') {
				flag = true;
			}
			else if(flag && pattern.charAt(i) != '*') {
				endStr += pattern.charAt(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			boolean start = false;
			boolean end = false;
			String str = in.readLine();
			if(str.length() >= startStr.length() + endStr.length()) { // StringIdx 에러 주의 
				if(str.substring(0, startStr.length()).equals(startStr)) {
					start = true;
				}
				if(str.substring(str.length() - endStr.length(), str.length()).equals(endStr)) {
					end = true;
				}
			}

			
			if(start && end) sb.append("DA\n");
			else sb.append("NE\n");
		}
		
		System.out.println(sb);	
	}
}
