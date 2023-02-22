package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와SpotMart {

	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer
	st;
	private static int[] snacks;
	private static int[] numbers;
	private static int N;
	private static int M;
	private static int max;
	private static boolean isFinish;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for(int tc = 1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			isFinish = false;

			st = new StringTokenizer(in.readLine());
			snacks = new int[N];
			numbers = new int[2];

			for(int i = 0;i<N;i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			} //과자 무게 입력

			combination(0, 0);

			if(isFinish) sb.append(max).append("\n");
			else sb.append(-1).append("\n");
		}

		System.out.println(sb);
	}

	private static void combination(int start, int cnt) {

		if(cnt == 2) {
			int sum = 0;
			for(int snack : numbers) {
				sum += snack;
			}
			if(sum > max && sum <= M) {
				max = sum;
				isFinish = true;
			}
			return;
		}

		for(int i = start; i<N;i++) {
			numbers[cnt] = snacks[i];
			combination(i+1, cnt+1);

		}

	}


}
