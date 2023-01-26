package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2501 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//수 입력
		String[] input = new String[2];
		input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
	
		//문제 풀이 위한 변수 선언
		int cnt = 0;
		int result = 0;
		
		//알고리즘
		for(int i = 1;i<=N;i++) {
			if(N%i==0) {
				cnt++;
			}
			if(cnt == K) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
		
	}

}
