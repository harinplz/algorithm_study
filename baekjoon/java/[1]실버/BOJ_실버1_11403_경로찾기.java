import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_11403_경로찾기 {
	
	// 메모리 13972KB 시간 144ms
	// 플로이드 워샬로 문제를 푸니까 쉽게 풀렸다.
	// 플로이드 워샬 다시 한 번 공부하기 !! 
	
	static int N;
	static int[][] adjMatrix;
	
	//BFS
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		
		adjMatrix = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 경 출 도
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1)
						adjMatrix[i][j] = 1;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) sb.append(adjMatrix[i][j]).append(" ");
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
}
