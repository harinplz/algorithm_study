import java.io.*;
import java.util.*;

public class BOJ_골드3_9466_텀프로젝트 {
	
	static int n;
	static int arr[];
	static boolean visited[];
	static boolean teamComplete[];
	static int ans;

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		while(T-->0) {
			n = Integer.parseInt(in.readLine());
			arr = new int[n+1];
			
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n+1];
			teamComplete = new boolean[n+1];
			
			
			ans = 0;
			for(int i=1; i<=n; i++) {
				if(teamComplete[i]) continue;
				DFS(i);
			}
			sb.append(n - ans + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void DFS(int idx) {
		if(teamComplete[idx]) return; // 이전에 이미 검사했다는 뜻이므로 더 이상 들어갈 필요가 없다. 
		if(visited[idx]) { // 방문을 했었다는 것은 사이클 구성원이라는 뜻이다.
			teamComplete[idx] = true; // 다시 방문하지 않아도 되니까 true 
			ans++; // 사이클 구성원이므로 +1 
		}
		
		visited[idx] = true;
		DFS(arr[idx]);
		// return 해서 돌아오는 곳 
		teamComplete[idx] = true;
		visited[idx] = false;
	}

}
