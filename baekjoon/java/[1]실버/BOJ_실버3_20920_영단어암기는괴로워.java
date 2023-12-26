import java.io.*;
import java.util.*;

public class BOJ_실버3_20920_영단어암기는괴로워 {

  /*
   * 풀이 시간 : 30분 
   * 풀이 방법 : 자료구조 Map, 정렬 
   */
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// Map 자료구조에 빈도수와 함께 저장 
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			if(str.length() < M) continue; // 길이가 M보다 작으면 continue 
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((o1, o2) -> {
			int freqCompare = o2.getValue().compareTo(o1.getValue());
			if(freqCompare != 0) return freqCompare;
			
			int lenCompare = Integer.compare(o2.getKey().length(), o1.getKey().length());
			if(lenCompare != 0) return lenCompare;
			
			return o1.getKey().compareTo(o2.getKey());
		});
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> word : list) {
			sb.append(word.getKey()).append('\n');
		}
		
		System.out.println(sb);
		
	}
}
