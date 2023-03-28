package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_실버3_1463_1로만들기 {
	
	/**
	 * DP
	 * 메모리 : 18224KB 시간 : 148ms
	 * 예전엔 진짜 감이 하나도 안 잡혔는데 하나도 참고 안하고 문제를 풀었다는 것에 의의를..!!!
	 */

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		//동적 테이블 생성
		int D[] = new int[N+1];

		D[1] = 0;

		for(int i = 2; i<=N; i++) {
			int min = Integer.MAX_VALUE;

			if(i%3 == 0) {
				min = Math.min(min, D[i/3]);
			} 
			if(i%2 == 0) {
				min = Math.min(min, D[i/2]);
			} 
			min = Math.min(min, D[i-1]);

			D[i] = min + 1;
		}

		System.out.println(D[N]);

	}

}
