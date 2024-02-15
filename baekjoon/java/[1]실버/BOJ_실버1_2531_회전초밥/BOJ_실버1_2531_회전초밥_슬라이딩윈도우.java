import java.io.*;
import java.util.*;

public class BOJ_실버1_2531_회전초밥_슬라이딩윈도우 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[d+1];
		int[] belt = new int[N];
		
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
		
		// 0부터 K-1까지의 벨트를 확인한다.
		int cnt = 0;
		
		for(int i=0; i<k; i++) {
			sushi[belt[i]]++;
		}

		for(int i=1; i<=d; i++) {
			if(sushi[i] > 0) cnt++;
		}
		
		int max = cnt;
		
		
		// 슬라이딩 윈도우로 돌면서 확인한다.
		for(int i = 0; i < N; i++) {
			// max 값 확인하기 
			if(max <= cnt) {
				if(sushi[c] == 0) max = cnt + 1;
				else max =cnt;
			}
			
			// 슬라이딩 윈도우는 앞에 꺼는 빼고 뒤에꺼는 넣어주는 방식이다. 
			// 그러면 앞에 먹은 초밥은 빼고 이제 먹을 초밥을 넣어주면 된다. 
			
			int noSushi = belt[i];
			int eatSushi = belt[(i + k) % N];
			
			sushi[noSushi]--;
			if(sushi[noSushi] == 0) cnt--;
			
			
			sushi[eatSushi]++;
			if(sushi[eatSushi] == 1) cnt++;
		}
		
		System.out.println(max);
			
	}


}
