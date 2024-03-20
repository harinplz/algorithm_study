import java.io.*;
import java.util.*;

public class BOJ_실버3_1072_게임 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		int Z = (int)(100*Y/X);
		
		long cnt = 0;
		if(Z >= 99) {
			System.out.println(-1);
			return;
		}
		
		int min = 1;
		int max = 1000000000;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			double newY = Y + mid;
			double newX = X + mid;
			int newZ = (int)(100*newY/newX);
			
			if(newZ == Z) {
				min = mid + 1;
			}
			else {
				cnt = mid;
				max = mid - 1;
			}
		}
		
		
		System.out.println(cnt);
	}
	
}
