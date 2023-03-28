package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_브론즈2_2577_숫자의개수 {
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int mul = 1;
		int used[] = new int[10]; 
		
		for(int i=0; i<3; i++) {
			mul *= Integer.parseInt(in.readLine());
		}
		
		String str = String.valueOf(mul);
		
		for(int i=0; i< str.length(); i++) {
			int num = str.charAt(i) - '0';
			used[num]++;
		}
		
		for(int i=0; i<10; i++) {
			sb.append(used[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
}
