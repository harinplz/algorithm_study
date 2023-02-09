package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_12891_DNA비밀번호 {
	
	private static int cntA = 0;
	private static int cntC = 0;
	private static int cntG = 0;
	private static int cntT = 0;
	//문제에서 주어진 A, C, G, T의 최소 개수와 비교하기 위해서 사용할 변수
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int P = Integer.parseInt(st.nextToken()); //P(민호가 임의로 만든 DNA 문자열 길이)
		int S = Integer.parseInt(st.nextToken()); //S(비밀번호로 사용할 부분 문자열 길이)
		
		String DNAstr = in.readLine(); //민호가 임의로 만든 DNA 문자열 입력
		
		st = new StringTokenizer(in.readLine());
		int [] DNALimit = new int[4];
		for(int i = 0;i<4;i++) {
			DNALimit[i] = Integer.parseInt(st.nextToken()); //A, C, G, T가 비밀번호에 들어가야할 최소 개수 저장
		}

		int ans = 0; //민호가 만들 수 있는 비밀번호 종류 수 저장 변수
		
		//슬라이딩 윈도우 사용
		//S 크기 만큼의 윈도우를 만들어서 민호가 임의로 만든 DNA 문자열을 확인.

		for(int i=0;i<=P-S;i++) {
			if(i == 0) { //처음 윈도우를 시작할 때, 하나씩 원소를 보면서 A, C, G, T 개수 체크.
				String subDNAstr = DNAstr.substring(i, i+S);
				for(int j=0;j<subDNAstr.length();j++) {
					char target = subDNAstr.charAt(j);
					SumCntDna(target); //원소가 'target'이면 해당 target 카운트 증가시킴.
				}
			}
			else {//윈도우를 옮길 때 
				char subTarget = DNAstr.charAt(i-1); //뺄 요소 선택 (윈도우에서 빠진 요소)
				char target = DNAstr.charAt(i+S-1); //더할 요소 선택 (새로 추가된 요소)
				
				SubCntDna(subTarget); //윈도우에서 빠진 요소는 카운트 값을 -- 해준다.
				SumCntDna(target); //윈도우에 새로 들어온 요소는 카운트 값을 ++ 해준다.
				
			}
			
			/**
			 * A, C, G, T 의 개수를 각각 카운팅하는데,
			 * 만약 A, C, G, T의 수가 전부 제한된 최소 개수보다 크거나 같다면? 비밀번호 종류 수 증가시킴.
			 */
			if(cntA >= DNALimit[0] && cntC >= DNALimit[1] &&
					cntG >= DNALimit[2] && cntT >= DNALimit[3] ) {
				ans+=1;
			}
		}
		
		System.out.println(ans);
	}
	
	//카운트 값 --해주는 함수
	public static void SubCntDna(char target) {
		switch(target) {
		case 'A':
			cntA-=1;
			break;
		case 'C':
			cntC-=1;
			break;
		case 'G':
			cntG-=1;
			break;
		case 'T':
			cntT-=1;
		}
	}
	
	//카운트 값 ++해주는 함수
	public static void SumCntDna(char target) {
		switch(target) {
		case 'A':
			cntA+=1;
			break;
		case 'C':
			cntC+=1;
			break;
		case 'G':
			cntG+=1;
			break;
		case 'T':
			cntT+=1;
		}
	}
	
}
