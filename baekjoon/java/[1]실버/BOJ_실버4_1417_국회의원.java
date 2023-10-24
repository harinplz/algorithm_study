import java.io.*;
import java.util.*;

public class BOJ_실버4_1417_국회의원 {

  // 풀이 시간 : 18분 24초
  // 단순 반복문 구현 문제

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 후보의 수 입력 받기
		int N = Integer.parseInt(in.readLine());
		
		// N만큼 반복하여 각 후보의 지지자 입력 받기
		int vote[] = new int[N];
		for(int i=0; i<N; i++) {
			vote[i] = Integer.parseInt(in.readLine());
		}
		
		int ans = 0; // 정답, 다솜이가 매수하는 사람의 수 
		
		// vote[0]값이 제일 크고 유일할 때 까지 while문을 통해 반복한다.
		while(true) {
			boolean isSame = false; // 유일한 지 확인
			int maxVote = Integer.MIN_VALUE; // 최댓값 찾기
			int maxIdx = 0; // 최댓값을 가진 idx 불러오기
			
			for(int i=0; i<N; i++) {
				if(vote[i] >= maxVote) { // vote의 값이 maxVote보다 크거나 같다면?
					maxVote = vote[i];
					maxIdx = i;
				}
				if(i>0 && vote[i] == vote[0]) { // vote의 값이 다솜이의 vote 값과 같을 경우 
					isSame = true;
				}
			}
			
			if(!isSame && maxVote == vote[0]) { // 만약 종료 조건이 만족할 경우에는 ans 출력 
				System.out.println(ans);
				return;
			}
			// 아니라면 제일 큰 수의 지지자의 후보의 지지자 수를 감소시킨다. 
			ans++;
			vote[0]++;
			vote[maxIdx]--;
		}
	}
	
}
