import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(map.get(o2), map.get(o1));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int num : list) {
			for(int i=0; i<map.get(num); i++) {
				sb.append(num + " ");
			}
		}
		
		System.out.println(sb);
		
	}
	
}
