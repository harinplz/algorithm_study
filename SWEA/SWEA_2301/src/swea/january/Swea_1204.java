package swea.january;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1204 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1;testCase<=T;testCase++) {
			sb.append("#"+testCase+" ");
			
			int caseNum = Integer.parseInt(in.readLine());
			
			int N = 1000;
			int[] scores = new int[N];
			
			String readLine = in.readLine();
			String[] split = readLine.split(" ");
			for(int i = 0;i<N;i++) {
				scores[i] = Integer.parseInt(split[i]);
			}
			
			//점수 별 카운팅
			int[] used = new int[101];
			for(int score:scores) {
				used[score]++;
			}
			
			int maxScore = 0;
			for (int i = 0;i<=100;i++) {
				if (used[i] >= used[maxScore]) {
					maxScore = i;
				}
			}
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
}
