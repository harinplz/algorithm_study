package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버5_2018_수들의합5 {

	public static void main(String[] args) throws Exception {

		//해당 수 나타낼 수 있는 최대 길이 1부터 걔를 했는데 만약 걔가 N보다 크다면 종료!
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		//배열 만들기
		int nums[] = new int[N+1];

		for(int i=1; i<=N; i++) {
			nums[i] = nums[i-1] + i;
		}

		int startIdx, endIdx;
		int cnt = 0;

		for(startIdx = 1; startIdx<=N; startIdx++) {
			for(endIdx = startIdx; endIdx<=N; endIdx++) {
				int result = nums[endIdx] - nums[startIdx-1];
				if(result == N) cnt++;
				else if(result > N) break;
			}
		}

		System.out.println(cnt);

	}

}
