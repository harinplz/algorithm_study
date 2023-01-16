package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2587 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int [] arr = new int[5];
		int sum =0;
		
		for(int i=0;i<5;i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		
		//평균
		System.out.println(sum/5);
		
		//중앙값
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(arr[2]);

	}

}
