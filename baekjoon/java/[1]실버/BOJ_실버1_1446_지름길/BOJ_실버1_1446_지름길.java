import java.io.*;
import java.util.*;

public class BOJ_실버1_1446_지름길 {
	
	static class shortCut implements Comparable<shortCut> {
		int start;
		int end;
		int dist;
		
		public shortCut(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "start: " + start + " end: " + end + " dist: " + dist;
		}

		@Override
		public int compareTo(shortCut o) {
			if(this.start < o.start) return -1;
			return 1;
		}

	
	}
	
	static int N, D;
	static shortCut[] arr;
	static shortCut[] com;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new shortCut[N];
		ans = D;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			arr[i] = new shortCut(start, end, dist);
		}
		
		Arrays.sort(arr);
		
		for(int i=1; i<=N; i++) {
			com = new shortCut[i];
			combi(0, 0, i);
		}
		
		System.out.println(ans);

	}
	
	public static void combi(int cnt, int start, int n) {
		if(cnt == n) {
			for(int i=0; i<n; i++) {
				if(i != 0 && com[i].start < com[i-1].end) return; // 구간이 겹치는 지 확인 
				if(com[i].end > D || com[i].start > D) return; // end가 D보다 큰 지 확인 
			}

			int dist = D;
			for(shortCut sc : com) {
				dist -= (sc.end - sc.start);
				dist += sc.dist;
			}
			
			ans = Math.min(dist, ans);
			return;
		}
		
		for(int i = start; i<N; i++) {
			com[cnt] = arr[i];
			combi(cnt+1, i+1, n);
		}
	}


}
