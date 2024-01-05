import java.io.*;
import java.util.*;

public class BOJ_골드4_17218_비밀번호만들기 {
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 공통으로 존재하는 가장 긴 부분 문자열 길이를 구하는 식 ... 
		
		String str1 = in.readLine();
		String str2 = in.readLine();
		
		String LCS[][] = new String[str1.length()+1][str2.length()+1];
		
		for(int i=0; i <= str1.length(); i++) {
			for(int j=0; j <= str2.length(); j++) {
				LCS[i][j] = "";
			}
		}
		
		String ans = "";
		
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1] + str1.charAt(i-1);
				}
				else {
					if(LCS[i-1][j].length() > LCS[i][j-1].length()) {
						LCS[i][j] = LCS[i-1][j];
					}
					else {
						LCS[i][j] = LCS[i][j-1];
					}
				}
			}
		}
		
		System.out.println(LCS[str1.length()][str2.length()]);
	}
}
