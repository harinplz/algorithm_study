import java.io.*;
import java.util.*;

public class BOJ_실버1_19638_센티와마법의뿅망치 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		
		for(int i=0; i<N; i++) {
			queue.offer(Integer.parseInt(in.readLine()));
		}
		
		int cnt = 0;
		boolean flag = false;
		for(int t=1; t<=T; t++) {
			// T 만큼 반복 
			// 만약 지금 제일 큰 키가 센티보다 작다면 
			int height = queue.peek();
			if(height < H) {
				flag = true;
				break;
			}
			// 제일 큰 거인의 키가 센티보다 크거나 같다면 
			else {
				cnt++;
				height = queue.peek() == 1 ? 1 : queue.poll() / 2; 
				queue.offer(height);
				if(queue.peek() < H) {
					flag = true;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.println("YES");
			System.out.println(cnt);
		}
		else {
			System.out.println("NO");
			System.out.println(queue.peek());
		}
		
	}
	
}
