import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_14502_연구소 {
	
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
	
	static int N;
	static int M;
	
	static int arr[][];
	static int copy[][]; //arr 복사 배열
	static List<Pos> virus = new ArrayList<>(); //바이러스 위치 저장
	
	// 조합 위한 변수
	static Pos selected[];
	static List<Pos> list = new ArrayList<>();
	
	// bfs 위한 변수 
	static boolean isVisited[][];
	static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우 
	static int dc[] = {0, 0, -1, 1};
	
	// 최댓값 저장 변수
	static int max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 0. 입력
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M]; // 배열 생성
		selected = new Pos[3];
		
		// 배열 값 채우면서 list에 값이 0 인 애 추가
		// 2인 값도 추가...
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) list.add(new Pos(i,j));
				else if(arr[i][j]==2) virus.add(new Pos(i,j));
			}
		}
		
		combination(0, 0);
		
		//System.out.println(virus);
		
		// 1. 3가지 벽을 세울 공간 어떻게 정함 조합으로 ..? 
		// 1-1. 벽 세울 곳 일단 0이어야함.
		// 1-2. pos 클래스를 만들어서 0인 곳 list에 추가해서 3개 뽑기 ... ??
		
		// 2. 3개 뽑았으면 BFS로 인접한 공간 방문하기
		
		// 3. 안전 영역 크기 최댓값 계속해서 갱신하기 
		
		System.out.println(max);
		
	}
	
	// 조합
	private static void combination(int start, int cnt) {
		if(cnt==3) {
			//System.out.println(Arrays.toString(selected));
			
			// 카피 배열 생성
			copy = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) copy[i][j] = arr[i][j];
			}
			
		
			//System.out.println(Arrays.deepToString(arr));
			isVisited = new boolean[N][M];
			
			for(int i=0; i<3; i++) {
				int r = selected[i].r;
				int c = selected[i].c;
				
				copy[r][c] = 1; //1로 만들기
				isVisited[r][c] = true;
			}
			
			//System.out.println("COPY: " + Arrays.deepToString(copy));
			
			bfs();
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			selected[cnt] = list.get(i);
			combination(i+1, cnt+1);
		}
		
	}

	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		for(int i=0; i<virus.size(); i++) {
			queue.offer(virus.get(i));
			isVisited[virus.get(i).r][virus.get(i).c] = true;
		}
		
		
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(0 <= nr && nr < N && 0<= nc && nc < M) { // 범위 체크
					if(!isVisited[nr][nc] && copy[nr][nc] == 0) {
						copy[nr][nc] = 2;
						isVisited[nr][nc] = true;
						queue.offer(new Pos(nr, nc));
					}
				}
			}
		}
		
		//System.out.println("VIRUS: " + Arrays.deepToString(copy));
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == 0) cnt++;
			}
		}
		
		//System.out.println(cnt + ", max: " +max);
		
		max = Math.max(cnt, max);
	}
	
}