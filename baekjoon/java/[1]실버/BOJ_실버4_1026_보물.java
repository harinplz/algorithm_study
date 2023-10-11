import java.io.*;
import java.util.*;

public class BOJ_실버4_1026_보물 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int A[] = new int[N];
		int B[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// S의 최솟값을 구하기. A의 제일 작은 수와 B의 제일 큰 수를 곱하면 된다.. 
		// 1. A를 오름차순으로 정렬한다.
		Arrays.sort(A);
		
		// 2. B를 내림차순으로 정렬한다.
		B = Arrays.stream(B)
				.boxed().sorted(Collections.reverseOrder())
				.mapToInt(Integer::intValue).toArray();
		
		// 3. A[N] * B[N] 의 값을 구하면 된다!
		int S = 0;
		for(int i=0; i<N; i++) {
			S += A[i] * B[i];
		}
		
		System.out.println(S);
	}

}
