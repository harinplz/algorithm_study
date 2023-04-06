import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드1_17472_다리만들기2 {

	// 위치 정보 클래스
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

	// 다리 (간선) 정보 클래스
	static class Bridge implements Comparable<Bridge> {
		int startI;
		int endI;
		int length;

		public Bridge(int startI, int endI, int length) {
			super();
			this.startI = startI;
			this.endI = endI;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Bridege [startI=" + startI + ", endI=" + endI + ", length=" + length + "]";
		}

		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(this.length, o.length);
		}
	}

	// 크루스칼
	private static int[] parents;
	static int nodeNo;

	// 단위 집합 생성
	private static void makeSet() {
		parents = new int[nodeNo + 1]; //인덱스 1번부터 사용

		for(int i=1; i<=nodeNo; i++) {
			parents[i] = i;
		}

	}

	// a의 집합 찾기 (a의 대표자 찾기)
	private static int findSet(int a) {
		if(parents[a] == a) return a;

		return parents[a] = findSet(parents[a]);
	}

	// a, b 두 집합 합치기
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;

		parents[bRoot] = aRoot;
		return true;
	}

	static int N, M; // 세로 N 가로 M
	static int map[][];

	static boolean isVisited[][];

	//탐색 위한 방향 값
	static int dr[] = {0, 1, -1, 0}; //우하상좌
	static int dc[] = {1, 0, 0, -1};

	//다리 정보 저장
	static List<Bridge> bridges = new ArrayList<Bridge>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		//map 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//map에 번호 지정
		isVisited = new boolean[N][M];
		nodeNo = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !isVisited[i][j]) {
					makelandNum(new Pos(i, j), ++nodeNo);
				}
			}
		}

		//다리 만들기 
		isVisited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					makeBridge(new Pos(i, j));
				}
			}
		}

		Collections.sort(bridges);
		makeSet();

		int result = 0;
		int count = 0;
		for(Bridge bridge : bridges) {
			if(union(bridge.startI, bridge.endI)) {
				result += bridge.length;
				if(++count == nodeNo - 1) break;
			}
		}

		for(int i=1; i<=nodeNo; i++) {
			findSet(i);
		}

		// parent다 값 같은지 확인 (다리가 다 연결 되어있는 지 확인)
		boolean check = true;
		int parentVal = parents[1];
		for(int i=2; i<=nodeNo; i++) {
			if(parents[i] != parentVal) {
				check = false;
				break;
			}
		}

		if(result == 0 || !check) System.out.println(-1);
		else System.out.println(result);

	}


	//다리 만들기 함수
	private static void makeBridge(Pos pos) {
		int startIsland = map[pos.r][pos.c];

		for(int i=0; i<4; i++) { //방향 상하좌우 반복

			int curR = pos.r;
			int curC = pos.c;

			while(true) {
				// 쭉 직진해야함. 
				int nr = curR + dr[i];
				int nc = curC + dc[i];

				if(!(0<= nr && nr < N && 0<= nc && nc < M)) break;

				//만약 자신과 번호가 같다면 같은 섬이니까 직진 중단. 
				if(map[nr][nc] == startIsland) break;

				// 만약 바다라면 (값이 0이라면) continue. 쭉 직진시킴
				if(map[nr][nc] == 0) {
					curR = nr;
					curC = nc;
					continue;
				}

				// 만약 다른 숫자가 나왔다면 다리 만들기
				if(map[nr][nc] != startIsland) {
					boolean check = true;
					// 다리 길이가 2 이상이어야함.
					int length = Math.abs(pos.r - nr) + Math.abs(pos.c - nc) - 1;
					if(length >= 2) {
						bridges.add(new Bridge(startIsland, map[nr][nc], length));						
					}
					break;
				}
			}

		}
	}

	// 섬에 번호 부여하기
	private static void makelandNum(Pos pos, int nodeNo) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(pos);
		isVisited[pos.r][pos.c] = true;
		map[pos.r][pos.c] = nodeNo;

		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();

			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];

				if(0<= nr && nr < N && 0 <= nc && nc < M) {
					if(!isVisited[nr][nc] && map[nr][nc] == 1) {
						isVisited[nr][nc] = true;
						map[nr][nc] = nodeNo;
						queue.offer(new Pos(nr, nc));
					}
				}
			}
		}

	}



}