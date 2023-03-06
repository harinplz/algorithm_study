package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_브론즈1_1546_평균 {
	
	/*
	 * 메모리 14344KB 시간 128ms
	 * 변수형 잘 확인하기
	 */
	
	// 1. 세준이 자기 점수 중에 최댓값 고름 M
	// 2. 모든 점수를 점수 / M * 100으로 고침
	// 3.  새로운 평균을 구함
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //시험 본 과목의 개수 N
		double[] scores = new double[N]; //점수 배열
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		double max = Double.MIN_VALUE; //최댓값 담는 배열
		
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(st.nextToken()); //점수 넣기
			max = Math.max(scores[i], max); //max값 갱신
		}
	
		//모든 점수 고치기
		double sum = 0; //평균을 구하기 위해서 합 저장
		for(int i=0; i<N; i++) {
			scores[i] = scores[i] / max * 100;
			sum += scores[i];
		}
		
		System.out.println(sum/N);
		
	}
	
}
