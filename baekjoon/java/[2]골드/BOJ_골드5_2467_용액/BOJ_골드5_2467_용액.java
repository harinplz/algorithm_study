import java.io.*;
import java.util.*;

public class BOJ_골드5_2467_용액 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		};
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, comparator);;
		
		int num1 = 0;
		int num2 = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N-1; i++) {

			int n1 = list.get(i);
			int n2 = list.get(i+1);
			if(min > Math.abs(n1 + n2)) {
				min = Math.abs(n1 + n2);
				num1 = n1;
				num2 = n2;
			}
		}
		
		if(num1 < num2) System.out.println(num1 + " " + num2);
		else System.out.println(num2 + " " + num1);
	}


}
