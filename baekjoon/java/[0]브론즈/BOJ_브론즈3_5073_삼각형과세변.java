import java.io.*;
import java.util.*;

public class BOJ_브론즈3_5073_삼각형과세변 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] tri = new int[3];
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());
			
			if(tri[0]==0 && tri[1]==0 && tri[2]==0) break;
			
			
			// 가장 긴 변의 길이가 나머지 두 변의 길이의 합보다 길지 않으면 ...
			Arrays.sort(tri);
			if(tri[2] >= tri[0] + tri[1]) sb.append("Invalid\n");
			else if(tri[0]==tri[1] && tri[1] == tri[2]) sb.append("Equilateral\n");
			else if((tri[0]==tri[1]) || (tri[1]==tri[2]) || tri[2]==tri[0]) sb.append("Isosceles\n");
			else if(tri[0] != tri[1] && tri[1] != tri[2] && tri[2] != tri[0]) sb.append("Scalene\n");
		}
		
		System.out.println(sb);

	}
	
}
