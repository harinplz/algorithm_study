import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버2_11724_연결요소의개수 {
	
	/*
	 * 메모리 144464KB 시간 624ms
	 * ArrayList 배열로 인접 리스트를 생성하고 DFS 방식으로 그래프 정점을 방문.
	 * 인접 리스트 만드는 거 Node 클래스를 통해 하는 방법도 공부해야겠다 !! 
	 */
	
	static int N, M; //정점의 개수 N 간선의 개수 M
	static ArrayList<Integer>[] graph;
	
	static boolean[] isVisited;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		
		//초기화
		for(int i=1; i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		//정점 정보 넣어주기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			if(isVisited[i]) continue;
			dfs(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int vertex) {
		isVisited[vertex] = true;
		
		for(int i=0; i<graph[vertex].size(); i++) {
			int v = graph[vertex].get(i);
			if(!isVisited[v]) {
				dfs(v);
			}
		}
		
	}

}
