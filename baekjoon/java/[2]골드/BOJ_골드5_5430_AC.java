import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_골드5_5430_AC {
	
	/*
	 * 메모리 101168KB 시간 600ms
	 * 문제가 쉬운데 왜 이렇게 정답률이 낮지? 라고 생각했는데 역시 시간초과 때문이였다.
	 * reverse를 굳이 해줄 필요도 없었고 D 연산도 list에서 하나씩 찾아서 remove 해주면 O(N) 시간 복잡도라 더 오래 걸리는거였다.
	 * Deque LinkedList 한 번도 써본적 없는데 좋은 것 같다 .... pollFirst랑 pollLast를 쓸 수 있음!! 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0) {
			String cmd = in.readLine();
			int n = Integer.parseInt(in.readLine());
			
			// 숫자 배열 입력 받기 
			String str = in.readLine();
			int strLen = str.length();
			str = str.substring(1, strLen-1);
			
			Deque<Integer> deque = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(str, ",");
			for(int i=0; i<n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			
			boolean error = false;
			
			int rCnt = 0;
			for(int i=0; i<cmd.length(); i++) {
				if(error) break;
				char c = cmd.charAt(i);
				
				switch(c) {
				case 'R':
					rCnt++;
					break;
				case 'D':
					if(deque.isEmpty()) {
						error = true;
						break;
					}
					if(rCnt % 2 == 0) deque.pollFirst();
					else deque.pollLast();
					break;
				}
			}
			
			if(error) sb.append("error").append('\n');
			else {
				sb.append('[');
				int size = deque.size();
				if(rCnt%2==0) {
					for(int i=0; i<size; i++) {
						if(i==size-1) sb.append(deque.pollFirst());
						else sb.append(deque.pollFirst()).append(',');
					}
				}
				else {
					for(int i=0; i<size; i++) {
						if(i==size-1) sb.append(deque.pollLast());
						else sb.append(deque.pollLast()).append(',');
					}
				}
				sb.append(']').append('\n');
			}
		}
		System.out.println(sb);
	}

}
