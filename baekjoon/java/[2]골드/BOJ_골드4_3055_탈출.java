package com.ssafy.daily28;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_3055_탈출 {
	
	//1. 위치 저장 클래스 생성
	static class Pos {
		int r;
		int c;
		int time;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
	}
	
	//BFS를 통한 이동위해 필요한 배열
	static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우 
	static int dc[] = {0, 0, -1, 1};
	static boolean wVisited[][];
	static boolean gVisited[][];
	
	static int R, C;
	static char[][] map;
	
	//고슴도치 위치 변수
	static Pos goPos;
	
	static int ans = Integer.MAX_VALUE;
	
	//물 위치 큐
	static Queue<Pos> waterQueue = new ArrayDeque<Pos>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		wVisited = new boolean[R][C];
		gVisited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					goPos = new Pos(i, j, 0); //고슴도치 위치
					map[i][j] = '.';
				}
				else if(map[i][j] == '*') {
					waterQueue.offer(new Pos(i, j)); //물이라면 물 큐에 추가
					wVisited[i][j] = true; //방문처리
				}
			}
		}
		
		bfs(goPos);
		
		if(ans == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(ans);
	}

	private static void bfs(Pos goPos) {
		// 고슴도치 이동을 위한 큐
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(goPos);
		gVisited[goPos.r][goPos.c] = true;
		
		while(!queue.isEmpty()) {
			//물 먼저 확산
			int waterSize = waterQueue.size();
			for(int w = 0; w < waterSize; w++) {
				Pos waterPos = waterQueue.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = waterPos.r + dr[i];
					int nc = waterPos.c + dc[i];
					
					if(0<= nr && nr < R && 0<= nc && nc < C) {
						if(!wVisited[nr][nc] ) {
							if(map[nr][nc] == '.') {
								wVisited[nr][nc] = true;
								waterQueue.offer(new Pos(nr, nc));
								map[nr][nc] = '*';
							}
						}
					}
				}
				
			}
			
			int goSize = queue.size();
			for(int g = 0; g<goSize; g++) {
				
				Pos curPos = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = curPos.r + dr[i];
					int nc = curPos.c + dc[i];
					
					if(0<= nr && nr < R && 0<= nc && nc < C) {
						if(!gVisited[nr][nc]) {
							if(map[nr][nc] == '.' || map[nr][nc] == 'D') {
								gVisited[nr][nc] = true;
								if(map[nr][nc] == 'D') {
									ans = Math.min(ans, curPos.time + 1);
								}
								queue.offer(new Pos(nr, nc, curPos.time + 1));
							}
						}
					}
				}
			}
			
		}
		
	}

}
