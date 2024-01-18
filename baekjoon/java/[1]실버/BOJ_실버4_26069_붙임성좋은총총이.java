import java.io.*;
import java.util.*;

public class BOJ_실버4_26069_붙임성좋은총총이 {
	
	/*
	 * 풀이 시간 : 시간을 재는 걸 깜빡했다 (ㅠㅠ)
	 * 풀이 방법 : 자료구조 (맵) 
	 * 메모리 : 12596KB, 시간 : 100ms 
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("ChongChong", true);
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			
			if(map.containsKey(name1) && map.get(name1) == true) {
				map.put(name2, true);
			}
			else if(map.containsKey(name2) && map.get(name2) == true) {
				map.put(name1, true);
			}
		}
		
		System.out.println(map.size());
		
	}
		
}
