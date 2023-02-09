package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_브론즈2_2798_블랙잭 {

	private static int N;
	private static int M;
	private static int ans;
	private static int min = Integer.MAX_VALUE;
	private static int[] cards;
	private static int[] numbers = new int[3];
	private static boolean[] isSelected;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String split[] = in.readLine().split(" ");

		//N,M 입력받음
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		//배열 크기 할당
		cards = new int[N];
		isSelected = new boolean[N];

		//cards에 수 할당
		String split2[] = in.readLine().split(" ");
		for(int i =0;i<N;i++) {
			cards[i] = Integer.parseInt(split2[i]);
		}

		blackjack(0, 0);
		System.out.println(ans);
	}

	private static void blackjack(int cnt, int start) {
		// 기저 부분
		if(cnt == 3) {
			int sum = 0; 
			for(int num: numbers) sum += num; 
			if(sum<=M && min > M-sum) { //조건 조심!!!
				min = M-sum; 
				ans = sum; 
			}
			return;
		}

		// 유도 부분
		for(int i = start;i<N;i++) {
			if(isSelected[i] == true) continue; //오타 조심!!!

			isSelected[i] = true;
			numbers[cnt] = cards[i];

			blackjack(cnt+1, i+1);

			isSelected[i] = false;
		}

	}

}
