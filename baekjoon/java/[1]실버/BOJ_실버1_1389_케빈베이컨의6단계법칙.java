import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버1_1389_케빈베이컨의6단계법칙 {
  
  // 메모리 : 11732KB, 시간 : 84ms
	
	static int N; // 유저의 수 
	static int M; // 친구 관계의 수 
	
	static ArrayList<Integer>[] list; //인접 리스트 
	static int[][] relationCnt; 
	
	static boolean[] isVisited; //방문 배열 
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//인접리스트 초기화
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		relationCnt = new int[N+1][N+1];
		
		// 친구 관계 (간선) 입력 받기 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		
		for(int i=1; i<=N; i++) {
			isVisited = new boolean[N+1];
			bfs(i);
		}
		
		int ansVal = Integer.MAX_VALUE;
		int ans = -1; 
		
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				sum += relationCnt[i][j];
			}
			
			if(ansVal > sum) {
				ansVal = sum;
				ans = i;
			}
			
		}
		
		System.out.println(ans);
	}

	private static void bfs(int vertex) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(vertex);
		isVisited[vertex] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			cnt++;
			while(size-- > 0) {
				int v = queue.poll();
				
				for(int nextV : list[v]) {
					if(!isVisited[nextV]) {
						queue.offer(nextV);
						isVisited[nextV] = true;
						relationCnt[vertex][nextV] = cnt;
					}
				}
				if(!isVisited[v]) {
					queue.offer(v);
					isVisited[v] = true;
					relationCnt[vertex][v] = cnt;
				}
			}
		}
		
	}

}
