import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_실버2_11279_최대힙 {
	
	/*
	 * 메모리 25738KB
	 * 시간 292ms
	 */

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(in.readLine());
			if(cmd == 0) {
				if(queue.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(queue.poll()).append('\n');
				}
			}
			else if(cmd > 0) {
				queue.offer(cmd);
			}
		}
		
		System.out.println(sb);
	}

}
