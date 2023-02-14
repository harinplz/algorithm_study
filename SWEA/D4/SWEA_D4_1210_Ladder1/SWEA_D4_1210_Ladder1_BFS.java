package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class pair {
	int r;
	int c;

	pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class SWEA_D4_1210_Ladder1_BFS {

	private static StringBuilder sb = new StringBuilder();
	private static boolean [][] isSelected;
	private static int [][] ladder;
	private static int [] dr = {0,0,-1}; //좌, 우, 상
	private static int [] dc = {-1, 1, 0};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			in.readLine();
			
			//사다리 입력 받기
			ladder = new int[100][100];
			isSelected = new boolean[100][100];
			pair end = null;
			
			for(int i = 0; i<100; i++) {
				String split[] = in.readLine().split(" ");
				for(int j = 0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(split[j]);
					if(ladder[99][j] == 2) end = new pair(99, j);
				}
			}
			
			bfs(end);
		}
		System.out.println(sb);

	}

	private static void bfs(pair end) {
		// bfs 탐색을 위한 큐 생성
		Queue<pair> queue = new ArrayDeque<pair>();
		queue.offer(new pair(end.r, end.c));
		isSelected[end.r][end.c] = true;
		
		while(!queue.isEmpty()) {
			pair temp = queue.poll();
			
			if(temp.r == 0) {
				sb.append(temp.c).append("\n");
				break;
			}
			
			for(int i = 0;i<3;i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				
				if((0<= nr && nr <100) && (0 <= nc && nc < 100)
						&& (ladder[nr][nc] == 1) && (isSelected[nr][nc] == false)) {
					isSelected[nr][nc] = true;
					queue.offer(new pair(nr, nc));
					break;
				}
			
			}
		}
		
		
		
	}
}
