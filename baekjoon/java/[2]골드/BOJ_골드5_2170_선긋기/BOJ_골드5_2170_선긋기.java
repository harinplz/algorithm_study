import java.io.*;
import java.util.*;

public class BOJ_골드5_2170_선긋기 {
	
	static class Line implements Comparable<Line>{
		int start;
		int end;
		
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}		
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Line> queue = new PriorityQueue<>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			queue.offer(new Line(start, end));
		}
		
		// 선 긋기 
		// 시작하는 위치 저장 큐와 끝나는 위치 저장하는 큐 생성 (내림차순 저장)
		PriorityQueue<Integer> startQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		PriorityQueue<Integer> endQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

		Line firstLine = queue.poll();
		startQ.add(firstLine.start);
		endQ.add(firstLine.end);
		
		while(!queue.isEmpty()) {
			Line curLine = queue.poll();
			
			int end = endQ.peek();
			int newStart = curLine.start;
			int newEnd = curLine.end;
			
			if(newStart <= end) {
				// start 갱신은 안하고 end 갱신을 해야한다. 
				if(newEnd > end) {
					endQ.poll();
					endQ.add(newEnd);
				}
			}
			else {
				startQ.add(newStart);
				endQ.add(newEnd);
			}
		}
		
		int size = startQ.size();
		
		int total = 0;
		while(size-->0) {
			int start = startQ.poll();
			int end = endQ.poll();
			total += (end - start);
		}

		System.out.println(total);
	}
	
}
