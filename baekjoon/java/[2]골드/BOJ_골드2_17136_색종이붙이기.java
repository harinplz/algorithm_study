import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드2_17136_색종이붙이기 {
	
	static int paperTen[][] = new int[10][10];
	static int paperCnt[] = {0, 5, 5, 5, 5, 5};
	
	// 최소 종이 개수
	// 사용 종이 개수 저장
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<10; j++) {
				paperTen[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);

		if(ans==Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}




	private static void dfs(int r, int c, int cnt) {
		if(r >= 9 && c > 9) {
			ans = Math.min(ans, cnt);
		}
		
		if(ans <= cnt) return;
		
		if(c > 9) {
			dfs(r+1, 0, cnt);
			return;
		}
		
		if(paperTen[r][c] == 1) {
			for(int len=5; len>=1; len--) {
				if(paperCnt[len]>0 && check(r, c, len)) {
					paperCnt[len]--;
					attachPaper(r, c, len);
					dfs(r, c+1, cnt+1);
					detachPaper(r, c, len);
					paperCnt[len]++;
				}
			}
		}
		else {
			dfs(r, c+1, cnt);
		}
	}




	//색종이를 붙일 수 있는 지 확인하는 함수
	private static boolean check(int r, int c, int len) {
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(0<= i && i<10 && 0 <= j && j<10) {
					if(paperTen[i][j] == 0) return false;
				}
				else return false;
			}
		}
		//System.out.println(r +", " + c + ", " + len);
		return true;
	}
	
	//색종이 붙인 자리 0으로 변경해주는 함수
	private static void attachPaper(int r, int c, int len) {
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				//if(0<= i && i<10 && 0 <= j && j<10) {
				paperTen[i][j] = 0;
				//}
			}
		}
		
	}
	
	//색종이 떼기
	private static void detachPaper(int r, int c, int len) {
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				//if(0<= i && i<10 && 0 <= j && j<10) {
				paperTen[i][j] = 1;
				//}
			}
		}
	}

}
