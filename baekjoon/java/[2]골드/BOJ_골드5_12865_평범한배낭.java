import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_12865_평범한배낭 {
	
public static void main(String[] args) throws Exception {
	
	//System.setIn(new FileInputStream("input.txt"));
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// 0. 입력
	StringTokenizer st = new StringTokenizer(in.readLine());
	
	int N = Integer.parseInt(st.nextToken()); //물품의 수
	int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게 (목표 무게)
	
	int weight[] = new int[N+1];
	int profit[] = new int[N+1];
	
	for(int i=1; i<=N; i++) {
		st = new StringTokenizer(in.readLine());
		weight[i] = Integer.parseInt(st.nextToken());
		profit[i] = Integer.parseInt(st.nextToken());
	}
	
	//1. 동적 테이블 생성
	int D[][] = new int[N+1][K+1]; //0, 0 자동으로 0으로 초기화
	
	//2. 베이스 값 할당
	
	//3. 점화식
	
	for(int i=1; i<=N; i++) {
		for(int w=1; w<=K; w++) {
			if(weight[i] > w) {
				D[i][w] = D[i-1][w];
			}
			else {
				D[i][w] = Math.max(D[i-1][w], profit[i] + D[i-1][w - weight[i]]);
			}
		}
	}
	
	System.out.println(D[N][K]);
}
}