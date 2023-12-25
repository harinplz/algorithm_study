import java.io.*;
import java.util.*;

public class BOJ_실버2_2644_촌수계산 {

  /*
   * 풀이 방법 : DFS 
   */
	
	static ArrayList<Integer>[] list;
	static boolean visited[];
	static int dis[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		visited = new boolean[n+1];
		dis = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int target1 = Integer.parseInt(st.nextToken());
		int target2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(in.readLine());
		
		list = new ArrayList[n+1];
		
		// 초기화 
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		while(m-->0) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		//DFS()
		visited[target1] = true;
		DFS(target1, 0);
		
		int ans = dis[target2] == 0 ? -1 : dis[target2];
		System.out.println(ans);
	}
	
	static public void DFS(int start, int cnt) {
		
		for(int num : list[start]) {
			if(!visited[num]) {
				visited[num] = true;
				dis[num] = cnt+1;
				DFS(num, cnt+1);
			}
		}
	}

}
