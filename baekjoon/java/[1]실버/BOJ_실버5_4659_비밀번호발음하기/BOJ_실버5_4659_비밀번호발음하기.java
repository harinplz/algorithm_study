import java.io.*;
import java.util.*;

public class BOJ_실버5_4659_비밀번호발음하기 {
	
	public static void main(String[] args) throws Exception { 
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Character> moeum = new ArrayList<>();
		ArrayList<Character> jaeum = new ArrayList<>();
		
		for(int i=99; i<=122; i++) {
			char ch = (char)i;
			if(isMoeum(ch)) moeum.add(ch);
			else jaeum.add(ch);
		}
		
		while(true) {
			String str = in.readLine();
			if(str.equals("end")) break;
			
			boolean flag = true;
			boolean isMoeum = false;
			int moeumCnt = 0;
			int jaeumCnt = 0;
			
			for(int i=0; i<str.length(); i++) { 
				char ch = str.charAt(i);
				
				// 1번 조건
				if(isMoeum(ch) && !isMoeum) isMoeum = true;
				
				// 2번 조건 
				/*
				 * 지금 자음일 때, 이전도 자음이다.
				 * 지금 자음일 때 , 이전은 모음이다. 
				 * 지금 모음일 때, 이전은 모음이다.
				 * 지금 모음일 때,이전은 자음이다. 
				 */
				
				if(i == 0) {
					if(isMoeum(ch)) moeumCnt++;
					else jaeumCnt++;
					continue;
				}
				
				
				char prevCh = str.charAt(i-1);
				if(!isMoeum(ch) && !isMoeum(prevCh)) {
					jaeumCnt++;
				}
				else if(!isMoeum(ch) && isMoeum(prevCh)) {
					moeumCnt = 0;
					jaeumCnt++;
				}
				else if(isMoeum(ch) && isMoeum(prevCh)) {
					 moeumCnt++;
				}
				else if(isMoeum(ch) && !isMoeum(prevCh) ) {
					jaeumCnt = 0;
					moeumCnt++;
				}
								
				if(jaeumCnt == 3 || moeumCnt == 3) {
					flag = false;
					break;
				}
				
				// 3번 조건 
				if(ch == prevCh && (ch != 'o' && ch != 'e')) {
					flag = false;
					break;
				}
			}
			
			if(!isMoeum) flag = false;
			
			if(flag) {
				sb.append("<"+str+"> is acceptable.\n");
			}
			else {
				sb.append("<"+str+"> is not acceptable.\n");
			}
			
		}
		

		
		System.out.println(sb);
	}
	
	public static boolean isMoeum(char ch) {
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}


}
