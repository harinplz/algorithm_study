package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구현 + 순열
 * 메모리 : 20672kb, 시간 : 1947ms 
 * 순열로 생각하고 푸니까 바로 통과되었다 !!! 
 */

public class SWEA_D5_1247_최적경로 {
	
	static class pos{
		int r;
		int c;
		
		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + "]";
		}
		
		
		
	}
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static boolean[] isSelected;
	private static pos[] cusInput;
	private static pos[] cusSel;
	private static int min;
	private static int distance;
	
	private static pos company;
	private static pos home;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(in.readLine());
			cusInput = new pos[N];
			isSelected = new boolean[N];
			cusSel = new pos[N];
			
			st = new StringTokenizer(in.readLine());
			
			for(int i=0;i<N+2;i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(i==0) {
					company = new pos(r, c);
				}
				else if(i==1) {
					home = new pos(r,c);
				}
				else {
					cusInput[i-2] = new pos(r,c);
				}
			}
			
			
			min = Integer.MAX_VALUE;
			
			permu(0);
			sb.append(min).append("\n");
			
		}
		System.out.println(sb);
		
	}

	private static void permu(int cnt) {
		if(cnt == N) {
			distance = Math.abs(company.r - cusSel[0].r) 
					+ Math.abs(company.c - cusSel[0].c);
			for(int i=1;i<N;i++) {
				distance += Math.abs(cusSel[i].r - cusSel[i-1].r) +
						Math.abs(cusSel[i].c - cusSel[i-1].c);
			}
			distance += Math.abs(home.r - cusSel[N-1].r)
					+ Math.abs(home.c - cusSel[N-1].c);
			if(min > distance) {
				min = distance;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			cusSel[cnt] = cusInput[i];
			
			permu(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	
}
