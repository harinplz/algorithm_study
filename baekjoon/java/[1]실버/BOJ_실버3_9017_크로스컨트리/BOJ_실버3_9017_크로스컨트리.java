import java.io.*;
import java.util.*;

public class BOJ_실버3_9017_크로스컨트리 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(T-->0) {
			int N = Integer.parseInt(in.readLine());
			int rank[] = new int[N];
			HashMap<Integer, Integer> map = new HashMap<>();
			st = new StringTokenizer(in.readLine());
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
				map.put(rank[i], map.getOrDefault(rank[i], 0) + 1);
				max = Math.max(max, rank[i]);
			}
			
			// 점수 부여
			int scores[] = new int[N];
			int score = 1;
			for(int i=0; i<N; i++) {
				if(map.get(rank[i]) < 6) continue;
				scores[i] = score++;
			}
			
			// 다섯 번째 들어온 애 구하기 
			int fifth[] = new int[max+1];
			
			for(int key : map.keySet()) {
				if(map.get(key) < 6) {
					fifth[key] = Integer.MAX_VALUE;
					continue;
				}
				int idx = 0;
				for(int i = 0; i< N ; i++) {
					if(rank[i] == key) idx++;
					if(idx == 5) {
						fifth[key] = (i+1);
						break;
					}
				}
			}
			
			// 점수 최소 합 구하기 
			int minScore = Integer.MAX_VALUE;
			int minTeam = 0;
			
			for(int key : map.keySet()) {
				if(map.get(key) < 6) continue;
				
				int sum = 0;
				int idx = 1;
				for(int i=0; i<N; i++) {
					if(rank[i] == key && idx <= 4) {
						sum += scores[i];
						idx++;
					}
				}
				
				if(sum < minScore) {
					minScore = sum;
					minTeam = key;
				}
				else if(sum == minScore) {
					if(fifth[key] < fifth[minTeam]) {
						minScore = sum;
						minTeam = key;
					}
				}
			}
			
			sb.append(minTeam + "\n");

		}
		System.out.println(sb);
	}
	
}
