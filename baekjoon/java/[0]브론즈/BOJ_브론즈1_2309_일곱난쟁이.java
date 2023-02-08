package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_브론즈1_2309_일곱난쟁이 {
	
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] isSelected = new boolean[9];
	private static int[] dwarf = new int[7];
	private static int[] height = new int[9];
	private static boolean isFinish = false;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0;i<9;i++) {
			height[i] = Integer.parseInt(in.readLine());
		}
		
		search(0, 0);
		System.out.println(sb);
	}

	private static void search(int cnt, int start) {
		// 기저 부분
		if(cnt == 7) {
			if(!isFinish) { //처음 한 번 찾았으면 그 다음에는 찾아도 sb에 저장하지 못하도록 처리
				int total = 0;
				for(int num: dwarf) total += num;
				if(total==100) {
					Arrays.sort(dwarf);
					for(int num: dwarf) {
						sb.append(num).append("\n");
					}
					isFinish = true;
				}
			}
			return;
		}
		
		// 유도 부분
		for(int i = start;i<9;i++) {
			if(isSelected[i] == true) continue;
			
			isSelected[i] = true;
			dwarf[cnt] = height[i];
			search(cnt+1, i+1);
			
			isSelected[i] = false;
			
		}	
	}
	
}
