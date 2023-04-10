import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_실버4_1764_듣보잡 {
	
	/*
	 * 메모리 25290KB 시간 388ms
	 * 
	 * 리스트로 푸니까 안 풀렸던 문제가 HashSet 쓰니까 바로 풀렸다 ...
	 * HashSet과 ArrayList에 둘 다 존재하는 contains 함수는 HashSet에서 속도가 매우 빠르다!!
	 * 
	 * HashSet은 비선형 구조로 순서가 없고 인덱스도 존재하지 않음.
	 * 데이터가 있는 지 확인할 때 모든 데이터를 찾아보는 것이 아니라 데이터를 key로 순서와 상관없이 바로 찾아냄.
	 * 
	 * ArrayList는 중복을 허용하고 순서를 보장하기 때문에
	 * contains 함수를 사용할 때 처음 순차적으로 데이터 탐색을 진행하면서 값을 찾기 때문에 시간이 오래걸린다.
	 */

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> notHear = new HashSet<>();
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			notHear.add(in.readLine());
		}
		for(int i=0; i<M; i++) {
			String name = in.readLine();
			if(notHear.contains(name)) set.add(name);
		}
		
		Set<String> treeSet = new TreeSet<>(set);
		
		System.out.println(treeSet.size());
		for(String name : treeSet) {
			System.out.println(name);
		}
		
	}

}
