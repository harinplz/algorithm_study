package swea.january;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea_1974 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		//testCase 수 입력 받기
		int T;
		T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1;testCase<=T;testCase++) {
			sb.append("#"+testCase+" ");
			
			String arr[][] = new String[10][10];
			
			//입력값 2차원 배열 arr에 삽입
			for(int i = 0;i<9;i++) {
				String[] a = in.readLine().split(" ");
				
				for(int j = 0;j<9;j++) {
					arr[i][j] = a[j];
				}
 			}
			
			int ans = 1;
			
			//가로, 세로 확인
			for(int i=0;i<9;i++) {
				if (ans==0)
					break;
				int sum = 0;
				int sum2 = 0;
				for(int j = 0;j<9;j++) {
					sum += Integer.parseInt(arr[i][j]);
					sum2 += Integer.parseInt(arr[j][i]);	
				}
				if (sum != 45 || sum2 != 45) {
					ans = 0;
					break;
				}
			}
			
			//3x3 크기 격자 확인

			if (ans == 1) {
				for(int i=0;i<9;i+=3) {
					if (ans==0)
						break;
					for(int j=0;j<9;j+=3) {
						int sum3=0;
						for(int x=0;x<3;x++) {
							for(int y=0;y<3;y++)
								sum3 += Integer.parseInt(arr[i+x][j+y]);
						}
						if (sum3 != 45) {
							ans = 0;
							break;
						}
					}
				}
			}
			 
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
