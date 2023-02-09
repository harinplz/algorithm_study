package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA_D4_1210_Ladder1 {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//값을 변경해주기 위한 dx, dy 배열 선언
		int[] dx = {-1,1,0}; //좌, 우, 상
		int[] dy = {0,0,-1};
		
		//10번 반복
		for(int tc = 1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			in.readLine();
			
			int ladder[][] = new int[100][100];
			
			int curX = 0;
			int curY = 99;
			
			//2차원 배열 입력
			for(int i = 0;i<100;i++) {
				String[] split = in.readLine().split(" ");
				for(int j = 0;j<100;j++) {
					ladder[i][j] = Integer.parseInt(split[j]);
					//Y 99에서 2값을 가지는 x 찾기
					if(ladder[curY][j] == 2) curX = j; 
				}
			}
			
			while(curY != 0) {
				for(int i = 0;i<3;i++) {
					int testX = curX + dx[i];
					int testY = curY + dy[i];
					
					if((0<=testX && testX<=99)
							&& (0<=testY && testY<=99)) {
						if(ladder[testY][testX] == 1) {
							ladder[testY][testX] = 7;
							curX = testX;
							curY = testY;
						}
					}
				}
			}
			sb.append(curX).append("\n");
		}
		System.out.println(sb);
	}
}
