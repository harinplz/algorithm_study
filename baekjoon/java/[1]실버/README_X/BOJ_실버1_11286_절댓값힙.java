package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_실버1_11286_절댓값힙 {
	//우선 순위 큐 구현

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//우선 순위 큐 생성
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//절댓값이 작은 값 출력
				// 절댓값이 같다면? 작은 수 출력
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else {
					return Math.abs(o1) - Math.abs(o2);
				}
			} 


		});

		int N = Integer.parseInt(in.readLine());

		for(int i=0;i<N;i++) {
			int x= Integer.parseInt(in.readLine());

			if(x==0) {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else sb.append(queue.poll()).append("\n");
			}else {
				queue.offer(x);
			}
		}

		System.out.println(sb);


	}
}
