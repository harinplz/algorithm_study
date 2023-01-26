package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1546 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //과목 개수
		
		String[] strScores = in.readLine().split(" ");
		int[] scores = new int[strScores.length];
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<strScores.length;i++) {
			scores[i] = Integer.parseInt(strScores[i]);
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		
		double[] newScores = new double [scores.length];
		double sum = 0;
		for(int i=0;i<scores.length;i++) {
			newScores[i] = (double)scores[i] / (double)max * 100;
			sum += newScores[i];
		}
		
		System.out.println(sum/(double)newScores.length);
		
		
	}
}
