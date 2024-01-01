import java.io.*;
import java.util.*;

public class BOJ_실버5_14729_칠무해 {
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); // 학생 수 
		double score[] = new double[N]; // 점수 저장 배열 
		
		for(int i=0; i<N; i++) {
			score[i] = Double.parseDouble(in.readLine());
		}
		
		Arrays.sort(score); // 오름차순 정렬 
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<7; i++) {
			sb.append(String.format("%.3f", score[i])).append('\n'); // 소수점 3자리 까지 출력 
		}
		
		System.out.println(sb);
	}
}
