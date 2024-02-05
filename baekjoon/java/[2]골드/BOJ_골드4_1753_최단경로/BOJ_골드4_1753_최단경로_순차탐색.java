import java.io.*;
import java.util.*;

public class BOJ_골드4_1753_최단경로_순차탐색 {
	
	static class Node {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(in.readLine());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		// 그래프 초기화 
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		int dist[] = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 시작점 0으로 초기화 
		dist[start] = 0;
		
		boolean visited[] = new boolean[V+1];
		
		// 다익스트라 알고리즘 시작 
		for(int i=0; i<V; i++) {
			
			int nodeValue = Integer.MAX_VALUE;
			int nodeIdx = 0;
			
			// 1. 최소 비용을 가지는 노드 선택 
			for(int j=1; j<=V; j++) {
				if(!visited[j] && dist[nodeIdx] > dist[j]) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			
			// 2. 방문처리 
			visited[nodeIdx] = true;
			
			// 3. 인접한 노드 거리 갱신하기 
			for(int j=0; j<graph.get(nodeIdx).size(); j++) {
				Node adjNode = graph.get(nodeIdx).get(j);
				dist[adjNode.idx] = Math.min(dist[adjNode.idx], dist[nodeIdx] + adjNode.cost);
			}
			

		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	
	}

}
