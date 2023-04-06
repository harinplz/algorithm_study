import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_실버4_10816_숫자카드2 {
	
	static StringBuilder sb = new StringBuilder();
	
	// 숫자 카드 
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//맵 생성
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				sb.append(map.get(key)).append(' ');
			}
			else sb.append("0 ");
		}
		
		System.out.println(sb);
	}
	
}