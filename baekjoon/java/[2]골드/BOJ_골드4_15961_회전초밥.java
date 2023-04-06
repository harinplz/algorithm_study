package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_15961_회전초밥 {
	
	// 회전 초밥에서 먹을 수 있는 초밥 가짓 수 최댓값 
	static int N, d, k, c;
	// N : 회전 초밥 벨트에 놓인 접시 수
	// d : 초밥 가짓 수
	// k : 연속해서 먹는 접시 수 
	// c : 쿠폰 번호

	static int sushibelt[];
	static int sushi[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushibelt = new int[N];
		
		for(int i=0; i<N; i++) {
			sushibelt[i] = Integer.parseInt(in.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		
		//초밥 배열
		sushi = new int[d+1];
		
		for(int i=0; i< k; i++) {
			sushi[sushibelt[i]]++;
		}
		
		int cnt = 0; //먹을 수 있는 초밥 개수
		for(int i=1; i<=d; i++) {
			if(sushi[i]>0) cnt++;
		}
		
		max = cnt;
		
		int startIdx, endIdx;
		for(startIdx=0; startIdx<N; startIdx++) {
			if(max <= cnt) {
				if(sushi[c] == 0) max = cnt+1;
				else max = cnt;
			}
			endIdx = (startIdx+k) % N;
			
			int noSushi = sushibelt[startIdx];
			int eatSushi = sushibelt[endIdx];
			
			sushi[noSushi]--;
			if(sushi[noSushi]==0) cnt--;
			sushi[eatSushi]++;
			if(sushi[eatSushi] == 1) cnt++;
		}
		
		System.out.println(max);
		
	}


}