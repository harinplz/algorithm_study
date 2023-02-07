package ssafy.com.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버3_15649_N과M1 {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
		System.out.println(sb);
		
	}

	/**
	 * 순열을 구하기 위한 재귀함수 생성(완전 탐색)
	 * @param cnt
	 */
	private static void permutation(int cnt) {
		//기저 부분
		if(cnt == M) { //cnt가 M, 순열 수를 다 골랐을 때 끝낸다.
			for(int num: numbers) {
				sb.append(num).append(" ");
			}
			sb.append("\n"); //출력을 위한 부분
			return;
		}
		
		//유도 부분
		for(int i = 1 ; i<=N;i++) {//1부터 N까지 수 확인
			if(isSelected[i] == true) continue; 
			//만약 과거에 이 수를 골랐더라면 이 수를 다시 고를 수 없으므로 continue;
			
			numbers[cnt] = i; //순열에 추가
			isSelected[i] = true; //수를 골랐으니 isSelected true 처리
			
			permutation(cnt+1); //다음 순서의 숫자를 뽑으러감.
			isSelected[i] = false; //다음 순서를 다 끝내고 리턴되었을 때, 다시 수를 고르므로 false 처리 해준다.
		}
	}

}
