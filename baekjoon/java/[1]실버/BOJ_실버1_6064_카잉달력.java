import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 20904KB 시간 272ms

public class BOJ_실버1_6064_카잉달력 {
	
	public static void main(String arsg[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		int M, N, x, y;
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken())-1; // 나머지 값 0 나올 수도 있으므로 1 빼준다.
			y = Integer.parseInt(st.nextToken())-1;
			
			int gcd = getGCD(M, N);
			int lcm = M * N / gcd;
			// 다른 분들 코드 보니까 굳이 최소공배수를 구할 필요는 없었다..ㅎㅎ
			
			int ans = -1;
			for(int i=x; i<=lcm; i+=M) {
				if(i % N == y) {
					ans = i+1;
					break;
				}
			}
			
			System.out.println(ans);
			
		}
	}

	private static int getGCD(int m, int n) {
		if (m % n == 0) {
			return n;
		}
		return getGCD(n, m%n);
	}

}
