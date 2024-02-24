import java.io.*;
import java.util.*;

public class BOJ_골드5_19598_최소회의실개수_2 {
	
	static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Time> meetings = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings.add(new Time(start, end));
		}
		
		// 정렬 
		Collections.sort(meetings);
		
		// 진행 중인 회의
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(meetings.get(0).end);
		
		for(int i=1; i<N; i++) {
			System.out.println(pq);
			if(pq.peek() <= meetings.get(i).start) {
				pq.poll();
			}
			pq.offer(meetings.get(i).end);
		}
		
		System.out.println(pq.size());
	}

}
