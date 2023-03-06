import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_16926_배열돌리기1 {
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); //R은 회전 횟수

		int arr[][] = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 알고리즘 풀기

		for(int k = 0;k<R;k++) {

			int [][] temp = new int[N][M];
			int cur0 = 0;
			int curM = M;
			int curN = N;

			for(int i = 0; i<Math.min(N,M) / 2;i++) {

				for(int j = curM-2; j>=cur0;j--) { //좌
					temp[cur0][j] = arr[cur0][j+1];
				}
				for(int j = curN-2 ; j>=cur0;j--) { //상
					temp[j][curM-1] = arr[j+1][curM-1];
				}
				for(int j = cur0 + 1; j<curM;j++) { //우
					temp[curN-1][j] = arr[curN-1][j-1];
				}
				for(int j = cur0 + 1 ; j<curN;j++) { //하
					temp[j][cur0] = arr[j-1][cur0];
				}

				cur0++;
				curM--;
				curN--;

			}

			for(int i = 0;i<N;i++) {
				for(int j =0;j<M;j++)
					arr[i][j] = temp[i][j];
			}
		}



		for(int i = 0;i<N;i++) {
			for(int j =0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
