import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버2_1260_DFS와BFS {
	
	static int N;
	static int M;
	static int V;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] list;
	
	//DFS 방문 배열 
	static boolean isVisitedD[];
	//BFS 방문 배열
	static boolean isVisitedB[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		//인접 리스트 초기화
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 값 넣기
		while(M-->0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// 값 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		isVisitedD = new boolean [N+1];
		dfs(V);
		sb.append('\n');
		
		isVisitedB = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(v);
		isVisitedB[v] = true;
		
		while(!queue.isEmpty()) {
			int curV = queue.poll();
			sb.append(curV).append(' ');
			
			for(int vertex : list[curV]) {
				if(!isVisitedB[vertex]) {
					queue.offer(vertex);
					isVisitedB[vertex] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		sb.append(v).append(' ');
		isVisitedD[v] = true;
		
		for(int vertex : list[v]) {
			if(!isVisitedD[vertex]) {
				dfs(vertex);
			}
		}
	}
}
