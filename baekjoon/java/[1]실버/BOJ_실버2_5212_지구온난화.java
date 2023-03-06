package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버2_5212_지구온난화 {
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	static int dr[] = {0, 1, -1, 0}; //우 하 상 좌
	static int dc[] = {1, 0, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char map[][] = new char [R][C];
		char copy[][] = new char[R][C];
		Queue<Pos> queue = new ArrayDeque<>();
		
		//정보 입력 받기
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
				copy[i][j] = map[i][j];
				if(map[i][j] == 'X') queue.offer(new Pos(i, j));
			}
		}
        
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			int cnt = 0;
			
			for(int i=0;i<4;i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				
				if((0<= nr && nr < R) && (0<= nc && nc<C)) {
					if(map[nr][nc] == '.') {
						cnt++;
					}
				}
				else cnt++;
			}
			
			if(cnt>=3) {
				copy[current.r][current.c] = '.';
			}
			
		}
		
		// X가 있는 젤 작은 행과 젤 작은 열을 찾아서 그만큼만 출력
		int minR = R;
		int minC = C;
		int maxR = -1;
		int maxC = -1;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if (copy[i][j] == 'X') {
					minR = Math.min(minR, i);
					minC = Math.min(minC, j);
					maxR = Math.max(maxR, i);
					maxC = Math.max(maxC, j);
				}
			}
		}
		
		for(int i=minR; i<=maxR;i++) {
			for(int j=minC; j<=maxC; j++) System.out.print(copy[i][j]);
			System.out.println();
		}
		
	}
	
}
