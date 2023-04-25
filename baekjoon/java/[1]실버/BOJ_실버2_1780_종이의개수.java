import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_1780_종이의개수 {
	
	/*
	 * 23.04.25
	 * 걸린 시간 : 15M
	 * 메모리 318992KB 시간 860ms 
	 * 분할 정복 방법으로 쉽게 풀 수 있었다 !!! 
	 */
	
	static int N;
	static int[][] map;
	static int[] cnt = new int[3];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		paper(0, 0, N);
		
		for(int i=0; i<3; i++) {
			sb.append(cnt[i]).append('\n');
		}
		
		System.out.println(sb);
		
	}

	// 재귀 종이 분할 정복 !! 
	private static void paper(int r, int c, int len) {
		//기저 조건
		if(len < 1) return;
		
		boolean chk = true; //확인 변수
		
		int val = map[r][c];
		for(int i=r; i<r + len; i++) {
			for(int j=c; j<c + len; j++) {
				if(map[i][j] != val) {
					chk = false;
					break;
				}
			}
			if(!chk) break;
		}
		
		if(chk) {
			cnt[val] += 1;
		}
		else {
			// 분할하기
			len = len/3;
			
			paper(r, c, len);
			paper(r, c+len, len);
			paper(r, c+ 2*len, len);
			
			paper(r+len, c, len);
			paper(r+len, c+len, len);
			paper(r+len, c+2*len, len);
			
			paper(r+2*len, c, len);
			paper(r+2*len, c+len, len);
			paper(r+2*len, c+2*len, len);
		}
		
		
	}

}
