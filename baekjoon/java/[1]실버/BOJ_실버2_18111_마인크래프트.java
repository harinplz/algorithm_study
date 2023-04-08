import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버2_18111_마인크래프트 {

	/*
	 * 메모리 34620KB 시간 628ms 
	 */

	/**
	 * 푸는 방법
	 * 일단 땅의 높이를 저장하는 변수가 있어야할 것 같고 ... 타임 변수도 필요할 것 같다.
	 * 제거 함수와 블록을 채우는 함수 2개 만들기 .. 근데 블록을 하나 채우는 함수는 b가 0일때는 실행 불가능하다.
	 * 목표는 모든 땅의 높이를 다 똑같이 만드는 것이기 때문에 .. 
	 */

	static int N, M, B;
	static int map[][];

	static int time = Integer.MAX_VALUE;

	static int min, max;
	static int height, ans;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 길이 
		M = Integer.parseInt(st.nextToken()); // 가로 길이 
		B = Integer.parseInt(st.nextToken()); // 인벤토리안에 있는 땅의 개수 

		map = new int[N][M];

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		for(int h = min; h <= max; h++) {

			int tempB = B;
			int tempT = 0;
			boolean isPossible = true;

			// 높이가 h일때 얘는 몇 번 연산해야 하는 지 계산? 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//만약 이 값이 h보다 크다면?
					if(map[i][j] > h) {
						tempB += (map[i][j] - h);
						tempT += (map[i][j] - h) * 2;
					}
					// 인벤토리에서 블록 하나를 꺼내서 좌표의 가장 위에 놓음 (1초)
					else if(map[i][j] < h) {
						tempB -= (h-map[i][j]);
						tempT += (h-map[i][j]);
					}
				}
			}

			if(tempB < 0) isPossible = false;

			if(isPossible) {
				if(time > tempT) {
					time = tempT;
					height = h;
				}
				else if(time == tempT) {
					height = Math.max(h, height);
				}
			}

			//System.out.println(h+": " + time + " " + height);
		}

		System.out.println(time + " " + height);



	}

}
