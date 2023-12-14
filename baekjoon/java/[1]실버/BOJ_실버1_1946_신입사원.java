import java.io.*;
import java.util.*;

public class BOJ_실버1_1946_신입사원 {
	
	/*
	 * 풀이 방법
	 * - 블로그참고 (https://minhamina.tistory.com/118)
	 * - https://velog.io/@jeaun80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%B0%B1%EC%A4%801946-%EC%8B%A0%EC%9E%85%EC%82%AC%EC%9B%90-java
	 */

  /*
   * 블참하기 전에는 이중 for문을 통해서 풀었다. 근데 시간 복잡도가 n^2이라 100억 연산으로 100초가 나와서 당연히 시간초과 ㅠ.ㅠ 
   * 블참 후 정렬로 for 문을 한 번 쓰면 되는구나! 알게되어서 Score class를 생성 후 compareTo 함수를 오버라이딩하여 정렬을 구현했다. 
   * 그런데 두번째 블로그를 읽어보니 클래스를 생성하는 것보단 arr[서류등수-1] = 면접등수로 구현하는 것이 코드가 간결하고 직관적으로 보였음. !! 
   * 조금만 더 생각하면 풀 수 있었을 것 같은데 아쉽구만 ... 생각을 하는 능력을 키우려 노력하자!! 
   */
	
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(in.readLine());
			int arr[] = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				arr[first-1] = second;
			}
			
			int ans = 1; // 선발할 수 있는 신입사원 수 (1등은 포함이라 처음에 1로 초기화하여 풀기) 
			int min = arr[0]; // 지금까지 면접 등수 젤 높은 등수, 이것보다 낮으면 신입사원에 채용되지 못한다 .. ㅠ.ㅠ 
			for(int i=1; i<N; i++) {
				if(arr[i] < min) {
					min = arr[i];
					ans++;
				}
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
