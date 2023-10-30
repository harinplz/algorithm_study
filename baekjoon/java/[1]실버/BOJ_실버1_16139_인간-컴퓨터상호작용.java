import java.io.*;
import java.util.*;

public class BOJ_실버1_16139_인간-컴퓨터상호작용 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * 풀이 시간 : 18분 35초 
		 * 구분 : 누적합 
		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 0. 시간 절약을 위해 합쳐서 출력 
		StringBuilder sb = new StringBuilder();
		
		// 1. 문자열 입력 받기 
		String str = in.readLine();
		
		// 2. 질문 개수 입력 받기 
		int q = Integer.parseInt(in.readLine());
		
		// 3. a부터 z까지 구간마다 몇 개의 문자가 있는 지 배열에 저장하기 
		int[][] countAlpha = new int[26][str.length() + 1];
		
		// a부터 z까지 반복문 
		for(char alpha = 'a'; alpha <= 'z'; alpha++) {
			int val = 0;
			for(int i=0; i<str.length(); i++) {
				char stringAlpha = str.charAt(i);
				if(stringAlpha == alpha) { // 같은 값이 있다면 val값 증가 
					val++;
				}
				countAlpha[(int)alpha-97][i+1] = val;
			}
		}
				
		StringTokenizer st;
		// 4. q만큼 반복하여 질문 입력 받기 
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			char targetAlpha = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sb.append(countAlpha[(int)targetAlpha - 97][r+1] - countAlpha[(int)targetAlpha - 97][l]).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
