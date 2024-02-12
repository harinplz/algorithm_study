import java.io.*;
import java.util.*;

public class BOJ_실버5_2822_점수계산 {
	
	static class Score implements Comparable<Score> {
		int idx;
		int score;
		
		public Score(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(Main.Score o) {
			return o.score - this.score;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Score> list = new ArrayList<>();
		
		int idx[] = new int[5];
		
		for(int i=1; i<=8; i++) {
			int score = Integer.parseInt(in.readLine());
			list.add(new Score(i, score));
		}
		
		StringBuilder sb = new StringBuilder();
		int ans = 0;

		Collections.sort(list);
		
		for(int i=0; i<5; i++) {
			Score score = list.get(i);
			ans += score.score;
			idx[i] = score.idx;
		}
		
		Arrays.sort(idx);
		
		sb.append(ans + "\n");
		
		for(int i=0; i<5; i++) {
			sb.append(idx[i] + " ");
		}
		
		System.out.println(sb);
	}

}
