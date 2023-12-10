import java.io.*;
import java.util.*;

public class BOJ_실버1_14889_스타트와링크 {
	
	/*
	 * 풀이 시간 : 42분 31초
	 * 풀이 방법 : 조합, 구현 
	 * 메모리 : 15796KB, 시간: 272ms
	 */
	
	static int N;
	static int map[][];
	static int starts[];
	static int links[];
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		starts = new int[N/2];
		links = new int[N/2];
		combi(0, 0);

		System.out.println(ans);
	}
	
	public static void combi(int start, int cnt) {
		if (cnt == N/2) {
			// 링크 배열에 값 넣기 
			int idx = 0;
			for(int i=0; i<N; i++) {
				boolean flag = false;
				for(int num: starts) {
					if(num == i) {
						flag = true;
						break;
					}
				}
				if(!flag) links[idx++] = i;
			}
			// 나는 링크팀의 능력치를 구하기 위해 굉장히 복잡한 코드를 작성했는데
			// 스스로도 별로 안 좋은 코드라고 생각되어서 블로그를 찾아보니 .. 
			// visit 배열을 생성해서 start팀에 뽑았는지 안 뽑았는지 확인하는 코드도 있었다!
			// 이 방식으로 풀면 훨씬 더 간결하고 위의 이중 포문을 안 써도 되어서 좋은 듯 ~~ 
			
			// 스타트 팀 능력치 구하기 
			int startTeam = 0;
			for(int num1: starts) {
				for(int num2: starts) {
					if(num1 == num2) continue;
					startTeam += map[num1][num2];
				}
			}
			
			// 링크 팀 능력치 구하기 
			int linkTeam = 0;
			for(int num1: links) {
				for(int num2: links) {
					if(num1 == num2) continue;
					linkTeam += map[num1][num2];
				}
			}
			
			// 스타트팀과 링크팀의 능력치 차이 최소값 갱신하기 
			ans = Math.min(ans, Math.abs(startTeam - linkTeam));
			return;
		}
		
		for(int i=start; i<N; i++) {
			starts[cnt] = i;
			combi(i+1, cnt+1);
		}
	}
	
}
