import java.io.*;
import java.util.*;

public class BOJ_골드5_12919_A와B2 {
	
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String S = in.readLine();
		String T = in.readLine();
		
		DFS(S, T);
		
		System.out.println(ans);
	}
	
	static void DFS(String s, String t) {
		if(t.length() == s.length()) {
			if(s.equals(t)) ans = 1;
			return; 
		}
		
		// 1번 연산 T에서 A삭제 
		if(t.charAt(t.length()-1) == 'A') {
			String one = t.substring(0, t.length()-1);
			DFS(s, one);
		}
		
		// 2번 연산 T 맨앞 B 삭제하고 뒤집기 
		if(t.charAt(0) == 'B') {
			String str = t.substring(1);
			String two = "";
			for(int i=str.length() - 1; i>=0; i--) {
				two += str.charAt(i);
			}
			DFS(s, two);
		}
	}
	
}
