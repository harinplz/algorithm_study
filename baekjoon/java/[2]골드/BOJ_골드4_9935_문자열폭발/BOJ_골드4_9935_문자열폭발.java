import java.io.*;
import java.util.*;

public class BOJ_골드4_9935_문자열폭발 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		String bomb = in.readLine();
		int strLen = str.length();
		int bombLen = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<strLen; i++) {
			int count = 0;
			stack.push(str.charAt(i));
			
			if(stack.size() >= bombLen) {
				for(int j=0; j<bombLen; j++) {
					if(stack.get(stack.size() - bombLen + j) == bomb.charAt(j)) count++;
					
					if(count == bombLen) {
						for(int k=0; k<bombLen; k++) {
							stack.pop();
						}
					}
				}
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			for(char ch : stack) {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);

	}

}
