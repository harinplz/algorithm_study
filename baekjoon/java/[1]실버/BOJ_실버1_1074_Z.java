package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_1074_Z {
	
	/**
	 * 분할 정복 문제
	 * 메모리 : 14280KB, 시간 : 124ms
	 * 수업시간에도 풀었는데 다시 풀어도 범위 이상하게 해서 답이 안나옴 .. T.T
	 * 분할 정복은 또 .. 어디를 분할해야할 지 매우 중요하니까 더 잘 생각!!!! 
	 * 인터넷, 교수님 설명 참고했음. 😂
	 */
	
	private static StringTokenizer st;
	private static int N, R, C;
	private static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		
		cut(0, 0, size);
		
		System.out.println(ans);
	}

	private static void cut(int r, int c, int size) {
		//기저 조건
		if(size == 1) return;
		
		//유도 조건
		int half = size/2;
		
		//1번
		if(R < r+half && C < c+half) {
			cut(r, c, half);
		}
		//2번
		else if(R< r+half && (c+half <= C)) {
			ans += half * half;
			cut(r, c+half, half);
		}
		//3번
		else if((r+half <= R)  && (C < c+half)) {
			ans += (half * half) * 2;
			cut(r+half, c, half);
		}
		else if((r+half <= R)  && (c+half <= C) ) {
			ans += (half * half) * 3;
			cut(r+half, c+half, half);
		}
		
	}
	
}
