import java.io.*;
import java.util.*;

public class BOJ_실버3_1021_회전하는큐_2월2일 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 큐의 크기 N
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수 M

		Deque<Integer> deque = new ArrayDeque<>();

		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}

		int ans = 0; // 원소를 순서대로 뽑는데 드는 연산의 수의 최솟값 
		// 원소를 순서대로 뽑아내기 

		st = new StringTokenizer(in.readLine());
		while(M-->0) {
			// 1. 뽑을 수를 입력 받는다. 
			int target = Integer.parseInt(st.nextToken());

			// 2. 뽑을 수의 인덱스를 찾는다.
			int idx = 0;
			Iterator iter = deque.iterator();

			while(iter.hasNext()) {
				idx++;
				int num = (int)iter.next();
				if(num == target) break;
			}

			// 3. 인덱스 1이면 그냥 poll 한다.
			if(idx == 1) {
				deque.poll();
				continue;
			}

			// 4. 인덱스를 통해 2번 연산이 나은지 3번 연산이 나은지 판단한다.
			int size = deque.size();

			if(idx <= size / 2 + 1) {
				while(true) {
					int num = deque.poll();
					deque.offerLast(num);
					ans++;
					if(deque.getFirst() == target) {
						deque.poll();
						break;
					}
				}
			}
			else {
				while(true) {
					int num = deque.pollLast();
					deque.offerFirst(num);
					ans++;
					if(deque.getFirst() == target) {
						deque.poll();
						break;
					}
				}
			}

		}

		System.out.println(ans);

	}


}
