import java.io.*;
import java.util.*;

public class BOJ_실버3_1021_회전하는큐 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		
		st = new StringTokenizer(in.readLine());
		
		int ans = 0;
		while(M-->0) {
			int target = Integer.parseInt(st.nextToken());

			Iterator iter = deque.iterator();
			int idx = 0;
			while(iter.hasNext()) {
				if((int)iter.next() == target) break;
				else idx++;
			}
			
			if(idx == 0) deque.poll();
			else if(idx <= deque.size()-idx-1) {
				while(true) {
					int num = deque.pollFirst();
					if(num == target) break;
					else {
						deque.offerLast(num);
						ans++;
					}
				}
			}
			else {
				while(true) {
					int num = deque.pollFirst();
					if(num == target) break;
					else {
						deque.offerFirst(num);
						deque.offerFirst(deque.pollLast());
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
		
}
