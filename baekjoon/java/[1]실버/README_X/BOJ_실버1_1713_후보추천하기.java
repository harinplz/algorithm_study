package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_실버1_1713_후보추천하기 {
	
	//1. 리스트 생성해서 집어 넣기
	//2. 학생 클래스 생성? -> 추천 순으로 정렬
	//3. 입력 받는데 조건
	//3-1. 리스트에 이미 존재하는가? 존재하면 해당 애의 추천을 +1 해준다. 
	//3-2. 리스트에 존재하지 않은 애를 넣으려고 하는데 리스트 사이즈가 N을 넘는가? 
	// 3-2-1. 넘는다면 제일 추천수가 적은 애를 remove하고 넣어준다.
	//4. 마지막에 no가 정렬된 순서대로 출력 (no를 말고는 아마 들어간 순서대로 정렬 되있긴 할 것이다.)
	
	static class Student implements Comparable<Student>{
		int no;
		int recommend;

		public Student(int no, int recommend) {
			super();
			this.no = no;
			this.recommend = recommend;
		}

		@Override
		public int compareTo(Student o) {
			return Integer.compare(this.no, o.no);
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", recommend=" + recommend + "]";
		}
		
		
		
	}
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //사진틀의 개수
		int recCnt = Integer.parseInt(in.readLine()); //추천 횟수
		
		st = new StringTokenizer(in.readLine()); //추천 받은 학생을 나타내는 번호
		
		List<Student> list = new ArrayList<Student>();
		
		for(int i=0; i<recCnt; i++) {
			boolean isPossible = true;
			int recNo = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<list.size();j++) {
				if(list.get(j).no == recNo) {
					list.get(j).recommend += 1;
					isPossible = false;
					break;
				}
			}
			
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			if(isPossible) {
				if(list.size() >= N) {
					//제일 작은 추천수를 가진 친구 삭제
					// 근데 그렇다고 들어오는 순서가 바뀌면 안된다. 
					
					//그냥 제일 작은 애 찾기
					for(int j=0; j<list.size(); j++) {
						int rec = list.get(j).recommend;
						if(min > rec) {
							min = rec;
							minIdx = j;
						} 
					}
					
					list.remove(minIdx);
				}
				list.add(new Student(recNo, 1));
			}
		}
		
		Collections.sort(list);
		
		for(Student st : list) {
			sb.append(st.no).append(' ');
		}
		
		System.out.println(sb);
	}
	
}
