package ssafy.com.역량대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	
	/**
	 * 코드가 중복되는 것도 많아서 함수로 바꿔주면 코드 길이를 줄일 수 있을 것 같은데
	 * 
	 */
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//테케 입력
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1 ; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[N][N]; //map 생성
			
			//지형의 높이 입력 받기
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//알고리즘 풀기
			int result = 0; //활주로 건설 가능 개수
			
			//가로부터 확인 (행)
			for(int i=0; i<N; i++) {
				boolean isPossible = true;
				int j = 1;
				int height = map[i][0];
				int cnt = 1;
				
				while(j != N) {
					if(Math.abs(height - map[i][j]) > 1) {
						isPossible = false; break;
					}
					if(height > map[i][j]) { //이전 높이가 현재 높이보다 크다면?
						height = map[i][j];
						cnt = 1;
						for(int k=j+1; k<N; k++) {
							if(height != map[i][k]) break;
							cnt++;
							j = k; //현재 탐색한 열 위치 k로 변경
						}
						if(cnt < X) { //cnt 길이가 x 길이보다 작다면? 건설 불가능. 
							isPossible = false; break;
						}
						if(cnt >= X) { //cnt 길이가 x 길이보다 작거나 같을때?
							// 범위를 벗어났는지 확인해야함. 
							if(!(0 <= j && j < N)) { //범위에 안 벗어났다면? 
								isPossible = false; break;
							}
						}
						cnt = cnt - X;
						j++;
					}
					else if(height < map[i][j]) { //이전 높이가 현재 높이보다 작다면?
						height = map[i][j];
						if(cnt < X) { //cnt 길이가 x 길이보다 작다면? 건설 불가능. 
							isPossible = false; break;
						}
						if(cnt >= X) { //cnt 길이가 x 길이보다 작거나 같을때?
							// 범위를 벗어났는지 확인해야함. 
							if(!(0 <= j - cnt && j-cnt < N)) { //범위에 안 벗어났다면? 
								isPossible = false; break;
							}
						}
						cnt = 1; 
						j++;
					}
					else {
						j++; 
						cnt++;
					}
				}
				result = (isPossible) ? result + 1 : result;
			}
			
			//세로 확인 (열)
			for(int i=0; i<N; i++) {
				boolean isPossible = true;
				int j = 1;
				int height = map[0][i];
				int cnt = 1;
				
				while(j != N) {
					if(Math.abs(height - map[j][i]) > 1) {
						isPossible = false; break;
					}
					if(height > map[j][i]) { //이전 높이가 현재 높이보다 크다면?
						height = map[j][i];
						cnt = 1;
						for(int k=j+1; k<N; k++) {
							if(height != map[k][i]) break;
							cnt++;
							j = k; //현재 탐색한 위치 k로 변경
						}
						if(cnt < X) { //cnt 길이가 x 길이보다 작다면? 건설 불가능. 
							isPossible = false; break;
						}
						if(cnt >= X) { //cnt 길이가 x 길이보다 작거나 같을때?
							// 범위를 벗어났는지 확인해야함. 
							if(!(0 <= j && j < N)) { //범위에 안 벗어났다면? 
								isPossible = false; break;
							}
						}
						cnt = cnt - X;
						j++;
					}
					else if(height < map[j][i]) { //이전 높이가 현재 높이보다 작다면?
						height = map[j][i];
						if(cnt < X) { //cnt 길이가 x 길이보다 작다면? 건설 불가능. 
							isPossible = false; break;
						}
						if(cnt >= X) { //cnt 길이가 x 길이보다 작거나 같을때?
							// 범위를 벗어났는지 확인해야함. 
							if(!(0 <= j - cnt && j-cnt < N)) { //범위에 안 벗어났다면? 
								isPossible = false; break;
							}
						}
						cnt = 1; 
						j++;
					}
					else {
						j++; 
						cnt++;
					}
				}
				result = (isPossible) ? result + 1 : result;
			}
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}