import java.io.*;
import java.util.*;

public class BOJ_골드4_1976_여행가자 {
	
	static int N,M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static boolean check;
	static int[] routes;
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		graph = new ArrayList[N+1];
		// 초기화 
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			graph[i].add(i);
			for(int j=1; j<=N; j++) {
				int next = Integer.parseInt(st.nextToken());
				if(next == 1) graph[i].add(j);
			}
		}
		
		// 경로 입력 
		st = new StringTokenizer(in.readLine());
		routes = new int[M];
		for(int i=0; i<M; i++) {
			routes[i] = Integer.parseInt(st.nextToken());
		}
		
		String ans = "YES";
		
		for(int i=0; i<M-1; i++) {
			int from = routes[i];
			int to = routes[i+1];
			
			check = false;
			visited = new boolean[N+1];
			
			DFS(from, to);
			
			if(!check) {
				ans = "NO";
				break;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void DFS(int start, int to) {
		
		for(int i=0; i<graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				visited[graph[start].get(i)] = true;
				if(to == graph[start].get(i)) {
					check = true;
					return;
				}
				DFS(graph[start].get(i), to);
			}
		}
	}

}
