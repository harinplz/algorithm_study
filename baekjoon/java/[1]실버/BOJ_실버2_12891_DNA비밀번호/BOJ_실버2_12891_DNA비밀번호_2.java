package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_12891_DNA비밀번호_2 {
	
	/**
	 * 24분
	 * 메모리 22000KB 시간 304ms
	 * 저번에 풀었었던 문제라 그런지 어려움 없이 풀 수 있었음!!
	 */
	
	static int S, P;
	
	static char[] dna;
	
	static int aLimit, cLimit, gLimit, tLimit;
	static int aCnt, cCnt, gCnt, tCnt;
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		StringTokenizer st = new StringTokenizer(in.readLine());
		S = Integer.parseInt(st.nextToken()); //임의로 만든 DNA 문자열 길이
		P = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분 문자열 길이
		
		String str = in.readLine();
		dna = new char[S+1];
		for(int i=0; i<S; i++) {
			dna[i+1] = str.charAt(i);
		}
		
		st = new StringTokenizer(in.readLine());
		
		aLimit = Integer.parseInt(st.nextToken());
		cLimit = Integer.parseInt(st.nextToken());
		gLimit = Integer.parseInt(st.nextToken());
		tLimit = Integer.parseInt(st.nextToken());
		
		// 문자열 탐색
		aCnt = 0;
		cCnt = 0;
		gCnt = 0;
		tCnt = 0;
		
		ans = 0;
		
		// 1. 처음 부분 문자열 개수 세기
		for(int i=1; i<=P; i++) {
			char dnaCh = dna[i];
			dnaCntpl(dnaCh);
		}
		
		if(check()) ans++;
		
		// 2. 나머지 부분 DNA 문자 개수 계산 
		int outIdx = 0;
		
		while(true) {
			outIdx = outIdx + 1;
			int lastIdx = outIdx + P;
			
			if(lastIdx > S) break; //마지막 인덱스가 S를 넘어서면 범위 초과. break
			
			char firstDna = dna[outIdx];
			dnaCntmi(firstDna);
			
			char lastDna = dna[lastIdx];
			dnaCntpl(lastDna);
			
			if(check()) ans++;	
		}
		System.out.println(ans);
	}
	
	// DNA 문자열 규칙 지키는 지 체크
	private static boolean check() {
		if(aCnt >= aLimit && cCnt >= cLimit && gCnt >= gLimit && tCnt >= tLimit) return true;
		return false;
	}

	// DNA 문자열의 문자 개수 세는 함수
	private static void dnaCntpl(char dnaCh) {
		switch(dnaCh) {
		case 'A':
			aCnt++;
			break;
		case 'C':
			cCnt++;
			break;
		case 'G':
			gCnt++;
			break;
		case 'T':
			tCnt++;
			break;
		}
		
	}
	
	// DNA 문자열의 문자 개수 감소 함수
	private static void dnaCntmi(char dnaCh) {
		switch(dnaCh) {
		case 'A':
			aCnt--;
			break;
		case 'C':
			cCnt--;
			break;
		case 'G':
			gCnt--;
			break;
		case 'T':
			tCnt--;
			break;
		}
	}
}
