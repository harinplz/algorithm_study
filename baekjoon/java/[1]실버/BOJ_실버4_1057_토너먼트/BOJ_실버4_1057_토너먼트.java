import java.io.*;
import java.util.*;

public class BOJ_실버4_1057_토너먼트 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int im = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) queue.offer(i);
		int round = 0;
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			round++;
			int size = queue.size();
			
			for(int i=0; i<size; i+=2) {
				if(i == size - 1 && size % 2 == 1) {
					int num = queue.poll();
					if(num == kim) kim = i/2 + 1;
					else if(num == im) im = i/2 + 1;
					queue.offer(i/2 + 1);
					continue;
				}
				int num1 = queue.poll();
				int num2 = queue.poll();
				
				if(num1 == kim && num2 == im || num1 == im && num2 == kim) {
					flag = true;
					break;
				}
				else if(num1 == kim || num2 == kim) {
					kim = i/2 + 1;
					queue.offer(kim);
				}
				else if(num1 == im || num2 == im) {
					im = i/2 + 1;
					queue.offer(im);
				}
				else queue.offer(i/2 + 1);
			}
			
			if(flag) break;
		}
		
		round = flag ? round : -1;
		System.out.println(round);
	}
}
