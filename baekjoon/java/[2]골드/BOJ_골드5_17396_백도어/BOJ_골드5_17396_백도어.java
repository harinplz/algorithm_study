import java.io.*;
import java.util.*;

public class BOJ_골드5_17396_백도어 {
	
	public static class Node {
		int idx;
		long cost;
		
		public Node(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "idx: " + idx + " ,cost : " + cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수 
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		
		// 적 시야에서 보이는 곳인지 확인하기 
		boolean isPos[] = new boolean[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N-1; i++) { // N-1은 방문할 수 있으니까 
			int num = Integer.parseInt(st.nextToken());
			isPos[i] = num == 0 ? false : true;
		}
		
		// 인접 그래프 생성 
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		// 그래프 초기화 
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// M만큼 반복하여 그래프 정보 넣어주기 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(!isPos[b]) {
				graph.get(a).add(new Node(b, t));
			}
			if(!isPos[a]) {
				graph.get(b).add(new Node(a, t));
			}
			
			
		}
		
		// 거리 배열을 생성한다. 
		long dist[] = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		// N이 1일 때를 생각하면 ,,
		dist[0] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
		queue.offer(new Node(0, 0));
		
		// 다익스트라 진행하기 
		while(!queue.isEmpty()) {
			
			//System.out.println(queue);
			
			Node curNode = queue.poll();
			
			if(curNode.cost > dist[curNode.idx]) continue;
			
			// 인접한 노드 방문하기 
			for(int i=0; i<graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				if(dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
					dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
					queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
		
		if(dist[N-1] == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(dist[N-1]);
		
		System.out.println(Integer.MAX_VALUE);
		
	}


}
