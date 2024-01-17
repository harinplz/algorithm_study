import java.io.*;
import java.util.*;

public class BOJ_실버5_1316_그룹단어체커 {
	
	/*
	 * 풀이 시간 : 6분 21초 
	 * 풀이 방법 : 문자열 / 자료구조 
	 * 메모리 : 11608KB, 시간 : 80ms 
	 */
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0; // 그룹 단어 개수 저장 변수 
		
		int N = Integer.parseInt(in.readLine());
		while(N-->0) {
			String str = in.readLine();
			
			boolean flag = true;
			Set<Character> set = new HashSet<>();
			
			set.add(str.charAt(0));
			for(int i=1; i<str.length(); i++) {
				if(str.charAt(i-1) != str.charAt(i) && set.contains(str.charAt(i))) {
					flag = false;
					break;
				}
				else set.add(str.charAt(i));
			}
			
			
			if(flag) ans++;
		}
		
		System.out.println(ans);
	}
		
}
