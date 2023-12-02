import java.io.*;
import java.util.*;

public class BOJ_실버5_10867_중복빼고정렬하기
{

  // 풀이 시간 : 9분 10초
  // 풀이 방법 : TreeSet 자료구조 사용
  // 메모리 : 24940KB, 시간 : 296MS 
  
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine()); // N 입력 받기
		
		TreeSet<Integer> set = new TreeSet<>(); // 트리셋 선언 
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N;i++) {
		    set.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator iter = set.iterator(); // 반복자 사용 
		while(iter.hasNext()) {
		    sb.append(iter.next() + " ");
		}
		
		System.out.println(sb);
		
	}
}
