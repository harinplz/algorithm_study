package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구현 문제
 * 메모리 : 21068KB, 시간 : 126ms
 * SSAFY 코테 준비할 땐 거의 못 풀었던 문젠데 지금 다른 거 하나도 참고 안하고 풀었다!!
 * 먼가 뿌듯 ㅎㅎ 근데 코드가 좀 더러워서 더 깔꼼하게 풀 수 있도록 노력해야겠다. 
 */

public class SWEA_D3_1873_상호의배틀필드 {
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static char arr[][];
	
	private static int [] dr = {-1, 1, 0, 0}; //상하좌우
	private static int [] dc = {0, 0, -1, 1};
	private static char[] tankD = {'^', 'v', '<', '>'};
	
	private static int H;
	private static int W;
	
	private static int tankDir; //0: 상 1: 하 2: 좌 3: 우
	private static int tankR;
	private static int tankC;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(in.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			arr = new char [H][W];
			
			//입력
			for(int i=0;i<H;i++) {
				String str = in.readLine();
				for(int j=0;j<W;j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '^') {
						tankDir = 0;
						tankR = i; tankC = j;
					} else if(arr[i][j] == 'v') {
						tankDir = 1;
						tankR = i; tankC = j;
					} else if(arr[i][j] == '<') {
						tankDir = 2;
						tankR = i; tankC = j;
					} else if(arr[i][j] == '>') {
						tankDir = 3;
						tankR = i; tankC = j;
					}
				}
			}
			
			arr[tankR][tankC] = '.';
			
			int N = Integer.parseInt(in.readLine()); //명령개수N
			
			String str = in.readLine();
			for(int i=0;i<N;i++) {
				char cmd = str.charAt(i);
				
				switch(cmd) {
				case 'U':
					changeDir(0);
					break;
				case 'D':
					changeDir(1);
					break;
				case 'L':
					changeDir(2);
					break;
				case 'R':
					changeDir(3);
					break;
				case 'S':
					shoot();
					break;
				}
				
			}
			
			
			arr[tankR][tankC] = tankD[tankDir];
			
			
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	private static void changeDir(int dir) {
		int nr = tankR + dr[dir];
		int nc = tankC + dc[dir];
		tankDir = dir;
		
		if((0 <= nr && nr < H) && (0 <= nc && nc < W)
				&& arr[nr][nc] == '.') {
			tankR = nr;
			tankC = nc;
		}
	}
	
	private static void shoot() {
		// TODO Auto-generated method stub
		int curR = tankR;
		int curC = tankC;
		while(true) {
			int nr = curR + dr[tankDir];
			int nc = curC + dc[tankDir];
			
			if((0<= nr && nr <H) && (0<=nc && nc<W)) {
				curR = nr;
				curC = nc;
				if(arr[curR][curC] == '*') {
					arr[curR][curC] = '.';
					break;
				}
				else if(arr[curR][curC] == '#') {
					break;
				}
			}
			else {
				break;
			}
		}
		
	}
	
}
