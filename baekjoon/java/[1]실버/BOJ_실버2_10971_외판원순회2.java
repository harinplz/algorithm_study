package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버2_10971_외판원순회2 {

	static int N;
	static int W[][];

	static boolean isSelected[];
	static int num[];

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		W = new int[N][N];

		isSelected = new boolean[N];
		num = new int[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0);

		System.out.println(min);

	}

	private static void permutation(int cnt) {
		if(cnt == N) {
			int sum = 0;
			boolean check = true;
			for(int i=0; i<N; i++) {
				if(W[num[i]][num[(i+1)%N]] == 0) {
					check = false;
					break;
				}
				sum += W[num[i]][num[(i+1)%N]];
			}
			if(check) min = Math.min(min, sum);
			return;
		}

		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;

			num[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;

		}

	}	

}

