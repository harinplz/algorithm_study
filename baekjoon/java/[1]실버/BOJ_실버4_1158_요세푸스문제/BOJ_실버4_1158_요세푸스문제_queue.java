package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버4_1158_요세푸스문제_queue {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//요세푸스 순열을 구하기 위한 큐 생성
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		//queue에 1~N까지 수 넣기
		for(int i = 1;i<=N;i++) queue.offer(i);
		
		sb.append("<");
		
		//요세푸스 순열 계산
		while(queue.size() != 0) {
			int person = 0;
			for(int i = 1 ; i <K; i++) { //K이전의 수를 뽑아서 큐의 맨 뒤로 보낸다. 내가 필요한 건 K번째 수니까!
				person = queue.poll();
				queue.offer(person);
			}
			
			int removePerson = queue.poll(); //제일 앞에 있는 k번째 수 제거
			
			//queue size가 1이면 끝이니까 ">"를 출력
			if(queue.size() == 0) sb.append(removePerson).append(">");
			else sb.append(removePerson).append(", "); // 그 외에는 , 쉼표 출력
				
		}
		System.out.println(sb);
	}
	
}
