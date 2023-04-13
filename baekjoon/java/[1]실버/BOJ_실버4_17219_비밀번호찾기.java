import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_실버4_17219_비밀번호찾기 {
	
	// 메모리 63772KB 시간 524ms
	// 맵 자료구조 사용
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, String> map = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(N-->0) {
			st = new StringTokenizer(in.readLine());
			
			map.put(st.nextToken(), st.nextToken());
		}
		
		while(M-->0) {
			String url = in.readLine();
			sb.append(map.get(url)).append('\n');
		}
		
		System.out.println(sb);
	}
	
}
