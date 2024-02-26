import java.io.*;
import java.util.*;

public class BOJ_실버4_18258_큐2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			String str = st.nextToken();
			
			switch(str) {
			case "push":
				deque.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!deque.isEmpty()) sb.append(deque.poll()+ "\n");
				else sb.append(-1 + "\n");
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if(!deque.isEmpty()) sb.append(0 + "\n");
				else sb.append(1 + "\n");
				break;
			case "front":
				if(!deque.isEmpty()) sb.append(deque.peekFirst() + "\n");
				else sb.append(-1 + "\n");
				break;
			case "back":
				if(!deque.isEmpty()) sb.append(deque.peekLast() + "\n");
				else sb.append(-1 + "\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}
