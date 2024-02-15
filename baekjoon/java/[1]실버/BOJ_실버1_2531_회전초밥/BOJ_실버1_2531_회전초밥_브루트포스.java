import java.io.*;
import java.util.*;

public class BOJ_실버1_2531_회전초밥_브루트포스 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시 수 
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수 
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수 
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 
		
		int sushi[] = new int[2*N];
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(in.readLine());
			sushi[i + N] = sushi[i];
		}
		
		// 최대 초밥 가짓 수 구하기 
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			Set<Integer> selectSushi = new HashSet<>();
			for(int j=i; j<i + k; j++) {
				selectSushi.add(sushi[j]);
			}
			int size = selectSushi.size();
			if(size == k) {
				if(!selectSushi.contains(c)) ans = Math.max(ans, k + 1);
				else ans = Math.max(ans, k);
			}
			else {
				if(!selectSushi.contains(c)) ans = Math.max(ans, size + 1);
				else ans = Math.max(ans, size);
			}
		}
		
		System.out.println(ans);
	}

}
