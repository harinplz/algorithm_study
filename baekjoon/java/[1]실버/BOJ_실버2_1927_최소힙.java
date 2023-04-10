import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_실버2_1927_최소힙 {
	
	/*
	 * 메모리 24700KB 시간 276ms
	 */

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(in.readLine());
			
			if(cmd == 0) {
				if(queue.isEmpty()) sb.append(0).append('\n');
				else {					
					int num = queue.poll();
					sb.append(num).append('\n');
				}
			}
			else if(cmd > 0) {
				queue.offer(cmd);
			}
		}
		
		System.out.println(sb);
	}

}
