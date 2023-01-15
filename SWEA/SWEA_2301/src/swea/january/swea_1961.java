package harin.java.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1961 {
	public static int[][] Rotation(int[][] arr){
		int[][] result = new int[arr.length][arr.length];
		
		for(int i = 0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				result[i][j] = arr[arr.length-j-1][i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(in.readLine());
		
		for(int testCase=1;testCase<=T;testCase++) {
			sb.append("#"+testCase+"\n");
			
			int N;
			N = Integer.parseInt(in.readLine());
			
			int arr[][] = new int[N][N];
			
			//2차원 배열 입력 
			for(int i = 0;i<N;i++) {
				String[] a = in.readLine().split(" ");
				
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(a[j]);
				}
			}
			
			//90도 회전
			int[][] arr90 = Rotation(arr);
			//180도 회전
			int[][] arr180 = Rotation(arr90);
			//270도 회전 
			int[][] arr270 = Rotation(arr180);
			
			//출력
			for(int i = 0;i<N;i++) {
				for(int j=0;j<N;j++)
					sb.append(arr90[i][j]);
				sb.append(" ");
				for(int j=0;j<N;j++)
					sb.append(arr180[i][j]);
				sb.append(" ");
				for(int j=0;j<N;j++)
					sb.append(arr270[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
