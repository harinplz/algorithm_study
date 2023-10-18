import java.io.*;
import java.util.*;

public class BOJ_브론즈3_23971_ZOAC4 {

  /*
    브론즈인데 왜 이렇게 생각하는게 어렵지 ... ? 
    너무 복잡하게 생각해서 그런 것 같다 ... Math.ceil 함수는 올림 함수니까 기억하기 !!
  */

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		double first = Math.ceil((double)H/(N+1));
		double second = Math.ceil((double)W/(M+1));
		
		System.out.println((int)(first*second));
	}
	
}
