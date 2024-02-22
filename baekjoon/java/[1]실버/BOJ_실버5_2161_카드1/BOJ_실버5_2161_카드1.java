import java.io.*;
import java.util.*;

public class BOJ_실버5_2161_카드1 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			// 1번 연산 
			sb.append(queue.poll() + " ");
			
			if(queue.isEmpty()) break;
			
			int num = queue.poll();
			queue.offer(num);
		}
		
		System.out.println(sb);
	}

}
