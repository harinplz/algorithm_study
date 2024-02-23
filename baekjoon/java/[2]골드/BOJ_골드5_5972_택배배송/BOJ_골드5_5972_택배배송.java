import java.io.*;
import java.util.*;

public class BOJ_골드5_5972_택배배송 {
	
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
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, w));
			graph.get(b).add(new Node(a, w));
		}
		
		int dist[] = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		queue.offer(new Node(1, 0));
		dist[1] = 0;
		
		while(!queue.isEmpty()) {
			System.out.println(queue);
			Node curNode = queue.poll();
			
			if(dist[curNode.idx] < curNode.cost) continue;
			
			for(int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				
				if(dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
					dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
					queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
		
		System.out.println(dist[V]);
		
		
	}

}
