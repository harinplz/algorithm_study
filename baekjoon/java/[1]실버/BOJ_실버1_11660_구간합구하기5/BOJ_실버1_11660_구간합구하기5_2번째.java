package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 230308
 * 메모리 : 119360KB 시간 : 1464ms
 * <회고>
 * 27일 전에는 1시간을 줘도 못 풀던 문제를 이번엔 6분안에 풀었다 ㅎㅎ
 * 아직 알고리즘... 정말 너무 부족하지만 그래도 한 달 전에 나보다는 늘었구나하는 생각에 ..뿌듯.
 */
public class BOJ_실버1_11660_구간합구하기5_2번째 {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //표의 크기 N
		int M = Integer.parseInt(st.nextToken()); //합을 구해야하는 횟수 M
		
		int map[][] = new int[N+1][N+1];
		
		//map 입력 (누적합 저장)
		for(int i=1; i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				if(j==1) map[i][j] = Integer.parseInt(st.nextToken());
				else map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j-1];
			}
		}
		
		//합 횟수 M만큼 반복
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(in.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for(int i=r1; i<=r2; i++) {
				result += (map[i][c2] - map[i][c1-1]);
			}
			
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
	
}
