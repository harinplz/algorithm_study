import java.io.*;
import java.util.*;

public class BOJ_실버3_2346_풍선터뜨리기 {

	static class Balloon {
		int idx;
		int num;
		
		public Balloon(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		Deque<Balloon> deque = new ArrayDeque<>();
		
		// arr 입력 받기 
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			deque.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
		}
    
		// 모아 찍을 stringBuilder 
		StringBuilder sb = new StringBuilder();
		
		while(deque.size() > 1) {
			Balloon curBall = deque.poll();
			sb.append(curBall.idx + " ");
			
			int mov = curBall.num;
			
			if(mov < 0) {
				while(mov++ < 0) {
					deque.addFirst(deque.pollLast());
				}
			}
			else {
				mov--;
				while(mov-- > 0) {
					deque.addLast(deque.pollFirst());
				}
			}
		}
		
		System.out.println(sb.append((deque.poll().idx)));
		
	}
}
