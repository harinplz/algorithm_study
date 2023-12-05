import java.io.*;
import java.util.*;

public class BOJ_실버2_6603_로또 {

  /*
	 * 풀이 시간 : 26분 10초
	 * 풀이 방법 : 조합 
	 * 메모리 : 11724KB, 시간 : 80ms 
	 */
	
	static StringBuilder sb = new StringBuilder();
	
	static int nums[] = new int[6];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = in.readLine();
			if(str.equals("0")) break; // 입력으로 0이 들어왔을 때 중단하기 
			
			StringTokenizer st = new StringTokenizer(str);
			int k = Integer.parseInt(st.nextToken());
			int[] s = new int[k]; // k개 뽑은 숫자 집합 
			
			// 입력 
			for(int i=0; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken()); 
			}
			
			// 뽑은 k개의 수 중에서 s 집합에서 숫자를 6개 뽑자. (중복X)
			combination(s, 0, 0);
			sb.append('\n');
		}

		System.out.println(sb); // 모아서 출력 (시간 단축) 
	}
	
	public static void combination(int[] arr, int start, int cnt) {
		// 다 뽑고 나서 
		if(cnt == 6) {
			for(int num : nums) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		// 뽑기 
		for(int i = start; i < arr.length ; i++ ) {
			nums[cnt] = arr[i];
			combination(arr, i+1, cnt+1);
		}
	}
	
}
