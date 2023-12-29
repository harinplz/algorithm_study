import java.io.*;
import java.util.*;

public class BOJ_실버5_2891_카약과강풍 {
	
	/*
	 * 풀이 시간 : 20분 
	 * 풀이 방법 : 그리디 
	 * 메모리 : 11444KB, 시간 : 76ms 
	 */
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 팀의 수 
		int S = Integer.parseInt(st.nextToken()); // 카약이 손상된 팀의 수 
		int R = Integer.parseInt(st.nextToken()); // 카약을 하나 더 가져온 팀의 수 
		
		// kayak의 수를 저장하는 2차원 배열 
		// kayak[번호][0]에는 원래 가지고 있는 카약의 수를 kayak[번호][1]에는 다른 팀에게 빌린 카약의 수를 저장한다. 
		int[][] kayak = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			kayak[i][0] = 1;
		}
		
		// 카약이 손상된 팀의 번호 
		st = new StringTokenizer(in.readLine());
		
		while(S-->0) {
			// 카약이 손상되었다면 카약의 수를 감소시킨다. 
			kayak[Integer.parseInt(st.nextToken())][0]--;
		}
		
		// 카약을 하나 더 가져온 팀의 번호 
		st = new StringTokenizer(in.readLine());
		
		while(R-->0) {
			// 카약을 하나 더 들고왔다면 카약의 수를 증가시킨다. 
			kayak[Integer.parseInt(st.nextToken())][0]++;
		}
		
		// 손상된 후 카약을 빌려주는 과정 
		for(int i=1; i<=N; i++) {
			if(kayak[i][0] == 0) { // 만약 카약의 수가 0이라면?  
				if(kayak[i-1][0] == 2) { // 카약의 번호가 1 작은 애한테서 빌려온다. 
					kayak[i][1]++;
					kayak[i-1][0]--;
					continue;
				}
				else if(i == N) continue; // ArrayIndexOut을 막기 위해서 처리 
				else if(kayak[i+1][0] == 2) { // 카약의 번호가 1 큰 애한테서 빌려온다. 
					kayak[i][1]++;
					kayak[i+1][0]--;
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int sum = kayak[i][0] + kayak[i][1]; // 자신의 원래 카약과 빌린 카약의 수를 더한다. 
			if(sum == 0) ans++; // 만약 0개라면 출전을 하지 못하므로 값을 증가한다. 
		}
		
		System.out.println(ans);
	}
	
}
