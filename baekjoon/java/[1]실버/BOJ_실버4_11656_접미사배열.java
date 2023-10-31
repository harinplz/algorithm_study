import java.io.*;
import java.util.*;

public class BOJ_실버4_11656_접미사배열 {
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 풀이 시간 : 5분 36초 
		 * 종류 : 문자열 
		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 문자열 입력 받음 
		String str = in.readLine();
		int strLen = str.length();
		
		// 정렬할 문자열 배열 선언 
		String[] strArr = new String[strLen];
		
		// 앞을 자르며 문자열 배열에 넣어주기 
		for(int i=0; i<strLen; i++) {
			strArr[i] = str;
			str = str.substring(1);
		}
		
		// 정렬 
		Arrays.sort(strArr);
		
		// 출력 
		for(String sortedStr : strArr) {
			sb.append(sortedStr).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
