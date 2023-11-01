import java.io.*;
import java.util.*;

public class BOJ_실버3_15652_N과M4 {
	
	static int N, M;
	static int numbers[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 풀이시간 23분 55초 
		 * 종류 : 중복 조합 / 백트래킹
		 */

		// 0. 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M+1]; // 중복 조합 수 저장 배열 
	
		// 중복 조합 시작 (재귀문) 
		combi(0, 1);
		
		System.out.println(sb);
	}

  // cnt는 지금까지 배열에 저장한 수의 개수, start는 원래 숫자를 뽑을 배열의 시작 인덱스를 뜻하나, 여기에서는 배열을 따로 만들 필요는 없어서 제일 처음 숫자라고 생각하면 된다!
	public static void combi(int cnt, int start) {
		// 종료 조건
		if(cnt==M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// 진행 조건 
		for(int i = start ; i<=N; i++) {
			numbers[cnt] = i; 
			combi(cnt + 1, i); // 조합이라면 다음 수를 뽑아야 해서 +1 해줘야했지만, 중복 조합이라 같은 수를 뽑아도 되기 때문에 i를 매개변수로 보내준다. 
		}
	}

}
