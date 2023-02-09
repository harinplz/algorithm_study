package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_2961_도영이가만든맛있는음식 {
	
	private static StringTokenizer st;
	private static int[] S; //신맛 배열
	private static int[] B; //쓴맛 배열
	private static boolean[] isSelected;
	private static int N;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine()); //재료의 개수 입력받음.
		
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		} //신맛과 쓴맛을 입력받음.
		
		cook(0,1,0);
		
		System.out.println(min);
	}

	private static void cook(int cnt, int sMul, int bSum) {
		//기저 부분
		if(cnt==N) {
			if(sMul != 1 && bSum != 0) {
				if(min > Math.abs(sMul-bSum)) min = Math.abs(sMul-bSum);
			}
			return;
		}
		
		//유도 부분
		
		isSelected[cnt] = true;
		cook(cnt+1, sMul*S[cnt], bSum + B[cnt]);
		
		isSelected[cnt] = false;
		cook(cnt+1, sMul, bSum);
		
	}
	
}
