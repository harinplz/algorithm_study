import java.io.*;
import java.util.*;

public class BOJ_실버5_1475_방번호_1 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String N = in.readLine();
		List<Set<Integer>> list = new ArrayList<>();
		
		list.add(new HashSet<Integer>());
		
		for(int i=0; i<N.length(); i++) {
			int num = N.charAt(i) - '0';
			
			int size = list.size();
			boolean flag = false;
			for(int j=0; j<size; j++) {
				if(!list.get(j).contains(num)) {
					flag = true;
					list.get(j).add(num);
				}
				
				if(flag) break;
				
				// 6이거나 9일 때 처리를 해줘야함. 
				if(num == 6 && !list.get(j).contains(9)) {
					flag = true;
					list.get(j).add(9);
				}
				else if(num == 9 && !list.get(j).contains(6)) {
					flag = true;
					list.get(j).add(6);
				}
				
				if(flag) break;
			}
			if(!flag) {
				list.add(new HashSet<Integer>());
				list.get(list.size() - 1).add(num);
			}
		}
		

		System.out.println(list.size());
	}
	
}
