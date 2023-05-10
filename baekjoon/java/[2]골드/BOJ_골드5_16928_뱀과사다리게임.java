import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_16928_뱀과사다리게임 {
	
	/*
	 * 메모리: 11660KB 시간 : 76ms
	 * BFS
	 * count 배열로 주사위를 굴려야 하는 횟수 최솟값 구할 수 있음. 
	 * 어렵게 푸는 습관을 고쳐야할 것 같다...
	 */
	
	static int board[] = new int[101];
	static int count[] = new int[101];
	
	//방문체크
	static boolean visited[] = new boolean[101];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			board[from] = to;
		}
		
		BFS();
		
		System.out.println(count[100]);
	}

	private static void BFS() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		count[1] = 0;
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			
			int pos = queue.poll();
			if(pos == 100) return;
			
			//주사위 돌리기
			for(int i=1; i<=6; i++) {
				int next = pos + i;
				if(next > 100) continue;
				
				if(!visited[next]) { //방문한 곳이 아니라면
					visited[next] = true;
					
					// 뱀과 사다리가 있을 때
					if(board[next] != 0) {
						if(!visited[board[next]]) {
							visited[board[next]] = true;
							queue.offer(board[next]);
							count[board[next]] = count[pos] + 1;
						}
					}
					else { // 없을 때 
						queue.offer(next);
						count[next] = count[pos] + 1;
					}
				}
			}
			
		}
	}
	
}
