package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_브론즈3_4153_직각삼각형 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String split[] = in.readLine().split(" ");
			int num[] = new int[3];
			int check = 0;
			int max = -1;
			
			for(int i=0; i<3; i++) {
				num[i] = Integer.parseInt(split[i]);
				check += num[i];
				max = Math.max(max, num[i]);
			}
			
			if(check == 0) break;
			
			int sum = 0;
			for(int i=0; i<3; i++) {
				if(num[i] == max) continue;
				sum += num[i] * num[i];
			}
			
			if(sum == max * max) System.out.println("right");
			else System.out.println("wrong");
		}
		
	}

}
