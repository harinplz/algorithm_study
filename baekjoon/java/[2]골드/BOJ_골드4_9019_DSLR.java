import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_9019_DSLR {
	
	/*
	 * 53분 (넘 느긋하게 풀어서 문제다)
	 * 메모리 299252KB 시간 3004ms
	 * 시간 메모리 이게 맞나...? 하지만 통과되었다.
	 * BFS 문제 => 처음에 이게 BFS 문제인지 ... 감도 안잡혔는데 뭔가 다 찾아야하는 느낌이면 BFS 인듯..?
	 * visted로 방문 체크해줘야함!! 
	 * 그리고 처음에는 L, R 연산을 String으로 처리해서 시간초과가 났다 ㅠㅠ 조심!
	 */
	
	static class DSLR {
		int num;
		String cmd;
		
		public DSLR(int num, String cmd) {
			super();
			this.num = num;
			this.cmd = cmd;
		}

		@Override
		public String toString() {
			return "DSLR [num=" + num + ", cmd=" + cmd + "]";
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			BFS(A, B);
		}
		
		System.out.println(sb);
		
	}

	private static void BFS(int A, int B) {
		Queue<DSLR> queue = new ArrayDeque<DSLR>();
		queue.offer(new DSLR(A, ""));
		visited[A] = true;
		
		while(!queue.isEmpty()) {
			DSLR cur = queue.poll();
			
			if(cur.num == B) {
				sb.append(cur.cmd).append('\n');
				return;
			}
			
			int num;
			
			num = D(cur.num);
			if(!visited[num]) {
				queue.offer(new DSLR(num, cur.cmd + "D"));
				visited[num] = true;
			}
			
			num = S(cur.num);
			if(!visited[num]) {
				queue.offer(new DSLR(num, cur.cmd + "S"));
				visited[num] = true;
			}
			
			num = L(cur.num);
			if(!visited[num]) {
				queue.offer(new DSLR(num, cur.cmd + "L"));
				visited[num] = true;
			}
			
			num = R(cur.num);
			if(!visited[num]) {
				queue.offer(new DSLR(R(cur.num), cur.cmd + "R"));
				visited[num] = true;
			}	
		}
		
	}

	private static int D(int num) {
		return (2 * num) % 10000;
	}

	private static int S(int num) {
		num = num == 0 ? 9999 : num - 1;
		return num;
	}

	private static int L(int num) {
		return (num % 1000) * 10 + (num / 1000);
	}
	
	private static int R(int num) {
		
		return (num % 10) * 1000 + (num / 10);
	}


}
