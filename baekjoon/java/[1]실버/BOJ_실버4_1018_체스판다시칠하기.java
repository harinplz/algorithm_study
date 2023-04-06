import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버4_1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		//8X8로 나누기
		for(int starti=0; starti<=N-8; starti++) {
			for(int startj=0; startj<=M-8;startj++) {
				
				//나눈 후 비교 시작
				int cntW = 0;
				int cntB = 0;
				for(int i = starti; i<starti+8; i++) {
					for(int j = startj; j < startj + 8; j++) {
						//W가 제일 위
						if(startW[i-starti][j-startj] != map[i][j]) cntW++;
						if(startB[i-starti][j-startj] != map[i][j]) cntB++;
					}
				}
				
				min = Math.min(min, Math.min(cntW, cntB));
			}
		}
		
		System.out.println(min);

	}
	
	static char[][] startB = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	
	static char[][] startW = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};

}