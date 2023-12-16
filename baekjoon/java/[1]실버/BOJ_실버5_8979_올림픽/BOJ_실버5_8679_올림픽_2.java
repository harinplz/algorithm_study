import java.io.*;
import java.util.*;

public class BOJ_실버5_8679_올림픽_2 {

  /*
   * 초기에 정렬 방법으로 푼 방식이다. 
   * 이렇게 풀어도 풀리긴 풀리나 ... 코드가 너무 복잡해서 첫 번째 방법으로 구현하는 것이 나아보인다!
   */
	
	static class Olympic implements Comparable<Olympic> {
		int nationNo;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Olympic(int nationNo, int gold, int silver, int bronze) {
			this.nationNo = nationNo;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		// 정렬 조건문 
		@Override
		public int compareTo(Olympic o) {
			if(this.gold >= o.gold) {
				if(this.gold == o.gold) { // 금메달 수가 같을 경우 
					if(this.silver >= o.silver) {
						if(this.silver == o.silver) {
							if(this.bronze >= o.bronze) {
								if(bronze == o.bronze) {
									return 0;
								}
								return -1;
							}
							else return 1; // 동메갈 수가 적을 경우 
						}
						return -1; // 은메달 수가 많을 경우 
					}
					else return 1; // 음메달 수가 적을 경우 
				}
				return -1;
			}
			else return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Olympic> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int nationNo = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			list.add(new Olympic(nationNo, gold, silver, bronze));
		}
		
		Collections.sort(list); // 정렬 
		
		// 동점자 처리 
		list.get(0).rank = 1; // 정렬한 리스트에서 첫번째 요소의 순위는 1등이다. 
		for(int i=1; i<N; i++) {
			if(list.get(i).compareTo(list.get(i-1)) == 0) { // 이전 값과 동점자면?
				list.get(i).rank = list.get(i-1).rank; // rank를 같은 값으로 넣음. 
			} else { // 동점이 아니라면?
				list.get(i).rank = i + 1; // 현재 순위를 그대로 넣기 (이걸 떠올리지 못했다!! ㅠㅠ)
			}
		}

		for(Olympic o : list) {
			if(o.nationNo == K) {
				System.out.println(o.rank);
				break;
			}
		}
		
	}
	
	
}
