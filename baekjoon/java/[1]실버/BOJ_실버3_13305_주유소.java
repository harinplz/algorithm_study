import java.io.*;
import java.util.*;

public class BOJ_실버3_13305_주유소 {
	
	/*
	 * 풀이 시간 : 40분 5초 (살짝 블참) 
	 * 풀이 방법 : 그리디 
	 * 메모리 : 41488KB, 시간 : 352ms 
	 */
	
	/*
	 * 주의해야할 것 
	 * 1. 원리는 잘 파악하는데 이를 어떻게 구현할 지를 모른다.
	 * 1-1. 어제도 그렇고 원리는 똑같이 파악했는데 이를 괜히 복잡하게 구현해서 시간초과 나고 그럼 
	 * 1-2. 시간 초과 안나도록 단순화해서 구하는 연습을 하자!
	 * 2. 문제 제한 조건 잘 파악하기 
	 * 2-1. 문제 제한을 보면 일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 라고 되어있다.
	 * 2-2. int의 범위는 -2,147,483,648 ~ 2,147,483,647 라서 최소 비용을 저장하는 ans가 int 형일 경우 오버플로우가 발생할 수 있음을 주의!
	 * [정리] int와 long 타입 정리. 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		// 거리 배열 입력 
		long dis[] = new long[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N-1; i++) {
			dis[i] = Long.parseLong(st.nextToken());
		}
		
		// 리터 가격 배열 입력 
		long litter[] = new long[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			litter[i] = Long.parseLong(st.nextToken());
		}
		
		// 최소 비용 구하기 시작 
		// 최소 비용을 구하는 방법은 리터 가격을 내림차순이 되도록 값을 바꿔준 뒤,
		// 최소 비용 합에다가 리터 가격 * 거리 를 더해주면 된다. 
		for(int i=1; i<N; i++) {
			if(litter[i] >= litter[i-1]) {
				litter[i] = litter[i-1];
			}
		}
		
		long ans = 0;
		for(int i=0; i<N-1; i++) {
			ans += litter[i] * dis[i];
			// litter와 dis 배열이 long 타입이었던 이유. 
			// litter와 dis는 1이상 1,000,000,000 까지의 값이 들어올 수 있는데 
			// 얘네 둘이를 곱하면 int 범위를 벗어날 수 있음. 
			// 즉, 오버플로우가 발생하여 부정확한 결과가 나올 수 있다. 
			// 따라서, 미리 litter와 dis 배열을 long으로 선언하여 오버플로우를 막는다.
			// 아니라면? 여기서 (long)으로 명시적 형변환을 진행해도 된다. 
		}
		
		System.out.println(ans);
	
	}
	
}
