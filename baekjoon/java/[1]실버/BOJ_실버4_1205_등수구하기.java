import java.io.*;
import java.util.*;

public class BOJ_실버4_1205_등수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 랭킹 리스트에 올라갈 수 있는 점수의 개수 P
		// 태수의 새로운 점수가 랭킹리스트에서 몇 등 하는지 구하는 프로그램 
		// 만약 랭킹 리스트가 꽉 차 있을 때 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 현재 리스트에 있는 점수 N개
		int newScore = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수 
		int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라갈 수 있는 점수의 개수 

		if(N==0) {
			System.out.println(1);
		}
		else {
			// 랭킹 리스트 배열 만들기 
			int rankingList[] = new int[P];

			// 랭킹 리스트에 값 입력받기 
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<P; i++) {
				if(i < N) rankingList[i] = Integer.parseInt(st.nextToken());
				else rankingList[i] = -1; // 비어있는 값은 -1로 초기화
			}

			// 태수의 새로운 점수 비교  
			// 1. 랭킹 리스트에 들어갈 수 없을 경우
			if(rankingList[P-1] >= newScore)
				System.out.println(-1);
			// 2. 랭킹 리스트에 들어갈 수 있을 경우
			else {
				for(int i=0; i<P; i++) {
					// 일단 새로운 점수보다 작거나 같은 값을 찾는다.
					// 만약에 작거나 같을 경우엔 해당 값이 위치한 값의 인덱스를 출력하면 된다. 
					if(rankingList[i] <= newScore) {
						System.out.println(i+1);
						break;
					}
				}
			}
		}
	}

}
