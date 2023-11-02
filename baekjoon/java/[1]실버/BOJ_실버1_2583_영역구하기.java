import java.io.*;
import java.util.*;

public class BOJ_실버1_2583_영역구하기 {

	/**
	 * 풀이 시간 : 50분 29초 
	 * 풀이 방법 : DFS
	 */
	
	static int M, N, K;
	static int map[][]; // 영역 배열 
	static boolean isVisited[][]; // 방문 체크 배열 
	
	static int dr[] = {-1, 1, 0, 0}; // 인접 행 이동 배열 
	static int dc[] = {0, 0, -1, 1}; // 인접 열 이동 배열

	static int areaVar; // 방문한 넓이 구하는 변수 
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 0. 입력 
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. 일단 배열을 만들어서 채운다. 반대로 넣어보자. 
		// 입력받은 사각형은 1로 처리해준다. 
		map = new int[M][N];
		
		while(K-->0) { // K 만큼 반복 
			st = new StringTokenizer(in.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());

			for(int c = startC; c < endC; c++) {
				for(int r = startR; r < endR; r++) {
					map[c][r] = 1;
				}
			}
		}
		
		
		// 2. DFS로 탐색하며 나누어지는 영역의 개수와 각 영역의 넓이를 오름차순으로 출력한다. 
		List<Integer> area = new ArrayList<>(); // 영역 넓이 저장 리스트 
		int cnt = 0; // 영역의 개수 저장 변수 
		isVisited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0 && !isVisited[i][j]) { // map 값이 0이고 방문하지 않은 영역일때만 DFS로 영역의 넓이를 구한다. 
					areaVar = 0;
					cnt++;
					dfs(i, j);
					area.add(areaVar);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(area); // 오름차순 정렬 
		System.out.println(cnt);
		
		for(int num : area) {
			sb.append(num).append(' ');
		}
		System.out.println(sb);	
	}
	
	public static void dfs(int r, int c) {
		isVisited[r][c] = true; // 방문 처리 
		areaVar++; // 영역의 넓이 1을 더해준다. 
		
		// 실행 조건
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(isRange(nr, nc)) { // 범위 안에 있을때 
				if(map[nr][nc]!=1 && !isVisited[nr][nc]) { // 그리고 map의 값이 1이 아니고 범위 방문하지 않았을 때 
					dfs(nr, nc); // 다음 영역에 방문한다. 
				}
			}
		}
	}

  // 범위 체크 함수 
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < M && 0 <= c && c < N) return true;
		return false;
	}
	

}
