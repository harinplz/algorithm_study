import java.io.*;
import java.util.*;

public class BOJ_실버2_17829_222풀링 {

	static int N;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		pooling(N);
		
		System.out.println(map[0][0]);
	}
	
	public static void pooling(int len) {
		if(len == 1) return;
		
		int newMap[][] = new int[len/2][len/2];
				
		for(int r=0; r<len; r+=2) {
			for(int c=0; c<len; c+=2) {
				int arr[] = new int[4];
				arr[0] = map[r][c];
				arr[1] = map[r+1][c];
				arr[2] = map[r][c+1];
				arr[3] = map[r+1][c+1];
				
				Arrays.sort(arr);
				
				newMap[r/2][c/2] = arr[2];
			}
		}
		
		map = new int[len/2][len/2];
		
		for(int i=0; i<len/2; i++) {
			for(int j=0; j<len/2; j++) {
				map[i][j] = newMap[i][j];
			}
		}
		
		pooling(len/2);
	}
		
}
