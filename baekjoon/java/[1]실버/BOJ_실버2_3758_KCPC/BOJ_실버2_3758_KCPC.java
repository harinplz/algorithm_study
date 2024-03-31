import java.io.*;
import java.util.*;

public class BOJ_실버2_3758_KCPC {
	
	static class Team implements Comparable<Team>{
		int idx;
		int total;
		int cnt;
		int lastTime;
		
		public Team(int idx, int total, int cnt, int lastTime) {
			this.idx = idx;
			this.total = total;
			this.cnt = cnt;
			this.lastTime = lastTime;
		}
		
		@Override
		public int compareTo(Team o) {
			if(this.total == o.total) {
				if(this.cnt == o.cnt) {
					return this.lastTime - o.lastTime;
				}
				else return this.cnt - o.cnt;
			}
			else return o.total - this.total;
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n, k, myteamId, m;
		
		int scores[][];
		int solveCnt[];
		int lastTime[];
		while(T-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			myteamId = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			scores = new int[n+1][k+1];
			solveCnt = new int[n+1];
			lastTime = new int[n+1];
			
			// 점수 입력 
			for(int l = 1; l <= m; l++) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				if(scores[i][j] < s) scores[i][j] = s;
				solveCnt[i]++;
				lastTime[i] = l;
			}
			
			List<Team> list = new ArrayList<>();
			// 나의 팀 순위 구하기 
			for(int i=1; i<=n; i++) {
				int total = 0;
				for(int j=1; j<=k; j++) {
					total += scores[i][j];
				}
				
				list.add(new Team(i, total, solveCnt[i], lastTime[i]));
			}
			
			Collections.sort(list);
			
			for(int i=0; i<n; i++) {
				if(list.get(i).idx == myteamId) {
					sb.append((i+1) + "\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
	
}
