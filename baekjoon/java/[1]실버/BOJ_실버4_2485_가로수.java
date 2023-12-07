import java.io.*;
import java.util.*;

public class BOJ_실버4_2485_가로수 {
	
	/*
	 * 풀이시간 : 45분 (블로그 참고) 
	 * 풀이방법 : 최대 공약수 (유클리드 호제법) / 수학 
	 * 메모리: 21520KB, 시간 : 212ms 
	 */
	
	/*
	 * 첫 번째 시도 : 최소 간격을 구한다. -> 간격이 모두 똑같지 않음. 
	 * 두 번째 시도 : 간격들의 최대공약수를 구한다. -> 이 과정에서 최대공약수를 구하는 방법 실패 
	 * -> 최대 공약수를 구하는 유클리드 호제법 공부 필요! 
	 */

	public static void main(String[] args) throws Exception {
		
		// 목표 : 모든 가로수가 같은 간격이 되도록 새로 심어야하는 가로수의 최소수 
		
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 현재 가로수의 수 
		
		// 가로수 정보 입력 
		int tree[] = new int[N]; 
		
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(in.readLine());
		}
		
		// 최대 공약수 구하기 
		int gcd = 0;
		for(int i=0; i<N-1; i++) {
			int gap = tree[i+1] - tree[i];
			gcd = GCD(gap, gcd);
		}
		
		// 심어야하는 가로수 : 가로수 전체 수 - 지금 존재하는 가로수 
		// 가로수 전체 수 : tree[N-1] - tree[0] : (마지막 가로수 위치 - 첫번째 가로수 위치) / 간격 + 1(첫 번째 가로수 포함) 
		int ans = ((tree[N-1] - tree[0]) / gcd) + 1 - tree.length;
		
		
		System.out.println(ans);
	}
	
	// 최대 공약수 구하는 과정 (유클리드 호제법) 
	public static int GCD(int a, int b) {
		if(b == 0) return a;
		else return GCD(b, a%b);
	}
}
