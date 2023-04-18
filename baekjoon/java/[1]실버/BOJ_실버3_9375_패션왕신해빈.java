import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_실버3_9375_패션왕신해빈 {
	
	//메모리 11836KB, 시간 84ms

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		StringTokenizer st = null;
		while(T-->0) {
			map.clear();
			int tc = Integer.parseInt(in.readLine());
			int sum;
			while(tc-->0) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				String key = st.nextToken();
				
				map.put(key, map.getOrDefault(key, 0) + 1);
			
			}
			
			if(map.size() == 1) {
				sum = 0;
				for(String key : map.keySet()) {
					sum += map.get(key);
				}
				sb.append(sum).append('\n');
			}
			else {
				sum = 1;
				for(String key : map.keySet()) {
					sum *= (map.get(key)+1);
				}
				sum -= 1; //알몸 개수 빼주기 
				sb.append(sum).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

}
