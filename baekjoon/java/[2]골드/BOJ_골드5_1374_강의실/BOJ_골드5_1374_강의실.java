import java.io.*;
import java.util.*;

public class BOJ_골드5_1374_강의실 {
	
	// Lecture 클래스 생성 
	static class Lecture implements Comparable<Lecture> {
		int idx;
		int start;
		int end;
		
		public Lecture(int idx, int start, int end) {
			this.idx = idx;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); 
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 강의의 개수 N 입력 
		int N = Integer.parseInt(in.readLine());
		
		// N을 반복하여 강의 입력 (빼열 생성) 
		List<Lecture> lectures = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lectures.add(new Lecture(idx, start, end));
		}
	
		// 시작하는 시간, 종료하는 시간 오름차순으로 정렬 
		Collections.sort(lectures);
		
		// 강의 끝나는 시간을 저장하는 우선 순위 생성
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
		
		// 배열을 돌면서 우선 순위 큐를 활용하여 강의 진행 
		// 만약 우선 순위 큐 제일 앞에 있는 끝나는 시간보다 이후인 시작하는 시간이 나온다면? 
		// 그 시간을 poll 하고 새로운 end 시간을 넣는다. 
		queue.add(lectures.get(0).end);
		for(int i=1; i<N; i++) {
			int endTime = queue.peek();
			if(lectures.get(i).start >= endTime) {
				queue.poll();
			}
			queue.offer(lectures.get(i).end);
		}
		
		// 큐의 사이즈를 출력한다. 
		System.out.println(queue.size());
	}
	
}
