import java.io.*;
import java.util.*;

public class BOJ_브론즈4_10808_알파벳개수 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		int[] alpha = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			alpha[ch - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : alpha) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
	}

}
