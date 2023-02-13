package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_실버4_1158_요세푸스문제_list {

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		/**
		 * 1. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 2. 입력파일 객체화
		 */

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> people = new ArrayList<Integer>();
		for(int i = 1;i<=N;i++) {
			people.add(i);
		}

		sb.append("<");

		/**
		 * 3. 알고리즘 풀기
		 */

		int idx = 0;
		while(!people.isEmpty()) {
			
			idx = (idx + K - 1) % people.size();
			
			if(people.size() != 1) {
				sb.append(people.get(idx)).append(", ");
			} else {
				sb.append(people.get(idx)).append(">");
			}
			people.remove(idx);
		}

		/**
		 * 4. 정답 출력
		 */

		System.out.println(sb);
	}

}
