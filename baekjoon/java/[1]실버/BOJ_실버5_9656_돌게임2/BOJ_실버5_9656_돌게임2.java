import java.io.*;
import java.util.*;

public class BOJ_실버5_9656_돌게임2 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		boolean skWin = true;
		while(N != 0) {
			if(N >= 3) N-=3;
			else N-=1;
			skWin = !skWin;
		}
		
		String str = skWin ? "SK" : "CY";
		System.out.println(str);
	}
	
}
