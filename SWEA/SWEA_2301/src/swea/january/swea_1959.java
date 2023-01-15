package harin.java.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1959 {
	
public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(in.readLine());
		
		for(int testCase=1;testCase<=T;testCase++) {
			
			sb.append("#"+testCase+" ");
			
			//수 입력
			int[] size = new int[2];
			String[] sizeInput = new String[2];
			sizeInput = in.readLine().split(" ");
			size[0] = Integer.parseInt(sizeInput[0]);
			size[1] = Integer.parseInt(sizeInput[1]);
			
			String[] aString = in.readLine().split(" ");
			String[] bString = in.readLine().split(" ");
			
			//2개의 배열 입력
			int[] a = new int[size[0]];
			int[] b = new int[size[1]];
			for(int i = 0;i<size[0];i++) {
				a[i] = Integer.parseInt(aString[i]);
			}
			for(int i=0;i<size[1];i++) {
				b[i] = Integer.parseInt(bString[i]);
			}
			
			//
			int maxValue = Integer.MIN_VALUE;
			
			if (a.length<=b.length) {
				for(int i=0;i<=b.length-a.length;i++) {
					int sum =0;
					for(int j=0;j<a.length;j++) {
						sum += a[j] * b[j+i];
					}
					if (maxValue < sum)
						maxValue = sum;
				}
			} else {
				for(int i=0;i<=a.length-b.length;i++) {
					int sum = 0;
					for(int j=0;j<b.length;j++) {
						sum += b[j] * a[j+i];
					}
					if (maxValue < sum)
						maxValue = sum;
				}
			}
			
			sb.append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}
