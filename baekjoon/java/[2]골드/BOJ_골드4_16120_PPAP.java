import java.io.*;
import java.util.*;

public class BOJ_골드4_16120_PPAP {
	
	/* 풀이 시간 : 오후 4시 45분 ~ 오후 5시 20분 (블참)
	 * 풀이 방법 : 스택 / 문자열 
	 * 메모리 : 24904KB, 시간 : 248ms 
	 */
	
	/*
	 * 문제를 이해를 못했다. PPAP 문자열이 그래서 어떤 거지 ... ? 하며 감을 못잡음 
	 * 다음에 다시 풀어보기 ⭐⭐⭐⭐⭐
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)=='P') {
				stack.push('P');
			}
			else if(str.charAt(i) == 'A') {
				if(stack.size() >= 2 && i+1 < str.length() &&  str.charAt(i+1) == 'P') {
					stack.pop();
					stack.pop();
				}
				else {
					System.out.println("NP");
					return;
				}
			}
			//System.out.println(i+1 + "번 째 스택: " + stack);
		}
		
		if(stack.size() == 1) System.out.println("PPAP");
		else System.out.println("NP");
		
		
	}
	
	

}
