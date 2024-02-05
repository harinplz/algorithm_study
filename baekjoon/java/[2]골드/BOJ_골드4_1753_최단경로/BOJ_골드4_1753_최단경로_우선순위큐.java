import java.io.*;
import java.util.*;

public class BOJ_골드4_1753_최단경로_우선순위큐 {
	
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
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(curNode.cost > dist[curNode.idx]) continue;
			
			for(int i=0; i<graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				
				if(dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
					dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
					queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF" + "\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	}


}
